package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Clary on 6/18/2018.
 */

public class NowPlaying extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //get the values passed in from the main activity and prepare them to be fed into things
        Intent intent = getIntent();

        String songName = intent.getStringExtra("Song name");
        String artist = intent.getStringExtra("Song artist");
        String album = intent.getStringExtra("Song album");
        Integer albumId = intent.getIntExtra("Song Album #", 1);


        //use now_playing xml file
        setContentView(R.layout.now_playing);

        //declare all of the views
        ImageView albumArtView = findViewById(R.id.albumImage);
        TextView songNameView = findViewById(R.id.songName);
        TextView artistView = findViewById(R.id.artistName);
        TextView albumView = findViewById(R.id.albumName);

        albumArtView.setImageResource(albumId);
        songNameView.setText(songName);
        artistView.setText(artist);
        albumView.setText(album);

        //grab the play and pause button
        ImageView playView = findViewById(R.id.playButton);
        ImageView pauseView = findViewById(R.id.pauseButton);
        TextView libraryView = findViewById(R.id.library);


        //Implement proper usage in the future
        playView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlaying.this, getString(R.string.playing), Toast.LENGTH_LONG).show();
            }
        });

        //Implement proper usage in the future
        pauseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlaying.this, getString(R.string.paused), Toast.LENGTH_LONG).show();
            }
        });

        //Implement proper usage in the future
        libraryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLibrary = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(toLibrary);
            }
        });


    }
}
