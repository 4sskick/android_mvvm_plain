package com.niteroomcreation.mvvmvanila.model.repository.remote;

import androidx.lifecycle.MutableLiveData;

import com.niteroomcreation.mvvmvanila.model.Recipe;

import java.util.List;

/**
 * Created by Septian Adi Wijaya on 17/04/2021.
 * please be sure to add credential if you use people's code
 */
public class NetApiClient {

    public static final String TAG = NetApiClient.class.getSimpleName();

    private static NetApiClient mInstance;
    private MutableLiveData<List<Recipe>> mRecipes;
    private MutableLiveData<List<Recipe>> mRecipe;

    public static NetApiClient getInstance() {

        if (mInstance == null)
            mInstance = new NetApiClient();

        return mInstance;
    }

    private NetApiClient() {
        mRecipes = new MutableLiveData<>();
        mRecipe = new MutableLiveData<>();
    }
}
