package com.example.wildanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
//import android.media.MediaPlayer;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.wildanimals.R.id.my_imageView;
//Student: John Fitzgerald
//ID: R00156081
public class SecondActivity extends AppCompatActivity {


    ImageView mainImageView;
    TextView title, description;

    String data1, data2;
    int myImage;
    //int sounds[] = {R.raw.elephant, R.raw.lion, R.raw.tiger, R.raw.bear, R.raw.rhinos,
     //       R.drawable.gorilla,R.drawable.crocodile,R.drawable.hyena,R.drawable.snake, R.drawable.tarantula,
      //      R.drawable.bunny,R.drawable.mouse, R.drawable.ant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(my_imageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);


        getData();
        setData();
        //Please Note: I tried to implement a sound byte for each animal
        //If the user clicks on the animal image i their page
        //I could not get it work

        //create sound object here to play the animal sounds
        //final MediaPlayer animalSoundPlayer = MediaPlayer.create(this, R.raw.);

       // @SuppressLint("WrongViewCast") final Button playAnimalSound = (Button) this.findViewById(R.id.my_imageView);

       // playAnimalSound.setOnClickListener(new View.OnClickListener() {
          //  public void onClick(View v){
           //     animalSoundPlayer.start();
           // }
        //});

    }
    //getters and setters
    //If I have the image and description fields for the animal I want to
    //to display them on the second activity
    private void getData() {
        if (getIntent().hasExtra("my_imageView") && getIntent().hasExtra("data2")) {
            data2 = getIntent().getStringExtra("data2");
            data1 = getIntent().getStringExtra("data1");
            myImage = getIntent().getIntExtra("my_imageView", 1);
        } else {
            //if data not found use a toast to give an error message
            Toast.makeText(this, "No data found to display", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);

    }
    public void wikiPage(View view){
        Intent wikiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/"+data1));
        startActivity(wikiIntent);
    }

}