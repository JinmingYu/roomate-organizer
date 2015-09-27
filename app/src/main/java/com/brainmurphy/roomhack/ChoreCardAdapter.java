package com.brainmurphy.roomhack;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brainmurphy.roomhack.data.RoommateDatasource;
import com.brainmurphy.roomhack.fragment.AddChoreFragment;
import com.brainmurphy.roomhack.fragment.ChoreFragment;
import com.brainmurphy.roomhack.model.Chore;
import com.brainmurphy.roomhack.model.Roommate;
import com.google.android.gms.games.multiplayer.realtime.Room;

import java.util.Date;
import java.util.List;

import retrofit.Retrofit;

/**
 * Created by brian on 9/26/15.
 */
public class ChoreCardAdapter extends RecyclerView.Adapter<ChoreCardAdapter.ViewHolder> {

    public static String CHORE_FRAG_TAG_PREFIX = "choreFrag#";

    private Activity context;
    Chore[] chores;

    public ChoreCardAdapter(Activity context, Chore[] chores) {
        this.context = context;
        this.chores = chores;
    }

    @Override
    public ChoreCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chore_card_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(ChoreCardAdapter.ViewHolder holder, final int position) {
        final Chore chore = chores[position];
        View root = holder.view;
        ((TextView) root.findViewById(R.id.titleTextView)).setText(chore.getName());
        ((TextView) root.findViewById(R.id.descriptionTextView)).setText(chore.getDescription());
        Date d = chore.getDeadline();
        try {
            ((TextView) root.findViewById(R.id.dueTextView)).setText(String.format("%2d/%2d/%4d %2d:%2d", d.getMonth(), d.getDate(),
                    d.getYear(), d.getHours(), d.getMinutes()));
        }catch (NullPointerException ne) {
            Log.e("DEV", "mock data breaks dueTextView logic");
        }
        StringBuilder builder = new StringBuilder();
        for (Roommate roomate : chore.getAssignees()) {
            builder.append(roomate.getName());
            builder.append(", ");
        }
        ((TextView) root.findViewById(R.id.assigneesTextView)).setText(chore.getAssignees().size() > 0 ? builder.substring(0, builder.length() - 2) : builder.toString());

        root.findViewById(R.id.choreLayout).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AddChoreFragment addChoreFragment = new AddChoreFragment();
                addChoreFragment.setChore(chore);
                context.getFragmentManager().beginTransaction()
                        .add(addChoreFragment, CHORE_FRAG_TAG_PREFIX)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return chores.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }
}
