package model;

import java.util.ArrayList;

public class Artist extends Productor {

    //Atributes
    private String country; 
    protected ArrayList<Song> artistSongs;

    //Methods

    public Artist(String name, String nickName, String date, String id, String url, int year, String country){
        super(name, nickName, date, id, url, year);
        this.country = country;
        artistSongs = new ArrayList<Song>();

    } 

    public String getCountry() {
        return country;
    }

    @Override
    public String addAudio(String name, double length, String url, String album, double price, Genre kindGenre,String description, Category kind) {
        String alert = "";
        artistSongs.add(new Song(name, length, url, album, price, kindGenre));
        alert = "The song has been added to the Artist";
        return alert;
    }

    
}