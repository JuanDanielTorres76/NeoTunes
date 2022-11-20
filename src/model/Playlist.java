package model;

import java.util.ArrayList;
import java.lang.Math;

public class Playlist {
    
    //atributes
    
    private String name; 
    private String code; 
    protected int matriz[][];



    protected ArrayList<AudioProduct> AudioPlaylist; 

    //methods 

    /**
     * Metodo constructor para la clase PLAYLIST
     * <b>pre: </b> atributos declarados previamente  
     * <b>post: </b> Se instancia un objeto de la clase PLAYLIST 
     * @param name nombre digitado por el usuario 
     */
    public Playlist(String name){
        this.name = name;
        FillMat();
        code = "0";   
        matriz = new int[6][6]; 
    }

    /**
     * Metodo para contar los podcast dentro de una PLAYLSIT
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se muestra el numero de podcast que existen en la clase
     * @return se retorna el numero de podcast creados
     */
    public int countPodcats(){
        int counter = 0;
        for(int i = 0; i<AudioPlaylist.size(); i++){
            if(AudioPlaylist.get(i) instanceof Podcast){
                counter++;
            }
        }
        return counter;
    }

    /**
     *  Metodo para contar los songs dentro de una PLAYLSIT
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se muestra el numero de canciones que existen en la clase
     * @return se retorna el numeor de canciones en una playlist
     */
    public int countSongs(){
        int counter = 0;
        for(int i = 0; i<AudioPlaylist.size(); i++){
            if(AudioPlaylist.get(i) instanceof Song){
                counter++;
            }
        }
        return counter;
    }


    /**
     * Metodo para eliminar en Item de una playlist
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se elimina un objeto de una playlist
     * @param name nombre del audio que se eliminara 
     * @return se retorna el estado del metodo
     */
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

    /**
     *  Metodo para cambiar de posicion Items de una PLAYLIST 
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se cambia un Item de un audio
     * @param fSong el primer nombre del audio
     * @param sSOng el segundi nombre del audio
     * @return se retorna el estado del metodo 
     */
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

    /**
     *  Metodo para añadir una cacnion a una playlist
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se añade una cancion
     * @param obj objeto tipo AUDIO obtenido previamente por ejecucion de metodos
     * @return se retorna estado del metodo
     */
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

    /**
     * Metodo para simualro los audios
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se simula un audio
     * @param sName nombre de la cancion 
     * @return se retorna el estado del metodo
     */
    public String simulateAudio(String sName){
        String alert = "This song doesnt exist";
        boolean stop = false;
        for( int i = 0; i<AudioPlaylist.size() && !stop; i++){
            if(AudioPlaylist.get(i).getName().equalsIgnoreCase(sName)){
                stop = true;
                if(AudioPlaylist.get(i) instanceof Song){
                    alert = "The song " + AudioPlaylist.get(i).getName() + " is being played";
                } else if(AudioPlaylist.get(i) instanceof Podcast){
                    alert = "The Podcadst " + AudioPlaylist.get(i).getName() + " is being played";
                }
                
            }

        }
        return alert;
    }

    /**
     * Metodo para contar las reproducciones de la canciones
     * <b>pre: </b> debe haberse instanciado un objeto de la clase previamente
     * <b>post: </b> Se muestar el total de reproduccionse 
     * @param sName nombre de la cacnion
     * @return se retorna el numero de reproducciones de una cacnion
     */
    public int countPlayedAudio(String sName){
        int option = 4;
        boolean stop = false;
        for(int i = 0; i<AudioPlaylist.size() && !stop; i++){
            if(AudioPlaylist.get(i).getName().equalsIgnoreCase(sName)){
                stop = true;
                if(AudioPlaylist.get(i) instanceof Song){
                    Song obj = (Song)AudioPlaylist.get(i);
                    if(AudioPlaylist.get(i).getName().equalsIgnoreCase(sName)){
                        if(obj.getKindGenre() == Genre.ROCK){
                            option = 0;
                        } else if(obj.getKindGenre() == Genre.POP){
                            option = 1;
                        } else if(obj.getKindGenre() == Genre.TRAP){
                            option = 2; 
                        } else if(obj.getKindGenre() == Genre.HOUSE){
                            option = 3;
                        }
                    } 
                } else if(AudioPlaylist.get(i) instanceof Podcast){
                    Podcast obj = (Podcast)AudioPlaylist.get(i);
                    if(AudioPlaylist.get(i).getName().equalsIgnoreCase(sName)){
                        if(obj.getKind() == Category.POLITICS){
                            option = 5;
                        } else if(obj.getKind() == Category.ENTERNTAINMENT){
                            option = 6;
                        } else if(obj.getKind() == Category.VIDEOGAMES){
                            option = 7; 
                        } else if(obj.getKind() == Category.FASHION){
                            option = 8;
                        }
                    } 
                }
            }
        }

        return option;
    }

    /**
     * Metodo para llenar la matriz de codigos
     * <b>pre: </b> debe crearse un objeto del metodo
     * <b>post: </b> Se llena la matriz
     */
    public void FillMat(){
        for( int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[0].length; j++){
                matriz[i][j] = numRand(10);
            }
        }

    }

    /**
     * Metodo ppara devolver un numero aleatorio 
     * <b>pre: </b> debe instanciarse un metodo
     * <b>post: </b> Se retorna un numero aleatorio
     * @param max un numero que sera el maximo valor al que podra tomar el valor de retorno
     * @return retorna el valor aleatorio
     */
    public int numRand(int max){
        int i = (int) (Math.random()*max);
        return i;
    }


    /**
     * Metodo get para el atributo Name
     * <b>pre: </b> debe haberse declarado previamente el atributo
     * <b>post: </b> Se retorna el atributo
     * @return retorna el atributo
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo get para el atributo code
     * <b>pre: </b> debe haberse declarado previamente el atributo
     * <b>post: </b> Se retorna el atributo
     * @return retorna el atributo
     */
    public String getCode() {
        return code;
    }

    /**
     * Metodo set para el atributo code
     * <b>pre: </b> debe haberse declarado previamente el atributo
     * <b>post: </b> Se retorna el atributo nuevamente
     * @param code valor al que tomara el codigo
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Metodo para recorrer la matriz de una forma N y retornar el codigo
     * <b>pre: </b> debe haberse instanciado previamente el objeto
     * <b>post: </b> se retrona el codigo
     * @return se retorna el codigo
     */
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

    /**
     * Metodo para recorrer la matriz de una forma especifica y retornar el codigo
     * <b>pre: </b> debe haberse instanciado previamente el objeto
     * <b>post: </b> se retrona el codigo
     * @return se retorna el codigo
     */
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


    /**
     * Metodo para recorrer la matriz de una forma T y retornar el codigo
     * <b>pre: </b> debe haberse instanciado previamente el objeto
     * <b>post: </b> se retorna el codigo
     * @return se retorna el codigo 
     */
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

    /**
     * Metodo para mostrar las canciones de una playlist 
     * <b>pre: </b> debe haberse instanciado previamente el objeto
     * <b>post: </b> se retornar las canciones de la playlist
     */
    public void showSongs(){
        for(int i = 0; i<AudioPlaylist.size(); i++){
            System.out.println( i + " - " + AudioPlaylist.get(i).getName());
        }
    }

    /**
     * Metodo para compartir la playlist
     * <b>pre: </b> debe haberse instanciado el objeto
     * <b>post: </b> se retrona el codigo
     * @return se retorna el codigo 
     */
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


    /**
     * Metodo get para el la matriz 
     * <b>pre: </b> debe haberse declarado previamente el atributo
     * <b>post: </b> Se retorna el atributo
     * @return se retorna la matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

}
