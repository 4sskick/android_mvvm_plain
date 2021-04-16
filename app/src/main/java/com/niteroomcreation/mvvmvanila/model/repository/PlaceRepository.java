package com.niteroomcreation.mvvmvanila.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.niteroomcreation.mvvmvanila.model.Places;
import com.niteroomcreation.mvvmvanila.util.CommonUtil;

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

    public MutableLiveData<List<Places>> getDataset() {
        //this should be data from webservice
        fakeDataset();

        MutableLiveData<List<Places>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    //fake data
    void fakeDataset() {
        dataset.addAll(Places.constructPlaces(35, null));
    }
}
