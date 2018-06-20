package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //create and set the song list
        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Creative Song name 1", "Clary V", "Clary Makes Songs", R.drawable.clarymakessongs));
        songs.add(new Song("Creative Song name 2", "Clary V", "Clary Makes Songs", R.drawable.clarymakessongs));
        songs.add(new Song("More Creative Song name 1", "Clary V", "Clary Makes More Songs", R.drawable.clarymakesmoresongs));
        songs.add(new Song("More Creative Song name 2", "Clary V", "Clary Makes More Songs", R.drawable.clarymakesmoresongs));
        songs.add(new Song("Creative Song name 3", "Clary V", "Clary Makes Songs", R.drawable.clarymakessongs));
        songs.add(new Song("Creative Song name 4", "Clary V", "Clary Makes Songs", R.drawable.clarymakessongs));
        songs.add(new Song("More Creative Song name 3", "Clary V", "Clary Makes More Songs", R.drawable.clarymakesmoresongs));
        songs.add(new Song("Creative Song name 5", "Clary V", "Clary Makes Songs", R.drawable.clarymakessongs));
        songs.add(new Song("Creative Song name 6", "Clary V", "Clary Makes Songs", R.drawable.clarymakessongs));

        //Set the songs to be in an adapter
        SongAdapter songAdapter = new SongAdapter(this, songs);

        //Set the song list
        final ListView songList = findViewById(R.id.songList);

        //make the list use our inputs
        songList.setAdapter(songAdapter);


        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                String curSong = songs.get(position).getSongName();
                String curArtist = songs.get(position).getArtist();
                String curAlbum = songs.get(position).getAlbum();
                Intent nowPlaying = new Intent(MainActivity.this, NowPlaying.class);
                nowPlaying.putExtra("Song name", curSong);
                nowPlaying.putExtra("Song artist", curArtist);
                nowPlaying.putExtra("Song album", curAlbum);
                nowPlaying.putExtra("Song Album #", songs.get(position).getAlbumArt());
                startActivity(nowPlaying);
            }
        });

        //grab the play and pause button
        ImageView playView = findViewById(R.id.playButton);
        ImageView pauseView = findViewById(R.id.pauseButton);


        //Implement proper usage in the future
        playView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getString(R.string.playing), Toast.LENGTH_LONG).show();
            }
        });

        //Implement proper usage in the future
        pauseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getString(R.string.paused), Toast.LENGTH_LONG).show();
            }
        });
    }


}
