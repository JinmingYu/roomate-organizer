package com.brainmurphy.roomhack.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.brainmurphy.roomhack.CONST;
import com.brainmurphy.roomhack.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin, bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSharedPreferences(CONST.PREFS, MODE_PRIVATE).getBoolean(CONST.IS_LOGGED_IN, false)) {
            startActivity(new Intent(this, Dashboard.class));
        }

        bLogin = (Button) findViewById(R.id.bLogIn);
        bLogin.setOnClickListener(this);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
//        Intent logInIntent = new Intent(MainActivity.this, Login.class);
//        startActivity(logInIntent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        if (v.getId() == R.id.bRegister) {
            intent.putExtra(CONST.SHOULD_SHOW_REGISTRATION, true);
        }
        startActivity(intent);
    }
}