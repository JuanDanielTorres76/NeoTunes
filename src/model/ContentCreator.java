package model;

import java.util.ArrayList;

public class ContentCreator extends Productor {

    //atributes
    protected ArrayList<Podcast> contentCreatorPodcasts;

    //Methods
    public ContentCreator(String name, String nickName, String date, String id, String url, int year){
        super(name, nickName, date, id, url, year);
    }

    public String addAudio(String name, double length, String url, String album, double price, Genre kindGenre,String description, Category kind){
        String alert = "";
        contentCreatorPodcasts.add(new Podcast(name, length, url, description, kind));
        alert = " The podcast has been sucesfully added to the content creator";
        return alert;
    }



    
}
