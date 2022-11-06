package model;

import java.util.ArrayList;

public class Premium extends Consumer{
    
    //atributes
    private String label;
    protected ArrayList <Song> prSongs;
    protected ArrayList<Playlist> prPlaylists; 

    //methods 
    public Premium(String name, String nickName, String date, String id, String url, String label){
        super(name, nickName, date, id, url);
        this.label = label;
        prSongs = new ArrayList<>();
        prPlaylists = new ArrayList<>();
    }

    public String addPlaylistToPremium(String name){
        String alert = "";
        boolean stop = false;
        for(int i = 0; i<prPlaylists.size() && !stop; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(name)){
                alert = "This playlist already exists";
                stop = true;
            }
            else{
                prPlaylists.add(new Playlist(name));
                alert = "The playlist has been added succesfully";
            }
            
        }
        return alert;
    }

    public String addSongToPremium(String name, double length, String url, String album, double price, Genre kindGenre){
        String alert = "";
        boolean stop = false;
        for(int i = 0 ; i<prSongs.size() && !stop; i++){
            if(prSongs.get(i).getName().equalsIgnoreCase(name)){
                alert = "This song already exist in the playlist ";
                stop = true;
            }
            else{
                prSongs.add(new Song(name, length, url, album, price, kindGenre));
                alert = "The song has been sucesfully added to the library";
            }
        }
        return alert;
    }

    public String getLabel() {
        return label;
    }

}
