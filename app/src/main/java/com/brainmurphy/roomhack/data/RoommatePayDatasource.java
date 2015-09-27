package com.brainmurphy.roomhack.data;

import com.brainmurphy.roomhack.model.Chore;
import com.brainmurphy.roomhack.model.Roommate;

import java.util.HashMap;
import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Jinming on 9/26/15.
 */
public interface RoommatePayDatasource {
    @GET("roommatePays/")
    public List<HashMap<String, String>> getroommatePays();

    @GET("roommatePays/{roomateId}")
    public List<HashMap<String, String>> getroommatePays(int roommateId);

    @POST("roommatePay/")
    public void postRoommatePay(@Body String roommateName, String roommmateOwe);
}
