package com.example.rachitassignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.recipe_pic,R.drawable.recipe_pic,R.drawable.recipe_pic,R.drawable.recipe_pic,R.drawable.recipe_pic,R.drawable.recipe_pic,R.drawable.recipe_pic,R.drawable.recipe_pic};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.recipes);
        s1 = getResources().getStringArray(R.array.descriptions);

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}