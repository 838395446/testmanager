package com.tmm.retrofit.config;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by Captain Wang on 17/4/5.
 */
public interface RequestMethods {


    @GET("{path}")
    Call<String> GET_With_Parameters(@Path(value = "path", encoded = true) String path, @QueryMap Map<String, Object> query);
    @GET("{path}")
    Call<String> GET(@Path(value = "path", encoded = true) String path);
    @POST("{path}")
    Call<String> POST(@Path(value = "path", encoded = true) String path, @Body String body);

    @PUT("{path}")
    Call<String> PUT(@Path(value = "path", encoded = true) String path, @Body String body);

    @DELETE("{path}")
    Call<String> DELETE(@Path(value = "path", encoded = true) String path, @Body String body);
    @DELETE("{path}")
    Call<String> DELETE_NO_Parameters(@Path(value = "path", encoded = true) String path);

    @OPTIONS("{path}")
    Call<String> OPTIONS(@Path(value = "path", encoded = true) String path, @Body String body);

    @HEAD("{path}")
    Call<String> HEAD(@Path(value = "path", encoded = true) String path, @Body String body);

}
