package com.example.android.musicalstructure;

/**
 * Created by Clary on 6/18/2018.
 */

public class Song {
    //Song stores the information for a song

    private String mSongName;

    private String mArtist;

    private String mAlbum;

    private int mAlbumArt;

    //Initialize the song with it's data
    public Song(String songName, String artist, String album, int albumArt) {
        mSongName = songName;
        mArtist = artist;
        mAlbum = album;
        mAlbumArt = albumArt;
    }


    //Getters
    public String getSongName() {
        return mSongName;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public int getAlbumArt() {
        return mAlbumArt;
    }
}
