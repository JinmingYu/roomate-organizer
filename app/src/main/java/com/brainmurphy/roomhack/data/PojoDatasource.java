package com.brainmurphy.roomhack.data;

import com.brainmurphy.roomhack.model.Pojo;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by brian on 9/27/15.
 */
public interface PojoDatasource {
    @GET("/roomates")
    public Call<List<Pojo>> getPojos();
    @POST("/roomates")
    public Call<Pojo> sendPojo(@Body Pojo pojo);
}
