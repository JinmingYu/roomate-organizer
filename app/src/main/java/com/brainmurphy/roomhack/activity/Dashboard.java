package com.brainmurphy.roomhack.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;


import com.brainmurphy.roomhack.R;
import com.brainmurphy.roomhack.data.TaskDatasource;
import com.brainmurphy.roomhack.model.Chore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Retrofit;
import retrofit.http.Body;

public class Dashboard extends ActionBarActivity {
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter ArrayAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    ListView mNotificationList;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:3000")
            .build();



    // This is the Adapter being used to display the list's data
    SimpleAdapter mAdapter;

    // These are the Contacts rows that we will retrieve
    static final String[] PROJECTION = new String[] {ContactsContract.Data._ID,
            ContactsContract.Data.DISPLAY_NAME};

    // This is the select criteria
    static final String SELECTION = "((" +
            ContactsContract.Data.DISPLAY_NAME + " NOTNULL) AND (" +
            ContactsContract.Data.DISPLAY_NAME + " != '' ))";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mNotificationList = (ListView) findViewById(R.id.mNotificationList);

        // Create a progress bar to display while the list loads
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        progressBar.setIndeterminate(true);
        mNotificationList.setEmptyView(progressBar);
        // Must add the progress bar to the root of the layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);

        // For the cursor adapter, specify which columns go into which views
        final String TASK_NAME = "taskname";
        final String TASK_DESCRIPTION = "description";
        String[] fromColumns = {TASK_NAME};
        int[] toViews = {android.R.id.text1}; // The TextView in simple_list_item_1

        TaskDatasource taskDatasource = new TaskDatasource() {

            private ArrayList<Chore> list = new ArrayList<>();
            @Override
            public List<Chore> getChores() {
                return list;
            }

            @Override
            public List<Chore> getChores(int roommateId) {
                return list;
            }

            @Override
            public void postChore(@Body Chore chore) {
                list.add(chore);
            }
        };
        taskDatasource.postChore(new Chore("Trash", new Date(), 0, false));
        taskDatasource.postChore(new Chore("Dishes", new Date(), 0, false));
        List<Chore> chores = taskDatasource.getChores();

        List<Map<String, String>> dataMap = new ArrayList<>();
        for (Chore chore : chores) {
            Map<String, String> map = new HashMap<>();
            map.put(TASK_NAME, chore.getName());
            dataMap.add(map);
        }
        mAdapter = new SimpleAdapter(this, dataMap,
                android.R.layout.simple_list_item_1,
                fromColumns, toViews);
        mNotificationList.setAdapter(mAdapter);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
    }



    private void addDrawerItems() {
        String[] osArray = { "Expense CalculatorActivity", "Chores", "My Room", "Settings", "Requests" };
        ArrayAdapter = new ArrayAdapter<String>(this, R.layout.side_bar_item, osArray);
        mDrawerList.setAdapter(ArrayAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long myid = id;
                //calculator
                if (id == 0) {
                    Intent intent = new Intent(Dashboard.this, CalculatorActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "another activity", Toast.LENGTH_SHORT).show();

                }
                //chores
                if (id == 1) {
                    Intent intent = new Intent(Dashboard.this, CalculatorActivity.class);
                    startActivity(intent);
                }
                //my room
                if (id == 2) {
                    Intent intent = new Intent(Dashboard.this, CalculatorActivity.class);
                    startActivity(intent);
                }
                //settings
                if (id == 3) {
                    Intent intent = new Intent(Dashboard.this, CalculatorActivity.class);
                    startActivity(intent);
                }
                //requests
                if (id == 4) {
                    Intent intent = new Intent(Dashboard.this, CalculatorActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.dashboard, menu);
//        return true;
//    }

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

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


