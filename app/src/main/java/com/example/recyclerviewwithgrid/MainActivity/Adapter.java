package com.example.recyclerviewwithgrid.MainActivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewwithgrid.R;

import java.util.HashMap;

public class Adapter extends RecyclerView.Adapter {


    private final String[] name;

    private CardView cardView;
    private final HashMap<String, String> description;

    private final MainActivity context;
    private final int[] image;
    ImageView imageView;
    TextView tv_name;



    public Adapter(MainActivity mainActivity, HashMap<String, String> description, int[] name_image, String[] name) {
        this.context = mainActivity;
        this.name = name;
        this.description = description;
        this.image = name_image;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_container, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        tv_name.setText(name[i]);
        imageView.setImageResource(image[i]);


    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.cardView);

            imageView = view.findViewById(R.id.imageView);
            tv_name = view.findViewById(R.id.tv_name);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    context.switchToDescriptionPage(name[pos],description.get(name[pos]),image[pos]);
                }
            });



        }
    }
}
