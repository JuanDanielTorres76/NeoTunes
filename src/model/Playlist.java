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
        int s = countSongs(); int p = countPodcats();
        if(s>0 && p>0){
            //llenar code
        } else if(s>0 && p ==0){
            this.code = formN();
        } else if(s==0 && p>0){
            this.code = formT();
        }
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

    public int[][] getMatriz() {
        return matriz;
    }

}