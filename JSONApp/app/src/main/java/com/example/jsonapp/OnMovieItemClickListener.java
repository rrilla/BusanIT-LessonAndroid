package com.example.jsonapp;

import android.view.View;

public interface OnMovieItemClickListener {
    public void onItemClick(MovieAdapter.ViewHolder holder, View view, int position);
}
