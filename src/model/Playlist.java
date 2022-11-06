package model;

import java.util.ArrayList;
import java.lang.*;

public class Playlist {
    
    //atributes
    
    private String name; 
    private String code; 

    protected ArrayList<AudioProduct> AudioPlaylist; 

    //methods 

    public Playlist(String name){
        this.name = name;
        this.code = calculateCode();
    }

    public String calculateCode(){
        int matriz[][] = new int[6][6];
        String code = "", part1 = "", part2 = "", part3 = "";
        for(int i = 0; i<matriz.length; i++){

        }
        return code;
    }

    public String removeItem(String name){
        String message = "";
        boolean stop = false;
        for(int i = 0; i<AudioPlaylist.size() && !stop; i++){
            if(AudioPlaylist.get(i).getName().equalsIgnoreCase(name)){
                AudioPlaylist.remove(i);
                message = "The song has been removed";
                stop = true;
            }
            else{
                message = "This song does not exist";
            }
        }
        return message;
    }


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
