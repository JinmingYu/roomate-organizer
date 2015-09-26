package com.brainmurphy.roomhack.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.brainmurphy.roomhack.Calculator;
import com.brainmurphy.roomhack.R;
import com.brainmurphy.roomhack.model.Expense;

public class addExpenseActivity extends ActionBarActivity {
    private EditText expenseName;
    private EditText expenseNumber;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        expenseName = (EditText) findViewById(R.id.expenseName);
        expenseNumber = (EditText) findViewById(R.id.expenseNumber);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (v.getId()) {
                    case R.id.btnAdd:
                        //Need to send things to Firebase
                        //TODO:Make sure information entered isn't NULL
                        String expenseTitle = expenseName.getText().toString();
                        String expenseCost = expenseNumber.getText().toString();
                        double expenseNumber = Double.parseDouble(expenseCost);
                        Expense newExpense = new Expense(expenseNumber, expenseTitle);
                        Calculator.adapter.notifyDataSetChanged();


                        //post now has id set.
                        Toast.makeText(addExpenseActivity.this, "Add Clicked!", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_expense, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Submit button was pressed
        if (id == R.id.btnAdd) {
            //Need to send things to Firebase
            //TODO:Make sure information entered isn't NULL
            String expenseTitle = expenseName.getText().toString();
            String expenseCost = expenseNumber.getText().toString();
            double expenseNumber = Double.parseDouble(expenseCost);
            Expense newExpense = new Expense(expenseNumber, expenseTitle);
            Calculator.adapter.notifyDataSetChanged();


            //post now has id set.
            Toast.makeText(addExpenseActivity.this, "Add Clicked!", Toast.LENGTH_SHORT).show();
            //then close the app
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}