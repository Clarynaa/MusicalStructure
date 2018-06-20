package com.example.android.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Clary on 6/19/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //All data will be combined into this view
        View songView = convertView;


        //Makes the view into a set of views based on song_list
        if (songView == null) {
            songView = LayoutInflater.from(getContext()).inflate(R.layout.song_list, parent, false);
        }

        //Store the spot in the array of songs that we are currently at
        Song currentSong = getItem(position);


        //fetch the views to put info into
        ImageView albumArtView = songView.findViewById(R.id.albumArtView);
        TextView songNameView = songView.findViewById(R.id.songView);
        TextView artistView = songView.findViewById(R.id.artistView);
        TextView albumView = songView.findViewById(R.id.albumView);

        //fill the views
        albumArtView.setImageResource(currentSong.getAlbumArt());
        songNameView.setText(currentSong.getSongName());
        artistView.setText(currentSong.getArtist());
        albumView.setText(currentSong.getAlbum());

        return songView;
    }
}
