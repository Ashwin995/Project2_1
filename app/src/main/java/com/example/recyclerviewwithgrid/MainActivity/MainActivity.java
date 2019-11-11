package com.example.recyclerviewwithgrid.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.recyclerviewwithgrid.Description.Description;
import com.example.recyclerviewwithgrid.FormPage.FormPage;
import com.example.recyclerviewwithgrid.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    Button btn_form;


    HashMap<String, String> description;
    HashMap<String, Integer> name_image;

    String[] name_description = new String[]{"Barack Hussein Obama II is an American attorney and politician who served as the 44th president of" +
            "the United States from 2009 to 2017. A member of the Democratic Party, he was the first African" +
            "American to be elected to the presidency.", "Donald John Trump is the 45th and current president of the United States. Before entering politics," +
            "he was a businessman and television personality. Trump was born and raised in the New York City" +
            "borough of Queens, and received a B.S. degree in economics from the Wharton School at the" +
            "University of Pennsylvania.", "George Walker Bush is an American politician and businessman who served as the 43rd president\n" +
            "of the United States from 2001 to 2009. He had previously served as the 46th governor of Texas" +
            "from 1995 to 2000.", "William Jefferson Clinton is an American politician who served as the 42nd president of the United\n" +
            "States from 1993 to 2001. Prior to his presidency, he served as governor of Arkansas and as" +
            "attorney general of Arkansas."};
    String[] name = new String[]{"Barack Obama", "Donald Trump", "George-W-Bush", "Bill Clinton"};

    int[] image = {R.drawable.barack, R.drawable.trump, R.drawable.george, R.drawable.clinton};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        createStaticModel();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Adapter adapter = new Adapter(this,description,image,name);
        recyclerView.setAdapter(adapter);

        btn_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormPage.class));
            }
        });


    }

    private void createStaticModel() {
        description = new HashMap<>();
        name_image = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            description.put(name[i], name_description[i]);
        }


    }

    public void switchToDescriptionPage(String name, String description, int image) {

        Intent i = new Intent(this, Description.class);

        i.putExtra("name",name);
        i.putExtra("description", description);
        i.putExtra("image",image);

        startActivity(i);


    }
}
