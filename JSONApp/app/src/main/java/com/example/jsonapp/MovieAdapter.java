package com.example.jsonapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>
    implements OnMovieItemClickListener{
    OnMovieItemClickListener listener;
    ArrayList<Movie> items = new ArrayList<Movie>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.movie_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public void addItem(Movie item) {
        items.add(item);
    }

    public void setItems(ArrayList<Movie> items) {
        this.items = items;
    }

    public Movie getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvCnt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCnt = itemView.findViewById(R.id.tvCnt);
        }
        public void setItem(Movie item) {
            tvTitle.setText(item.movieNm);
            tvCnt.setText(item.audiCnt + "명");
        }
    }

}
