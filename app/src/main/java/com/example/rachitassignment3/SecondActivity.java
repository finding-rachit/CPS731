package com.example.rachitassignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title, description;

    String data1, data2;
    int myImage;

    Button music1;
    Button music2;
    MediaPlayer mdMusic1;
    MediaPlayer mdMusic2;
    Integer Playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        music1= findViewById(R.id.btnMusic1);
        music2=findViewById(R.id.btnMusic2);
        mdMusic1=new MediaPlayer();
        mdMusic1=MediaPlayer.create(this,R.raw.track1);
        mdMusic2= new MediaPlayer();
        mdMusic2= MediaPlayer.create(this,R.raw.track2);
        music1.setOnClickListener(onClick1);
        music2.setOnClickListener(onClick2);
        Playing=0;

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("MyImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        } else{
            Toast.makeText(this,"No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }

    Button.OnClickListener onClick1= new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (Playing){
                case 0: mdMusic1.start(); Playing=1; music1.setText("Pause Music"); music2.setVisibility(View.INVISIBLE);break;
                case 1:mdMusic1.pause(); Playing=0;music1.setText("Play Drums"); music2.setVisibility(View.VISIBLE);break;
            }

        }
    };
    Button.OnClickListener onClick2= new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (Playing){
                case 0: mdMusic2.start(); Playing=1; music2.setText("Pause Srums"); music1.setVisibility(View.INVISIBLE);break;
                case 1:mdMusic2.pause(); Playing=0;music2.setText("Play Drums"); music1.setVisibility(View.VISIBLE);break;
            }


        }
    };
}