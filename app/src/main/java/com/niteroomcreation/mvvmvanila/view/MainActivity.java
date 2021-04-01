package com.niteroomcreation.mvvmvanila.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.niteroomcreation.mvvmvanila.R;
import com.niteroomcreation.mvvmvanila.model.Places;
import com.niteroomcreation.mvvmvanila.view.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton fab;
    private RecyclerView rv;
    private ProgressBar progressBar;

    private MainAdapter adapter;

    private List<Places> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        fab = findViewById(R.id.fab_main);
        rv = findViewById(R.id.rv_main);
        progressBar = findViewById(R.id.progress_main);

        data = new ArrayList<>();

        setupUI();
    }

    void setupUI() {
        adapter = new MainAdapter(this, data);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}