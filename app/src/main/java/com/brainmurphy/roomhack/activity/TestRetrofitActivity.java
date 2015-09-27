package com.brainmurphy.roomhack.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.brainmurphy.roomhack.R;
import com.brainmurphy.roomhack.data.PojoDatasource;
import com.brainmurphy.roomhack.data.RoommateDatasource;
import com.brainmurphy.roomhack.model.Expense;
import com.brainmurphy.roomhack.model.Pojo;
import com.brainmurphy.roomhack.model.Roommate;

import java.io.IOException;

import retrofit.Converter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class TestRetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://roomate-hack-main.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        final PojoDatasource datasource = retrofit.create(PojoDatasource.class);
        final Pojo pj = new Pojo();
        final RoommateDatasource roomateDatasource= retrofit.create(RoommateDatasource.class);
        pj.id = 0;
        pj.name = "bri";

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    datasource.sendPojo(pj).execute();
                    Log.d("LOWG", Integer.toString(datasource.getPojos().execute().body().size()));


                    Roommate r = new Roommate();
                    r.setName("Brian");

                    Expense e1 = new Expense("blah", 10);
                    Expense e2 = new Expense("blue", 5);
                    r.addExpense(e1);
                    r.addExpense(e2);

                    Roommate roomy = roomateDatasource.postRoomate(r).execute().body();

                    Log.d("LOWG", roomy.getName() + " " + roomy.getID());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_retrofit, menu);
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
}
