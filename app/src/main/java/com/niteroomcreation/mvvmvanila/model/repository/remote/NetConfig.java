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

    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .retryOnConnectionFailure(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build();

    private static final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(CommonConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient);

    private static final Retrofit retrofit = retrofitBuilder.build();
    private static final NetApi api = retrofit.create(NetApi.class);

    public static NetApi getApi() {
        return api;
    }
}
