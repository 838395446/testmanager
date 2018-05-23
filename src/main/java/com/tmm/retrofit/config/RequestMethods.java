package com.tmm.retrofit.config;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by Captain Wang on 17/4/5.
 */
public interface RequestMethods {

    @Headers({"Content-Type:text/json;charset=UTF-8","Connection:keep-alive","Accept:*/*","Access-Control-Allow-Origin:*","Device:iphone6 plus"})
    @GET("{path}")
    Call<String> GET_With_Parameters(@Path(value = "path", encoded = true) String path, @QueryMap Map<String, Object> query);

    @Headers({"Content-Type:text/json;charset=UTF-8","Connection:keep-alive","Accept:*/*","Access-Control-Allow-Origin:*","Device:iphone6 plus"})
    @GET("{path}")
    Call<String> GET(@Path(value = "path", encoded = true) String path);


    @Headers({"Content-Type:application/json;charset=UTF-8","Connection:keep-alive","Accept:*/*","Access-Control-Allow-Origin:*","Device:iphone6 plus"})
    @POST("{path}")
    Call<String> POST(@Path(value = "path", encoded = true) String path, @Body String body);

    @Headers({"Content-Type:text/json;charset=UTF-8","Connection:keep-alive","Accept:*/*","Access-Control-Allow-Origin:*","Device:iphone6 plus"})
    @PUT("{path}")
    Call<String> PUT(@Path(value = "path", encoded = true) String path, @Body String body);

    @Headers({"Content-Type:text/json;charset=UTF-8","Connection:keep-alive","Accept:*/*","Access-Control-Allow-Origin:*","Device:iphone6 plus"})
    @DELETE("{path}")
    Call<String> DELETE(@Path(value = "path", encoded = true) String path, @Body String body);
    @DELETE("{path}")
    Call<String> DELETE_NO_Parameters(@Path(value = "path", encoded = true) String path);

    @Headers({"Content-Type:text/json;charset=UTF-8","Connection:keep-alive","Accept:*/*","Access-Control-Allow-Origin:*","Device:iphone6 plus"})
    @OPTIONS("{path}")
    Call<String> OPTIONS(@Path(value = "path", encoded = true) String path, @Body String body);

    @HEAD("{path}")
    Call<String> HEAD(@Path(value = "path", encoded = true) String path, @Body String body);

}
