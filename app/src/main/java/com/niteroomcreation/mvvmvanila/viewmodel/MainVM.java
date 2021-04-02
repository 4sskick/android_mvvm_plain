package com.niteroomcreation.mvvmvanila.viewmodel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.niteroomcreation.mvvmvanila.model.Places;
import com.niteroomcreation.mvvmvanila.model.repository.PlaceRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class MainVM extends ViewModel {

    public static final String TAG = MainVM.class.getSimpleName();

    private MutableLiveData<List<Places>> mPlace;
    private MutableLiveData<Boolean> isUpdating;
    private PlaceRepository repository;

    public void init() {

        //if it not null then it already retrieve data
        if (mPlace != null)
            return;

        //else gonna retrieve data from repo
        repository = PlaceRepository.getInstance();
        mPlace = repository.getDataset();
        isUpdating = new MutableLiveData<>();
    }

    public void addPlace(Places places) {
        isUpdating.setValue(true);

        ExecutorService thread = Executors.newSingleThreadExecutor();
        Handler threadHandler = new Handler(Looper.getMainLooper());
        thread.execute(new Runnable() {
            @Override
            public void run() {

                //mimicking progress retrieving data by showing progress bar on thread sleep
                //then post it on main thread using handler
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                threadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<Places> place = mPlace.getValue();
                        place.add(places);
                        mPlace.postValue(place);
                        isUpdating.postValue(false);
                    }
                });
            }
        });
    }

    public LiveData<List<Places>> getPlaces() {
        return mPlace;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}
