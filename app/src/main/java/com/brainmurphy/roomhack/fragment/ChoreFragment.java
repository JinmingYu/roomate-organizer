package com.brainmurphy.roomhack.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brainmurphy.roomhack.R;
import com.brainmurphy.roomhack.model.Chore;
import com.brainmurphy.roomhack.model.Roommate;

import java.util.Date;


public class ChoreFragment extends Fragment {

    private OnChoreFragmentClickListener mListener;
    private Chore chore;

    public ChoreFragment() {
        // Required empty public constructor
    }

    public void setChore(Chore chore) {
        this.chore = chore;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_chore, container, false);

        ((TextView) root.findViewById(R.id.titleTextView)).setText(chore.getName());
        ((TextView) root.findViewById(R.id.deleteTextView)).setText(chore.getDescription());
        Date d = chore.getDeadline();
        ((TextView) root.findViewById(R.id.dueTextView)).setText(String.format("%2d/%2d/%4d %2d:%2d", d.getMonth(), d.getDate(),
                d.getYear(), d.getHours(), d.getMinutes()));

        StringBuilder builder = new StringBuilder();
        for (Roommate roomate : chore.getAssignees()) {
            builder.append(roomate.getName());
            builder.append(", ");
        }
        ((TextView) root.findViewById(R.id.assigneesTextView)).setText(chore.getAssignees().size() > 0 ? builder.substring(0, builder.length() - 2) : builder.toString());

        root.findViewById(R.id.choreLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.fragmentClicked(chore, ChoreFragment.this);
            }
        });

        return root;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnChoreFragmentClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnChoreFragmentClickListener {
        public void fragmentClicked(Chore chore, Fragment fragment);
    }

}
