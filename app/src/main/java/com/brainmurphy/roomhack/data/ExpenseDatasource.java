package com.brainmurphy.roomhack.data;

import com.brainmurphy.roomhack.model.Chore;
import com.brainmurphy.roomhack.model.Expense;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Jinming on 9/26/15.
 */
public interface ExpenseDatasource {
    @GET("expenses/")
    public List<Expense> getExpenses();

    @GET("expenses/{roomateId}")
    public List<Expense> getExpenses(int roommateId);

    @POST("expense/")
    public void postExpense(@Body Expense expense);
}
