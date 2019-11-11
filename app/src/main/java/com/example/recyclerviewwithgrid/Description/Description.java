package com.example.recyclerviewwithgrid.Description;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewwithgrid.R;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent i = getIntent();
        String name = i.getExtras().getString("name");
        String description = i.getExtras().getString("description");
        int image = (int) i.getExtras().get("image");

        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_description = findViewById(R.id.tv_description);
        ImageView iv_image = findViewById(R.id.imageView);

        tv_name.setText(name);
        tv_description.setText(description);
        iv_image.setImageResource(image);

        getSupportActionBar().setTitle(name);

        



    }
}
