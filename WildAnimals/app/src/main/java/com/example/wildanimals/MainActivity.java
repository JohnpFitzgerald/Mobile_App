package com.example.wildanimals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//Student: John Fitzgerald
//ID: R00156081

public class MainActivity extends AppCompatActivity {

    //instance of recyclerview id
    RecyclerView recyclerView;

    //declare my arrays of wild animals
    String animalName[];
    String description[];

    //import my images (in correct order) into array for recyclerview
    int images[] = {R.drawable.elephant, R.drawable.lion, R.drawable.tiger, R.drawable.bear, R.drawable.rhino,
            R.drawable.gorilla,R.drawable.crocodile,R.drawable.hyena,R.drawable.snake, R.drawable.tarantula,
            R.drawable.bunny,R.drawable.mouse, R.drawable.ant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find recyclerview based on id
        recyclerView = findViewById(R.id.recyclerView);

        //get animal name and description in an array here
        animalName = getResources().getStringArray(R.array.wild_animals);
        description =getResources().getStringArray(R.array.description);

        //initialize adapter class (including the context)
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,animalName, description, images);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}