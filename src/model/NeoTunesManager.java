package model;
import java.util.*;

public class NeoTunesManager {

    //atributes
    private String name;
    private String id; 
    protected ArrayList <Consumer> registeredConsumers;
    protected ArrayList <Productor> registredProductors;
    protected ArrayList <AudioProduct> audioProducts;
    protected int playedGenres[] = new int[4];
    protected int playedCategories[] = new int[4];

    //relations 
    public NeoTunesManager(String name, String id){
        this.name = name; 
        this.id = id;
        registeredConsumers = new ArrayList<Consumer>();
        registredProductors = new ArrayList<Productor>();
        audioProducts = new ArrayList<AudioProduct>();
    }

    public void fillCounters(){
        for(int i = 0; i<playedGenres.length; i++){
            playedGenres[i] = 0;
            playedCategories[i] = 0;
        }
    }

    public String addConsumer(String name, String nickName, String date, String id, String url, int numOfAds){
        boolean validate = validateConsumer(nickName); 
        String alert = "";
        if(validate){
            alert = "This user has already been created";
        }
        else{
            registeredConsumers.add(new Standard(name, nickName, date, id, url, numOfAds));
            alert = "The user has been sucesfully created";
        }
        return alert; 
    }

    public String addConsumer(String name, String nickName, String date, String id, String url, String label){
        boolean validate = validateConsumer(nickName); 
        String alert = "";
        if(validate){
            alert = "This user has already been created";
        }
        else{
            registeredConsumers.add(new Premium(name, nickName, date, id, url, label));
            alert = "The user has been sucesfully created";
        }
        return alert; 
    }

    public String addProductor(String name, String nickName, String date, String id, String url, int year, String country){
        boolean validate = validateProductor(nickName); 
        String alert = "";
        if(validate){
            alert = "This user has already been created";
        }
        else{
            registredProductors.add(new Artist(name, nickName, date, id, url, year, country));
            alert = "The user has been sucesfully created";
        }
        return alert; 
    }

    public String addProductor(String name, String nickName, String date, String id, String url, int year){
        boolean validate = validateProductor(nickName); 
        String alert = "";
        if(validate){
            alert = "This user has already been created";
        }
        else{
            registredProductors.add(new ContentCreator(name, nickName, date, id, url, year));
            alert = "The user has been sucesfully created";
        }
        return alert;         
    }

    public boolean validateConsumer(String nickName){
        boolean validation = false; 
        for(int i = 0; i<registeredConsumers.size(); i++){
            if(registeredConsumers.get(i).getNickName().equalsIgnoreCase(nickName)){
                validation = true;
            }    
        }
        return validation;
    }

    public boolean validateProductor(String nickName){
        boolean validation = false; 
        for(int i = 0; i<registredProductors.size(); i++){
            if(registredProductors.get(i).getNickName().equalsIgnoreCase(nickName)){
                validation = true;
            }    
        }
        return validation;
    }

    public String addSong(String name, double length, String url, String album, double price, Genre kindGenre, String aName){
        boolean validate = validateSong(name);
        String message = "", description = "";
        if(validate){
            message = "This song has already been registered";
        }
        else{
            for(int i = 0; i<registredProductors.size(); i++){
                if(registredProductors.get(i) instanceof Artist){
                    if(registredProductors.get(i).getNickName().equalsIgnoreCase(aName) || registredProductors.get(i).getName().equalsIgnoreCase(aName)){
                        message = registredProductors.get(i).addAudio(name, length, url, album, price, kindGenre, description, null);
                        audioProducts.add(new Song(name, length, url, album, price, kindGenre));
                    }
                } else{
                    message = "This artist hasnt been registered yet";
                }
            }
        }
        return message;
    }

    public boolean validateSong(String name){
        boolean validation = false;
        for(int i = 0; i<audioProducts.size(); i++){
            if(audioProducts.get(i) instanceof Song && audioProducts.get(i).getName().equalsIgnoreCase(name)){
                validation = true;
            }
        }
        return validation;
    }

    public String addPodcast(String name, double length, String url, String description, Category kind, String ccName){
        boolean validation = validatePodcast(name);
        String alert = "", album = "";
        if(validation){
            alert = " This podcast has already been registered";
        }
        else{
            for(int i = 0; i<registredProductors.size(); i++){
                if(registredProductors.get(i) instanceof ContentCreator){
                    if(registredProductors.get(i).getNickName().equalsIgnoreCase(ccName) || registredProductors.get(i).getName().equalsIgnoreCase(ccName)){
                        alert = registredProductors.get(i).addAudio(name, length, url, album, 0, null, description, kind);
                        audioProducts.add(new Podcast(name, length, url, description, kind));
                    }
                } else{
                    alert = "This content creator has not been registered yet";
                }
            }
        }
        return alert;
    }

    public boolean validatePodcast(String name){
        boolean validation = false; 
        for( int i = 0; i<audioProducts.size(); i++){
            if(audioProducts.get(i) instanceof Podcast && audioProducts.get(i).getName().equalsIgnoreCase(name)){
                validation = true;
            }
        }
        return validation;
    }

    public String addPlaylist(String name, String nickname){
        String alert = "";
        boolean stop = false;
        for(int i = 0; i<registeredConsumers.size() && !stop; i++){
            if(registeredConsumers.get(i).getNickName().equalsIgnoreCase(nickname)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = obj.addPlaylistToStandard(name);
                } else if( registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = obj.addPlaylistToPremium(name);
                }
                stop = true;
            }else{
                alert = "This user hasnt been created yet";
            }
        }
        
        return alert;
    }

    public String editPlaylist(String uName, String pName, String sName){
        boolean stop = false;
        String alert = "";
        for(int i = 0; i<registeredConsumers.size() && !stop ; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = obj.removeItemFromPlaylistSt(pName, sName);
                }else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = obj.removeItemFromPlaylistPr(pName, sName);
                }
                stop = true;
            }
            else{
                alert = "This user does not exist ";
            }
        }
        return alert;
    }

    public void showRegisteredUsers(){
        for(int i = 0; i<registeredConsumers.size(); i++){
            System.out.println(i + " - " +  registeredConsumers.get(i).getName());
        }
    }

    public void showProductors(){
        for(int i = 0; i<registredProductors.size(); i++){
            System.out.println(i + " - " + registredProductors.get(i).getName());
        }
    }

    public String showProductorAudio(String proName){
        String alert = "The porductor has not been registered";
        boolean continuar = false;
        for(int i = 0; i<registredProductors.size() && !continuar; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(proName)){
                continuar = false;
                if(registredProductors.get(i) instanceof Artist){
                    Artist obj = (Artist)registredProductors.get(i);
                    alert = "Artists";
                    obj.showSongs();
                } else if(registredProductors.get(i) instanceof ContentCreator){
                    ContentCreator obj = (ContentCreator)registredProductors.get(i);
                    obj.showPodcasts();
                    alert = "Contet creator";
                }
            } 
        }
        return alert;
    }

    public String addAudioToPlaylist(String uName, String playlistName, String pName, String aName){
        String alert = "";
        boolean continuar = false, continuar1 = false, continuar2 = false; 
        for(int i = 0; i<registredProductors.size() && !continuar1; i++){
            if(registredProductors.get(i).getName().equalsIgnoreCase(pName)){
                continuar1= true;
                if(registredProductors.get(i) instanceof Artist){
                    Artist objP = (Artist)registredProductors.get(i); 
                    Song chSong = objP.choosenSong(aName);
                    if(chSong == null){
                        alert = "The song doesnt exit";
                        continuar = true;
                    }
                    for(int a = 0; a<registeredConsumers.size() && !continuar; a++){
                        if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                            continuar = true;
                            if(registeredConsumers.get(i) instanceof Standard){
                                Standard obj = (Standard)registeredConsumers.get(i);
                                alert = obj.addAudiotoPlaylistSt(playlistName, chSong);
                            } else if(registeredConsumers.get(i) instanceof Premium){
                                Premium obj = (Premium)registeredConsumers.get(i);
                                alert = obj.addAudioToPlaylistPr(playlistName, chSong);
                            }
                        }
                    }
                }else if(registredProductors.get(i) instanceof ContentCreator){
                    ContentCreator objP = (ContentCreator)registredProductors.get(i);
                    Podcast chPodcast = objP.choosenPodcast(aName);
                    if(chPodcast == null){
                        alert = "The podcast doesnt exist";
                        continuar2 = true;
                    }
                    for(int b = 0; b<registeredConsumers.size() && !continuar2; b++){
                        if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                            continuar2 = true;
                            if(registeredConsumers.get(i) instanceof Standard){
                                Standard obj = (Standard)registeredConsumers.get(i);
                                alert = obj.addAudiotoPlaylistSt(playlistName, chPodcast);
                            } else if(registeredConsumers.get(i) instanceof Premium){
                                Premium obj = (Premium)registeredConsumers.get(i);
                                alert = obj.addAudioToPlaylistPr(playlistName, chPodcast);
                            }
                        }
                    }
                }
            } else {
                alert = "The productor doesnt exist ";
            }
        }

        return alert;
    }
   
    public String switchPositions(String uName, String pName, String fSong, String sSong){
        boolean stop = false; 
        String alert = "";
        for(int i = 0; i<registeredConsumers.size() && !stop ; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = obj.switchPositionsSt(pName, fSong, sSong);
                }else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = obj.switchPositionsPr(pName, fSong, sSong);
                }
                stop = true;
            }
            else{
                alert = "This user does not exist ";
            }
        }
        return alert;
    }


    public void showUserPlaylists(String uName){
        for(int i = 0; i<registeredConsumers.size(); i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    obj.showStandardPlaylists();
                } else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    obj.showPrPlaylists();
                }
            }
        }
    }

    public void showAudioOfPlaylist(String uName, String pName){
        for(int i = 0; i<registeredConsumers.size(); i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    obj.showStandardSongs(pName);
                } else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    obj.showPremiumSongs(pName);
                }
            }
        }

    }

    public String sharePlaylist(String uName, String playlistName){
        String alert = "This user doesnt exist";
        boolean stop = false;
        for(int i = 0; i<registeredConsumers.size() && !stop; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = obj.sharePlaylistSt(playlistName);
                } else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = obj.sharePlaylistPr(playlistName);
                }
            }
        }
        return alert;
    }

    public String SimulateAudioPr(String pName, String aName){
        String alert = "This produtor doesnt exists";
        int option = 4; 
        boolean stop = false;
        for(int i = 0; i<registredProductors.size() && !stop; i++){
            if(registredProductors.get(i).getName().equalsIgnoreCase(pName)){
                stop = true;
                if(registredProductors.get(i) instanceof Artist){
                    Artist obj = (Artist)registredProductors.get(i);
                    alert = obj.simulateSong(aName);
                    option = obj.CountPlayedSong(aName);
                    if(option == 0){
                        playedGenres[option]++; 
                    }else if( option ==  1){
                        playedGenres[option]++;
                    }else if( option ==  2){
                        playedGenres[option]++;
                    }else if( option ==  3){
                        playedGenres[option]++;
                    }else if( option ==  4){
                        alert = "Couldnt register playback of audio";
                    }
                } else if(registredProductors.get(i) instanceof ContentCreator){
                    ContentCreator obj = (ContentCreator)registredProductors.get(i);
                    alert = obj.simulatePodcast(aName);
                    option = obj.countPlayedPodcasts(aName);
                    if(option == 0){
                        playedCategories[option]++; 
                    }else if( option ==  1){
                        playedCategories[option]++;
                    }else if( option ==  2){
                        playedCategories[option]++;
                    }else if( option ==  3){
                        playedCategories[option]++;
                    }else if( option ==  4){
                        alert = "Couldnt register playback of podcast";
                    }

                }
            }
        }
        return alert;
    }

    public String simulateAudioCm(String cName, String pName, String sName){
        String alert = "This user doesnt exists";
        int option = 4;
        boolean stop = false;
        for(int i = 0; i<registeredConsumers.size() && !stop; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(cName)){
                stop = true;
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = obj.simulateAudioSt(pName, sName);
                    option = obj.countPlayedAudio(pName, sName);
                    if(option == 0){
                        playedGenres[option]++; 
                    }else if( option ==  1){
                        playedGenres[option]++;
                    }else if( option ==  2){
                        playedGenres[option]++;
                    }else if( option ==  3){
                        playedGenres[option]++;
                    }else if( option ==  4){
                        alert = "Couldnt register playback of audio";
                    }else if( option ==  5){
                        playedCategories[option]++;
                    }else if( option ==  6){
                        playedCategories[option]++;
                    }else if( option ==  7){
                        playedCategories[option]++;
                    }else if( option ==  8){
                        playedCategories[option]++;
                    }
                } else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = obj.simulateAudioPr(pName, sName);
                    option = obj.countPlayedAudio(pName, sName);
                    if(option == 0){
                        playedGenres[option]++; 
                    }else if( option ==  1){
                        playedGenres[option]++;
                    }else if( option ==  2){
                        playedGenres[option]++;
                    }else if( option ==  3){
                        playedGenres[option]++;
                    }else if( option ==  4){
                        alert = "Couldnt register playback of audio";
                    }else if( option ==  5){
                        playedCategories[option]++;
                    }else if( option ==  6){
                        playedCategories[option]++;
                    }else if( option ==  7){
                        playedCategories[option]++;
                    }else if( option ==  8){
                        playedCategories[option]++;
                    }
                }
            }
        }

        return alert;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
