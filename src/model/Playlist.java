package model;

import java.util.ArrayList;
import java.lang.Math;

public class Playlist {
    
    //atributes
    
    private String name; 
    private String code; 
    protected int matriz[][] = new int[6][6];



    protected ArrayList<AudioProduct> AudioPlaylist; 

    //methods 

    public Playlist(String name){
        this.name = name;
        FillMat();
        code = "0";    
    }

    public int countPodcats(){
        int counter = 0;
        for(int i = 0; i<AudioPlaylist.size(); i++){
            if(AudioPlaylist.get(i) instanceof Podcast){
                counter++;
            }
        }
        return counter;
    }

    public int countSongs(){
        int counter = 0;
        for(int i = 0; i<AudioPlaylist.size(); i++){
            if(AudioPlaylist.get(i) instanceof Song){
                counter++;
            }
        }
        return counter;
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

    public String switchItem(String fSong, String sSOng){
        String message = "";
        boolean stop = false, stop1 = false;
        for(int i = 0; i<AudioPlaylist.size() && !stop; i++){
            if(AudioPlaylist.get(i).getName().equalsIgnoreCase(fSong)){
                stop = true; 
                for(int b = 0; b<AudioPlaylist.size() && !stop1; b++){
                    if(AudioPlaylist.get(b).getName().equalsIgnoreCase(sSOng)){
                        stop1 = true;
                        if(AudioPlaylist.get(i) instanceof Song && AudioPlaylist.get(b)instanceof Song){
                            Song obj = (Song)AudioPlaylist.get(i);
                            AudioPlaylist.add(obj);
                            Song obj1 = (Song)AudioPlaylist.get(b);
                            AudioPlaylist.set(i, obj1);
                            int lastItem = AudioPlaylist.size()-1;
                            Song obj2 = (Song)AudioPlaylist.get(lastItem);
                            AudioPlaylist.set(b, obj2);
                            AudioPlaylist.remove(lastItem);
                            message = "The song" + fSong + " has switched positions with the song " + sSOng;

                        } else if(AudioPlaylist.get(i) instanceof Song && AudioPlaylist.get(b) instanceof Podcast){
                            Song obj = (Song)AudioPlaylist.get(i);
                            AudioPlaylist.add(obj);
                            Podcast obj1 = (Podcast)AudioPlaylist.get(b); 
                            AudioPlaylist.set(i, obj1);
                            int lastItem = AudioPlaylist.size()-1;
                            Song obj2 = (Song)AudioPlaylist.get(lastItem);
                            AudioPlaylist.set(b, obj2);
                            AudioPlaylist.remove(lastItem);
                            message = "The song" + fSong + " has switched positions with the podcast " + sSOng;
                            
                        } else if(AudioPlaylist.get(i) instanceof Podcast && AudioPlaylist.get(b) instanceof Song){
                            Podcast obj = (Podcast)AudioPlaylist.get(i);
                            AudioPlaylist.add(obj);
                            Song obj1 = (Song)AudioPlaylist.get(b);
                            AudioPlaylist.set(i, obj1);
                            int lastItem = AudioPlaylist.size()-1;
                            Song obj2 = (Song)AudioPlaylist.get(lastItem);
                            AudioPlaylist.set(b, obj2);
                            AudioPlaylist.remove(lastItem);
                            message = "The Podcats" + fSong + " has switched positions with the song " + sSOng;
                            
                        } else if(AudioPlaylist.get(i) instanceof Podcast && AudioPlaylist.get(b) instanceof Podcast){
                            Podcast obj = (Podcast)AudioPlaylist.get(i);
                            AudioPlaylist.add(obj);
                            Podcast obj1 = (Podcast)AudioPlaylist.get(b);
                            AudioPlaylist.set(i, obj1);
                            int lastItem = AudioPlaylist.size()-1;
                            Podcast obj2 = (Podcast)AudioPlaylist.get(lastItem);
                            AudioPlaylist.set(b, obj2);
                            AudioPlaylist.remove(lastItem);
                            message = "The Podcats" + fSong + " has switched positions with the podcast " + sSOng;
                        }
                        
                    //Add method   
                    } else{
                        message = "The audioItem" + sSOng + "hasnt been added";
                    }
                } 
            } else{
                message = "The audioItem" + fSong + " hasnt been added";
            }
        }
        return message;
    }

    public String addSong(AudioProduct obj){
        String alert = "";
        boolean stop = false;
        for( int i = 0; i<AudioPlaylist.size() && !stop; i++){
            if(AudioPlaylist.get(i).getName().equalsIgnoreCase(obj.getName())){
                alert = "This song has already been added to the playlist";
                stop = true;
            } 
        }
        if(stop == false){
            AudioPlaylist.add(obj);
            alert = "The audio" + obj.getName() + "has been sucesfully added to the playlist ";
        }
        return alert;
    }

    public void FillMat(){
        for( int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[0].length; j++){
                matriz[i][j] = numRand(10);
            }
        }

    }

    public int numRand(int max){
        int i = (int) (Math.random()*max);
        return i;
    }


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String formN(){
        String code = "", part1 = "", part2 = "", part3 = "";
        for(int i = matriz.length-1; i>0; i--){
            part1 += matriz[i][0];
        }
        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[0].length; j++){
                if( i == j){
                    part2 += matriz[i][j];
                }
            }
        }
        for(int i = matriz.length-2; i>=0; i--){
            part3 += matriz[i][matriz[0].length-1];
        }
        code = part1+part2+part3;
        return code;
    }

    public String reverseForm(){
        String code = "";
        for(int i = matriz.length-1; i>=0; i--){
            for(int j = matriz[0].length-1; j>=0; j-- ){
                if((j+i) % 2 != 0 && j+i != 1){
                    code += matriz[i][j];
                }
            }
        }
        return code;
    }


    public String formT(){
        String code = "", part1 ="", part2 = "", part3 = "", part4 ="";
        for(int j = 0; j<(matriz[0].length/2); j++){
            part1 += matriz[0][j];
            if(j == (matriz[0].length/2)-1){
                for(int i = 1; i<matriz.length; i++){
                    part2 += matriz[i][j];
                }
            }
        }
        for(int j = (matriz[0].length/2); j<matriz[0].length; j++){
            if(j == (matriz[0].length/2)){
                for(int i = matriz.length-1; i>0; i--){
                    part3 += matriz[i][j];
                }
            }
            part4 += matriz[0][j];  
        }
        code = part1+part2+part3+part4;
        return code;
    }

    public void showSongs(){
        for(int i = 0; i<AudioPlaylist.size(); i++){
            System.out.println( i + " - " + AudioPlaylist.get(i).getName());
        }
    }

    public String sharePlaylist(){
        String alert = "", code = "";
        int sCont = countSongs(), pCont = countPodcats();
        if(sCont >0 && pCont>0){
            code = reverseForm();
            alert = "the code is " + code;
            setCode(code);
        } else if(sCont>0 && pCont == 0){
            code = formN();
            alert = "the code is " + code;
            setCode(code);
        } else if(sCont == 0 && pCont>0){
            code = formT();
            alert = "the code is " + code;
            setCode(code);
        }

        return alert;
    }


    public int[][] getMatriz() {
        return matriz;
    }

}
