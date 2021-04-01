package com.niteroomcreation.mvvmvanila.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.niteroomcreation.mvvmvanila.model.Places;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class PlaceRepository {

    private static PlaceRepository mInstance;
    private List<Places> dataset = new ArrayList<>();

    public static PlaceRepository getInstance() {
        if (mInstance == null)
            mInstance = new PlaceRepository();
        return mInstance;
    }

//    public MutableLiveData<List<Places>> getDataset() {
//        fakeDataset();
//    }
//
//    //fake data
//    void fakeDataset(){
//        dataset.set(new Places())
//    }
}
