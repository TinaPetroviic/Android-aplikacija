package com.example.flowers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

interface OnCardClickListener {
    void didClickOnCard(int position);
}

public class FlowersRecyclerAdapter extends RecyclerView.Adapter<FlowersRecyclerAdapter.ViewHolder> {
    private ArrayList<Plants> plantsArrayList;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnCardClickListener listener;


    public FlowersRecyclerAdapter(ArrayList<Plants> plantsArrayList, FlowersActivity3 flowersActivity3, OnCardClickListener onCardClickListener) {
        this.plantsArrayList = plantsArrayList;
        this.context = flowersActivity3;
        this.layoutInflater = LayoutInflater.from(context);
        this.listener = onCardClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_item_card, parent, false);
        return new FlowersRecyclerAdapter.ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plants plant = plantsArrayList.get(position);
        holder.plantName.setText(plant.getName());
        holder.plantImage.setImageResource(plant.getImage());

    }

    @Override
    public int getItemCount() {

        return plantsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView plantName;
        ImageView plantImage;
        private OnCardClickListener listener;


        ViewHolder(View itemView, OnCardClickListener listener) {
            super(itemView);
            this.plantName = itemView.findViewById(R.id.plantName);
            this.plantImage = itemView.findViewById(R.id.plantImage);
            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.didClickOnCard(position);
        }
    }

    public void filterList(ArrayList<Plants> filterlist) {
        plantsArrayList = filterlist;
        notifyDataSetChanged();
    }
}