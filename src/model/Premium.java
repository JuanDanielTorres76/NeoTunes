package model;

import java.util.ArrayList;

public class Premium extends Consumer{
    
    //atributes
    private String label;
    protected ArrayList <Song> prSongs;
    protected ArrayList<Playlist> prPlaylists; 

    //methods 
    /**
     * Metodo constructro de la clase tipo PREMIUM
     * <b>pre: </b> atributos declarados
     * <b>post: </b> se instancia un objeto tipo PREMIUM
     * @param name nombre digitado por el usuario
     * @param nickName nickName digitado por el usuario
     * @param date date se asigna en el momento que se crea el objeto
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     * @param label label digitado por el usuario
     */
    public Premium(String name, String nickName, String date, String id, String url, String label){
        super(name, nickName, date, id, url);
        this.label = label;
        prSongs = new ArrayList<>();
        prPlaylists = new ArrayList<>();
    }

    /** 
     * Metodo para añdir una playlist al obejto PREMIUM
     * <b>pre: </b> atributos declarados
     * <b>post: </b> se añade un objeto playlist a la clase PREMIUM
     * @param name nombre digita el usuario 
     * @return retorna una alerta de la creacion de la playlist
     */
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

    /** Metodo para añadir una cancion a la libreria del usuario
     * <b>pre: </b> debe existir un objeto de clase PREMIUM previamente instanciado 
     * <b>post: </b> se añade un abjeto SONG a la libreria del usuario 
     * @param name name digitado por el usuario
     * @param length duracion digitado por el usuario
     * @param url url digitado por el usuario
     * @param album album digitado por el usuario
     * @param price precio digitado por el usuario
     * @param kindGenre genero elegido por el usaurio
     * @return alerta del estado del metodo
     */
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

    /**
     * Metodo para quitar un objeto de una playlist
     * <b>pre: </b> debe existir un objeto de clase PREMIUM previamente instanciado y tener un objeto PLAYLIST dentro
     * <b>post: </b> se elimina un item dentro de la playlist del usuario
     * @param pName nombre de la plyalist elegido por el usuario 
     * @param sName nombre de la cancio digitado por el usuario
     * @return alerta del estado del metodo
     */
    public String removeItemFromPlaylistPr(String pName, String sName){
        String alert = "";
        boolean stop = false;
        for(int i = 0; i<prPlaylists.size() && !stop; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(pName)){
                alert = prPlaylists.get(i).removeItem(sName);
                stop = true;
            }
            else{
                alert = "This playlist does not exist";
            }
        }
        return alert;
    }

    /**
     * Metodo para mostrar las playlist del usuario
     * <b>pre: </b> deben existir PLAYlISTS instanciadas dentro del usuario
     * <b>post: </b> se muestran por pantalla las playlist del usuario
     */
    public void showPrPlaylists(){
        for(int i = 0; i<prPlaylists.size(); i++){
            System.out.println(i +" - " +prPlaylists.get(i).getName());
        }
    }

    /**
     * Metodo para mostar las canciones de la libreria del usuario
     * <b>pre: </b> debe existir objetos SONG dentro de la libreria del usuario
     * <b>post: </b> se muestran por pantalla los objetos tipo SONG 
     * @param pName
     */
    public void showPremiumSongs(String pName){
        boolean continuar = true;
        for(int i = 0; i<prPlaylists.size() && continuar; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(pName)){
                prPlaylists.get(i).showSongs();
                continuar = false;
            } 
        }
    }

    /**
     * Metodo para cambiar de posicion de un objeto con otro dentro de una playlist
     * <b>pre: </b> debe existir un objeto tipo playlist dentro del usuarion con minimo dos canciones para que puedan cambiar de posicion
     * <b>post: </b> se cambian de lugar los audios elegidos
     * @param pName nombre de la playlist 
     * @param fSong nombre del primer audio
     * @param sSong nombre del segundo audio
     * @return retona alerta con el estado del metodo
     */
    public String switchPositionsPr(String pName, String fSong, String sSong){
        String alert = "This playlist does not exist";
        boolean continuar = false;
        for(int i = 0 ;i<prPlaylists.size() && !continuar; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(pName)){
                prPlaylists.get(i).switchItem(fSong, sSong);
                continuar = true;
            }
        }
        return alert;
    }

    /**
     * Metodo para añadir una audio a la playlist elegida por el usuaroio
     * <b>pre: </b> debe existir un objeto tipo PREMIUM intanciado previamente 
     * <b>post: </b> se añade un objeto AUDIOPRODUCT dentro de una playlist
     * @param playlistName nombre de la playlist
     * @param obj objeto AUDIOPRODUCT obtenido a partir de canciones de artistas
     * @return retorna el estado del metodo
     */
    public String addAudioToPlaylistPr(String playlistName, AudioProduct obj){
        String alert ="This playlist doesnt exist";
        boolean continuar = false;
        for(int i = 0; i<prPlaylists.size() && !continuar; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(playlistName)){
                continuar = true; 
                alert = prPlaylists.get(i).addSong(obj) + prPlaylists.get(i).getName();
            }
        }
        return alert;
    }

    /**
     * Metodo para compartir una playlist
     * <b>pre: </b> debe existir un objeto de clase PLAYLIST previamente instanciado dentro del usuario
     * <b>post: </b> se comparte la playlist con un codigo retornado
     * @param playlistName nombre digitado por el usaurio de la playlist
     * @return se retorna un codigo 
     */
    public String sharePlaylistPr(String playlistName){
        String alert = "The playlist doesnt exist";
        boolean stop = false;
        for(int i  = 0; i<prPlaylists.size() && !stop; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(playlistName)){
                alert = "To share the playlist " + prPlaylists.get(i).sharePlaylist();
                stop = true;  
            }
        }
        return alert;

    }

    public String simulateAudio(String pName, String sName){
        String alert = "This playlist doesnt exists";
        boolean stop = false;
        for(int i  = 0; i<prPlaylists.size() && !stop; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(pName)){
                stop = true;
                alert = prPlaylists.get(i).simulateAudio(sName);
            }
        }
        return alert;
    }

    @Override
    public int countPlayedAudio(String pName, String sName){
        int option = 4;
        boolean stop = false;
        for(int i  = 0; i<prPlaylists.size() && !stop; i++){
            if(prPlaylists.get(i).getName().equalsIgnoreCase(pName)){
                stop = true;
                option = prPlaylists.get(i).countPlayedAudio(sName);
            }
        }
        return option;
    }


    /**
     * Metodo get para el label del usuario
     * <b>pre: </b> debe existir un objeto de clase PREMIUM previamente instanciado 
     * <b>post: </b> se retorna el String del label 
     * @return se retorna el String del atributo
     */
    public String getLabel() {
        return label;
    }

}
