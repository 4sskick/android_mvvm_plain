package com.niteroomcreation.mvvmvanila.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.niteroomcreation.mvvmvanila.model.Places;

import java.util.List;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class MainVM extends ViewModel {

    public static final String TAG = MainVM.class.getSimpleName();

    private MutableLiveData<List<Places>> mPlace;

    public void init() {

    }

    public LiveData<List<Places>> getPlaces() {
        return mPlace;
    }
}
