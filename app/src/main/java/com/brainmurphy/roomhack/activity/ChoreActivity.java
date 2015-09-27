package com.brainmurphy.roomhack.activity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.brainmurphy.roomhack.ChoreCardAdapter;
import com.brainmurphy.roomhack.R;
import com.brainmurphy.roomhack.fragment.AddChoreFragment;
import com.brainmurphy.roomhack.model.Chore;
import com.brainmurphy.roomhack.model.Roommate;

import java.util.ArrayList;

public class ChoreActivity extends AppCompatActivity implements AddChoreFragment.ChoreAddListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chore);
        recyclerView = (RecyclerView) findViewById(R.id.card_recyler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Roommate brian = new Roommate();
        brian.setName("Brian");
        Roommate matt = new Roommate();
        ArrayList<Roommate> roomates = new ArrayList<Roommate>();
        roomates.add(brian);
        roomates.add(matt);

        matt.setName("Matt");
        Chore c1 = new Chore();
        c1.setName("Take out trash");
        c1.setDescription("Lorem ipsum dolor sit amet");
        c1.setAssignees(roomates);

        Chore c2 = new Chore();
        c2.setName("Do Dishes");
        c2.setDescription("Lorem ipsum dolor sit amet");
        c2.setAssignees(roomates);

        Chore[] chores = new Chore[]{c1,c2};

        // specify an adapter (see also next example)
        adapter = new ChoreCardAdapter(this, chores);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chore, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onChoreAdded(Chore chore) {
        Fragment frag = getFragmentManager().findFragmentByTag(ChoreCardAdapter.CHORE_FRAG_TAG_PREFIX);
        getFragmentManager().beginTransaction()
                .remove(frag)
                .commit();
        //TODO update cards if chore new
    }

    @Override
    public void onChoreDeleted(Chore chore) {
        Fragment frag = getFragmentManager().findFragmentByTag(ChoreCardAdapter.CHORE_FRAG_TAG_PREFIX);
        getFragmentManager().beginTransaction()
                .remove(frag)
                .commit();

        //TODO remove chore
    }
}
