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

    public void showPodcasts(){
        for(int i = 0; i<contentCreatorPodcasts.size(); i++){
            System.out.println( i + " - " + contentCreatorPodcasts.get(i).getName());
        }
    }

    public Podcast choosenPodcast(String podName){
        boolean continuar = false;
        Podcast obj = null;
        for(int i = 0; i<contentCreatorPodcasts.size()&& !continuar; i++){
            if(contentCreatorPodcasts.get(i).getName().equalsIgnoreCase(podName)){
                obj = contentCreatorPodcasts.get(i);
                continuar = true;
            }
        }
        return obj; 
    }



    
}
