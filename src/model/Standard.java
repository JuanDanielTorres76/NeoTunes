package model;


public class Standard extends Consumer {
    
    //atributes
    private int numOfAds;
    protected Song stSongs[];
    protected Playlist stPlaylists[];

    //metthods

    /**
     *  Metodo constructor para el obejto STANDARD
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se insatncia el objeto
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha se saigna en el momento en el que se instancia el objeto
     * @param id id digitado por el usuari
     * @param url url digitado por el usuario
     * @param numOfAds numero de anuncio digitado por el usuario
     */
    public Standard(String name, String nickName, String date, String id, String url, int numOfAds){
        super(name, nickName, date, id, url);
        this.numOfAds = numOfAds;
        stSongs = new Song[100];
        stPlaylists = new Playlist[5];

    }

    /**
     * Metodo para añadir un obejto PLAYLIST a STANDARD 
     * <b>pre: </b> objeto STANDARD previamente instanciado
     * <b>post: </b> se añade el obejto 
     * @param name nombre digitado por el usuario
     * @return estado del metodo 
     */
    public String addPlaylistToStandard(String name){
        boolean stop = false, validate = validateNameOfPlaylist(name);
        String alert = "";
        if( validate == false){
            for(int i = 0; i<stPlaylists.length && !stop; i++){
                if(stPlaylists == null){
                    stPlaylists[i] = new Playlist(name);
                    alert = "The playlist has been sucesfullyu added";
                    stop = true;
                }
                else{
                    alert = "The quantity of playlist has reached its limit";
                }
            }
        }else{
            alert = "Choose another name for the playlist, this one has already been used"; 
        }
        
        return alert;
    }

    /**
     * Metodo para validar la existencia de una playlist con el mismo nombre 
     * <b>pre: </b> objeto PLAYLIST previamente instanciados
     * <b>post: </b> se valida la existencia del objeto
     * @param name nombre digitado por el usuario
     * @return se retorna la validacion
     */
    public boolean validateNameOfPlaylist(String name){
        boolean stop = false;
        for(int i = 0; i<stPlaylists.length && !stop; i++){ 
            if(stPlaylists[i].getName().equalsIgnoreCase(name)){
                stop = true;
            }
        }
        return stop;
    }

    /**
     * Metodo para añadir un objeto SONG al usuario
     * <b>pre: </b> objeto STANDARD previamente instanciado
     * <b>post: </b> se añade el objeto SONG a la libreria del usaurio
     * @param name nombre digitado por el usuario
     * @param length duracion digitado por el usuario
     * @param url url digitado por el usuario
     * @param album album digitado por el usuario
     * @param price precio digitado por el usuario
     * @param kindGenre genero escogido por el usuario
     * @return
     */
    public String addSongToStandard(String name, double length, String url, String album, double price, Genre kindGenre){
        boolean stop = false, validate = validateNameOfSong(name);
        String alert = "";
        if(validate == false){
            for(int i = 0; i<stSongs.length && !stop; i++ ){
                if(stSongs[i] == null && stSongs.length<100){
                    stSongs[i] = new Song(name, length, url, album, price, kindGenre);
                    alert = "The song has been sucesfully added to the library";
                    stop = true;
                } else{
                    alert = "The library has reached its limits, your account only allows 100 songs";
                }
                
            }
        } else{
            alert = "This song has already been added";
        }
        return alert;
        
    }

    /**
     * Metodo para validar la existencia de una Cancion con el mismo nombre 
     * <b>pre: </b> objeto STANDARD previamente instanciados con Audios dentro de su libreria
     * <b>post: </b> se valida la existencia del objeto
     * @param name nombre digitado por el usuario
     * @return se retorna la validacion de la existencia del objeto
     */
    public boolean validateNameOfSong(String name){
        boolean stop = false;
        for(int i = 0; i<stSongs.length && !stop ; i++){
            if(stSongs[i].getName().equalsIgnoreCase(name)){
                stop = true; 
            }
        }
        return stop;

    }

    /**
     *  Metodo para elimianr un item de una playlist dentro del usaurio
     * <b>pre: </b> debe exitir un obejto STANDARD y PLAYLIST con objetos añadidos previamente 
     * <b>post: </b> se elimina el objeto
     * @param pName nombre de la playlist elegido por el usuario
     * @param sName nombre de la cancion elegido por el usaurio
     * @return se retorna el estado del metodo
     */
    public String removeItemFromPlaylistSt(String pName, String sName){
        String alert = "";
        boolean stop = false;
        for(int i = 0; i<stPlaylists.length && !stop; i++){
            if(stPlaylists[i].getName().equalsIgnoreCase(pName)){
                alert = stPlaylists[i].removeItem(sName);
                stop = true;
            }
            else{
                alert = "This playlist does not exist";
            }
        }
        return alert;

    }

    /**
     *  Metodo para mostrar las playlist del usuario
     * <b>pre: </b> objeto PLAYLIST previamente instanciados
     * <b>post: </b> se mustan las playlist del usuario
     */
    public void showStandardPlaylists(){
        boolean continuar = true;
        for(int i = 0; i<stPlaylists.length && continuar; i++){
            if(stPlaylists[i] != null){
                System.out.println(i +" - " +stPlaylists[i].getName());
            } else{
                continuar = false;
            }
        }
    }

    /**
     *  Metodo para cambiar las posiciones de objetos en una playlist
     * <b>pre: </b> objeto PLAYLIST previamente instanciados
     * <b>post: </b> se cambian las posiciones de los objetos dentro de una playlist
     * @param pName nombre de la playlist 
     * @param fSong nombre de la primera cancion
     * @param sSong nombre de la segunda cancion 
     * @return se retorna el estado del metodo
     */
    public String switchPositionsSt(String pName, String fSong, String sSong){
        String alert = "This playlist does not exist";
        boolean continuar = false;
        for(int i = 0 ;i<stPlaylists.length && !continuar; i++){
            if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(pName)){
                alert = stPlaylists[i].switchItem(fSong, sSong);
                continuar = true;
            }
        }
        return alert;
    }

    /**
     *  Metodo para mostrar las canciones de en la playlist del usuario
     * <b>pre: </b> cacniones añadidas previamente en la libreria
     * <b>post: </b> se muestra por pantalla las cancioens de la playlist
     * @param pName nombre de la playlist
     */
    public void showStandardSongs(String pName){
        boolean continuar = true;
        for(int i = 0; i<stPlaylists.length && continuar; i++){
            if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(pName)){
                stPlaylists[i].showSongs();
                continuar = false;
            } 
        }
    }

    /**
     *  Metodo para añadir objeto playlist a usaurio STANDARD 
     * <b>pre: </b> objeto STANDARD previamente insatnciado
     * <b>post: </b> se añade el objeto
     * @param playlistName nombre de la playlist
     * @param obj obejeto tipo AUDIOPRODUCT obtenido previamente 
     * @return se retorna alerta de estado del metodo
     */
    public String addAudiotoPlaylistSt(String playlistName, AudioProduct obj){
        boolean continuar = false;
        String alert = "This playlist doesnt exist";
        if(stPlaylists.length>100){
            alert = "The user has reached the limit of Songs";
        } else{
            for(int i = 0; i<stPlaylists.length && !continuar; i++){
                if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(playlistName)){
                    continuar = true; 
                    alert = stPlaylists[i].addSong(obj) + stPlaylists[i].getName();
                }
            }
        }
        return alert; 
    }

    /**
     *  Metodo para compartir playlist del usuario
     * <b>pre: </b> objeto PLAYLIST previamente instanciados
     * <b>post: </b> se imprime por pantalla un codigo para compartir la playlist
     * @param playlistName nombre de la playlist a compartir
     * @return se retorna el codigo de la playlist
     */
    public String sharePlaylistSt(String playlistName){
        String alert = "The playlist doesnt exist";
        boolean stop = false;
        for(int i  = 0; i<stPlaylists.length && !stop; i++){
            if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(playlistName)){
                alert = "To share the playlist " + stPlaylists[i].sharePlaylist();
                stop = true;
            }
        }
        return alert;
    }

    public String simulateAudio(String pName, String sName){
        String alert = "This playlist doesnt exists";
        boolean stop = false;
        for(int i  = 0; i<stPlaylists.length && !stop; i++){
            if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(pName)){
                stop = true;
                alert = stPlaylists[i].simulateAudio(sName);
            }
        }
        return alert;
    }
    
    @Override
    public int countPlayedAudio(String pName, String sName){
        int option = 4;
        boolean stop = false;
        for(int i  = 0; i<stPlaylists.length && !stop; i++){
            if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(pName)){
                stop = true;
                option = stPlaylists[i].countPlayedAudio(sName);
            }
        }
        return option;

    }

    /** 
     * Metodo get para el atributo NumOfAds 
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el valor del atributo
     * @returnretorna el atributo
     */
    public int getNumOfAds() {
        return numOfAds;
    }
}
