package com.niteroomcreation.mvvmvanila.model.repository.remote;

import com.niteroomcreation.mvvmvanila.util.CommonConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Septian Adi Wijaya on 17/04/2021.
 * please be sure to add credential if you use people's code
 */
public class NetConfig {

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .retryOnConnectionFailure(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(CommonConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient);

    private static Retrofit retrofit = retrofitBuilder.build();
    private static NetAPI api = retrofit.create(NetAPI.class);

    public static NetAPI getApi() {
        return api;
    }
}
