package com.niteroomcreation.mvvmvanila.model.repository.remote;

import com.niteroomcreation.mvvmvanila.model.repository.remote.response.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Septian Adi Wijaya on 17/04/2021.
 * please be sure to add credential if you use people's code
 */
interface NetAPI {


    // GET RECIPE REQUEST
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("key") String key,
            @Query("rId") String recipe_id
    );
}
