package com.niteroomcreation.mvvmvanila.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.niteroomcreation.mvvmvanila.R;
import com.niteroomcreation.mvvmvanila.model.Places;
import com.niteroomcreation.mvvmvanila.view.adapter.MainAdapter;
import com.niteroomcreation.mvvmvanila.viewmodel.MainVM;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton fab;
    private RecyclerView rv;
    private ProgressBar progressBar;

    private MainAdapter adapter;
    private MainVM mainVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        fab = findViewById(R.id.fab_main);
        rv = findViewById(R.id.rv_main);
        progressBar = findViewById(R.id.progress_main);

        setupViewModel();
        setupUI();
    }

    void setupViewModel() {
        mainVM = new ViewModelProvider(this).get(MainVM.class);
        mainVM.init();
        mainVM.getPlaces().observe(this, new Observer<List<Places>>() {
            @Override
            public void onChanged(List<Places> places) {
                adapter.notifyDataSetChanged();
            }
        });
        mainVM.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isUpdating) {
                if (isUpdating)
                    showLoading();
                else {
                    hideLoading();
                    //scrolling it to latest values which added
                    rv.smoothScrollToPosition(mainVM.getPlaces().getValue().size() - 1);
                }
            }
        });
    }

    void setupUI() {
        adapter = new MainAdapter(this, mainVM.getPlaces().getValue());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainVM.addPlace(
                        new Places("a random fake place")
                );
            }
        });
    }

    void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}