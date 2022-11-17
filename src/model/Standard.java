package model;


public class Standard extends Consumer {
    
    //atributes
    private int numOfAds;
    protected Song stSongs[];
    protected Playlist stPlaylists[];

    //metthods

    public Standard(String name, String nickName, String date, String id, String url, int numOfAds){
        super(name, nickName, date, id, url);
        this.numOfAds = numOfAds;
        stSongs = new Song[100];
        stPlaylists = new Playlist[5];

    }

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

    public boolean validateNameOfPlaylist(String name){
        boolean stop = false;
        for(int i = 0; i<stPlaylists.length && !stop; i++){ 
            if(stPlaylists[i].getName().equalsIgnoreCase(name)){
                stop = true;
            }
        }
        return stop;
    }

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

    public boolean validateNameOfSong(String name){
        boolean stop = false;
        for(int i = 0; i<stSongs.length && !stop ; i++){
            if(stSongs[i].getName().equalsIgnoreCase(name)){
                stop = true; 
            }
        }
        return stop;

    }

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

    public void showStandardSongs(String pName){
        boolean continuar = true;
        for(int i = 0; i<stPlaylists.length && continuar; i++){
            if(stPlaylists[i] != null && stPlaylists[i].getName().equalsIgnoreCase(pName)){
                stPlaylists[i].showSongs();
                continuar = false;
            } 
        }
    }

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
    public int getNumOfAds() {
        return numOfAds;
    }
}
