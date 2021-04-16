package com.niteroomcreation.mvvmvanila.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.niteroomcreation.mvvmvanila.R;
import com.niteroomcreation.mvvmvanila.model.Places;

import java.util.List;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Places> places;

    public MainAdapter(Context context, List<Places> places) {
        this.context = context;
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binds();
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public Places getItem(int pos) {
        return places.get(pos);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.item_img);
            txt = itemView.findViewById(R.id.item_txt);
        }

        void binds() {
            Glide.with(img.getContext())
                    .load(getItem(getAdapterPosition()).getImgUrl())
                    .circleCrop()
                    .into(img);
            txt.setText(getItem(getAdapterPosition()).getName());
        }
    }
}
