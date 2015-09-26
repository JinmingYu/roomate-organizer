package com.brainmurphy.roomhack.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.datetimepicker.date.DatePickerDialog;
import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.TimePickerDialog;
import com.brainmurphy.roomhack.R;
import com.brainmurphy.roomhack.data.RoommateDatasource;
import com.brainmurphy.roomhack.model.Chore;
import com.brainmurphy.roomhack.model.Roommate;
import com.google.android.gms.games.multiplayer.realtime.Room;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit.http.Body;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddChoreFragment.ChoreAddListener} interface
 */
public class AddChoreFragment extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private ChoreAddListener mListener;

    private static final String  DATEPICKER_TAG = "datepicker";
    private static final String TIMEPICKER_TAG = "timepicker";

    private Chore chore;
    private TimePickerDialog timePicker;

    private EditText dueEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setChore(Chore chore) {
        this.chore = chore;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (chore == null) {
            chore = new Chore();
        }

        Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePicker = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        timePicker = TimePickerDialog.newInstance(this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);

        View root = inflater.inflate(R.layout.fragment_add_chore, container, false);
        ((EditText) root.findViewById(R.id.titleEditText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                chore.setName(s.toString());
            }
        });
        ((EditText) root.findViewById(R.id.descriptionEditText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                chore.setDescription(s.toString());
            }
        });
        dueEditText = (EditText) root.findViewById(R.id.dueEditText);
        dueEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show(getFragmentManager(), DATEPICKER_TAG);
            }
        });

        root.findViewById(R.id.assigneesEditText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoommateDatasource datasource = new RoommateDatasource() {
                    private ArrayList<Roommate> roomates = new ArrayList<>();
                    @Override
                    public List<Roommate> getRoomates() {
                        return roomates;
                    }

                    @Override
                    public void postRoomate(@Body Roommate roomate) {
                        roomates.add(roomate);
                    }
                };
                datasource.postRoomate(new Roommate("brain", "0", null, null, null,null,null, 0));
                datasource.postRoomate(new Roommate("biff", "1", null, null, null, null, null, 0));
                String[] roomateNames = new String[datasource.getRoomates().size()];
                for (int i = 0; i < roomateNames.length; i++) {
                    roomateNames[i] = datasource.getRoomates().get(i).getName();
                }
                new MaterialDialog.Builder(getActivity())
                        .title("Which Roomates?")
                        .items(roomateNames)
                        .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                /**
                                 * If you use alwaysCallMultiChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected check box to actually be selected.
                                 * See the limited multi choice dialog example in the sample project for details.
                                 **/
                                return true;
                            }
                        })
                        .positiveText("Done")
                        .show();
            }
        });

        root.findViewById(R.id.doneTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onChoreAdded(chore);
            }
        });

        root.findViewById(R.id.deleteTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onChoreDeleted(chore);
            }
        });

        return root;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (ChoreAddListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ChoreAddListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onTimeSet(RadialPickerLayout radialPickerLayout, int hour, int min) {
        chore.getDeadline().setHours(hour);
        chore.getDeadline().setMinutes(min);
        Date d = chore.getDeadline();
        dueEditText.setText(String.format("%2d/%2d/%4d %2d:%2d", d.getMonth(), d.getDate(),
                d.getYear(), d.getHours(), d.getMinutes()));
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        if (chore.getDeadline() == null) {
            chore.setDeadline(new Date());
        }
        chore.getDeadline().setYear(year);
        chore.getDeadline().setMonth(month);
        chore.getDeadline().setDate(day);
        timePicker.show(getFragmentManager(), TIMEPICKER_TAG);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ChoreAddListener {
        public void onChoreAdded(Chore chore);
        public void onChoreDeleted(Chore chore);
    }

}
