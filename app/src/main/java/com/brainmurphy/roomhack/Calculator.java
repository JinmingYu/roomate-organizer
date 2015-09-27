package com.brainmurphy.roomhack;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.brainmurphy.roomhack.activity.addExpenseActivity;
import com.brainmurphy.roomhack.data.ExpenseDatasource;
import com.brainmurphy.roomhack.data.RoommatePayDatasource;
import com.brainmurphy.roomhack.model.Expense;
import com.brainmurphy.roomhack.model.Roommate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.http.Body;

public class Calculator extends ActionBarActivity {
    ListView expenseList, roommatePayList;
    ArrayList<Expense> expenses;
    public static List<Map<String, String>> expenseDataMap;
    public static List<Map<String, Double>> roommatePayDataMap;
    // This is the Adapter being used to display the list's data
    public static SimpleAdapter expenseAdapter, roommatePayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // Get ListView object from xml
        expenseList = (ListView) findViewById(R.id.expenseList);
        roommatePayList = (ListView) findViewById(R.id.roommatePay);



        // For the cursor adapter, specify which columns go into which views
        final String EXPENSE_NAME = "expenseName";
        final String EXPENSE_DESCRIPTION = "expenseNumber";
        final String FROM_ROOMMATE = "fromroommate";
        String[] fromColumns = {EXPENSE_NAME, EXPENSE_DESCRIPTION};
        String[] roommatePayColumn = {FROM_ROOMMATE};
        int[] toViews = {R.id.name, R.id.number}; // The TextView in simple_list_item_1
        int[] roommatePayToViews = {android.R.id.text1};

        ExpenseDatasource expenseDatasource = new ExpenseDatasource() {
            private ArrayList<Expense> list = new ArrayList<>();
            @Override
            public List<Expense> getExpenses() {
                return list;
            }
            @Override
            public List<Expense> getExpenses(int roommateId) {
                return list;
            }
            @Override
            public void postExpense(@Body Expense expense) {
                list.add(expense);
            }
        };
        RoommatePayDatasource roommatePayDatasource = new RoommatePayDatasource() {
            private ArrayList<Double> list = new ArrayList<>();
            @Override
            public List<Double> getroommatePays() {
                return list;
            }
            @Override
            public List<Double> getroommatePays(int roommateId) {
                return list;
            }
            @Override
            public void postRoommatePay(@Body String roommateName, double roommmateOwe) {
                list.add(roommmateOwe);
            }
        };


        expenseDataMap = new ArrayList<>();
        roommatePayDataMap = new ArrayList<>();
        expenseDatasource.postExpense(new Expense("Rent", 1400));
        expenseDatasource.postExpense(new Expense("internet", 50));
        List<Expense> expenses = expenseDatasource.getExpenses();

        roommatePayDatasource.postRoommatePay("Yufeng", 40);
        roommatePayDatasource.postRoommatePay("Yichen", 40);
        List<Double> roommatePays = roommatePayDatasource.getroommatePays();
        for (Expense expense : expenses) {
            Map<String, String> map = new HashMap<>();
            map.put(EXPENSE_NAME, expense.getName());
            map.put(EXPENSE_DESCRIPTION, Double.toString(expense.getCost()));
            expenseDataMap.add(map);
        }
        for (Double roommatePay : roommatePays) {
            Map<String, Double> map = new HashMap<>();
            map.put(EXPENSE_NAME, roommatePay);
            map.put(EXPENSE_DESCRIPTION, roommatePay);
            roommatePayDataMap.add(map);
        }
        expenseAdapter = new SimpleAdapter(this, expenseDataMap,
                R.layout.calculator_expense_item,
                fromColumns, toViews);
        roommatePayAdapter = new SimpleAdapter(this, roommatePayDataMap,
                R.layout.calculator_expense_item,
                roommatePayColumn, roommatePayToViews);
        expenseList.setAdapter(expenseAdapter);
        roommatePayList.setAdapter(roommatePayAdapter);

        expenseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) expenseList.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });

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
            Intent myintent = new Intent(this,addExpenseActivity.class);
            startActivity(myintent);
        }

        return super.onOptionsItemSelected(item);
    }
}
