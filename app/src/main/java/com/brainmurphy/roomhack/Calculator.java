package com.brainmurphy.roomhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.brainmurphy.roomhack.model.Expense;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator extends AppCompatActivity {
    ListView listView;
    ArrayList<Expense> expenses;
    static SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);


        // create the grid item mapping
        String[] from = new String[] {"name", "number"};
        int[] to = new int[] { R.id.name, R.id.number};
        // Defined Array values to show in ListView
        String[] values = new String[] { "Rent",
                "Electricity",
                "Internet",
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        // fill in the grid_item layout
        adapter = new SimpleAdapter(this, fillMaps, R.layout.calculator_expense_item, from, to);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });



//        // Defined Array values to show in ListView
//        expenses = new ArrayList<Expense>();
//        ArrayList<String> expenseNames = new ArrayList<String>();
//        ArrayList<Double> expenseNumbers = new ArrayList<Double>();
//        expenses.add(new Expense(1400, "rent"));
//        //get the arraylist of the expense names and numbers
//        for (Expense expense: expenses) {
//            expenseNames.add(expense.getName());
//            Double cost = expense.getCost();
//        }
//
//
//        // Define a new Adapter
//        // First parameter - Context
//        // Second parameter - Layout for the row
//        // Third parameter - ID of the TextView to which the data is written
//        // Forth - the Array of data
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.calculator_expense_item, android.R.id.text1, expenseNames);
//        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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
        if(id == R.id.add){
            //Start the add group activity
            Intent myintent = new Intent(this,addExpense.class);
            startActivity(myintent);
        }

        return super.onOptionsItemSelected(item);
    }
}
