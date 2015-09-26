package com.brainmurphy.roomhack.data;

import com.brainmurphy.roomhack.model.Chore;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by brian on 9/26/15.
 */
public interface TaskDatasource {
    @GET("tasks/")
    public List<Chore> getChores();

    @GET("tasks/{roomateId}")
    public List<Chore> getChores(int roommateId);

    @POST("task/")
    public void postChore(@Body Chore chore);
}
