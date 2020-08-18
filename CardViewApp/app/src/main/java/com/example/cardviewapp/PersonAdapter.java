package com.example.cardviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViiewHolder>{
    @NonNull
    @Override
    public ViiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);
        return new ViiewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViiewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViiewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvPhone;

        public ViiewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }

        public void setItem(Person item){
            tvName.setText(item.getName());
            tvPhone.setText(item.getMobile());
        }
    }
}
