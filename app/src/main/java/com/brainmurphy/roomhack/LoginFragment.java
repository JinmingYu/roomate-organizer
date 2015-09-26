package com.brainmurphy.roomhack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    private LoginOrRegisterListener listener;
    private boolean isRegistering;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = null;
        if (getActivity().getIntent().getBooleanExtra("shouldShowRegistration", false)) {
            root = inflater.inflate(R.layout.fragment_register, container, false);
            isRegistering = true;
        } else {
            root = inflater.inflate(R.layout.fragment_login, container, false);
        }

        final View finalRoot = root;
        root.findViewById(R.id.goButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) finalRoot.findViewById(R.id.userNameTextBox)).getText().toString();
                String pass = ((EditText) finalRoot.findViewById(R.id.passwordTextBox)).getText().toString();
                SharedPreferences prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);

                if (isRegistering) {
                    String passConfirm = ((EditText) finalRoot.findViewById(R.id.passwordRepeatTextBox)).getText().toString();
                    if (!pass.equals(passConfirm)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Passwords don't match!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("username", username);
                        editor.putString("password", pass);
                        editor.putBoolean("loggedIn", true);
                        editor.apply();
                        startActivity(new Intent(getActivity(), Dashboard.class));
                    }
                } else {
                    if (prefs.getString("username", "asdfasdf").equals(username) && prefs.getString("password", "asdfasdf").equals(pass)) {
                        prefs.edit().putBoolean("loggedIn", true).apply();
                        startActivity(new Intent(getActivity(), Dashboard.class));
                    }
                }
            }
        });
        return root;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof LoginOrRegisterListener) {
            listener= (LoginOrRegisterListener)activity;
        } else {
            throw new ClassCastException("Activity must implement LoginOrRegisterListener");
        }

    }


    public interface LoginOrRegisterListener {
        public void OnLoginOrRegister();
    }
}
