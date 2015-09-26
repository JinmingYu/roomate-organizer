package com.brainmurphy.roomhack.data;

import com.brainmurphy.roomhack.model.Roommate;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by brian on 9/26/15.
 */
public interface RoommateDatasource {
    @GET("/roomates")
    public List<Roommate> getRoomates();
    @POST("/roomates")
    public void postRoomate(@Body Roommate roomate);
}
