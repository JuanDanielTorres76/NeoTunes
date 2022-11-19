package model;
import java.util.*;

public class NeoTunesManager {

    //atributes
    private String name;
    private String id; 
    protected ArrayList <Consumer> registeredConsumers;
    protected ArrayList <Productor> registredProductors;
    protected ArrayList <AudioProduct> audioProducts;
    protected int playedGenres[];
    protected int playedCategories[];
    private int numPlays;
    protected String aPodium[];
    protected String ccPodium[];
    protected String sPodium[];
    protected String pcPodium[];
    protected Store npStore;

    //relations 
    public NeoTunesManager(String name, String id){
        this.name = name; 
        this.id = id;
        registeredConsumers = new ArrayList<Consumer>();
        registredProductors = new ArrayList<Productor>();
        audioProducts = new ArrayList<AudioProduct>();
        playedGenres = new int[4];
        playedCategories = new int[4];
        fillCounters();
        numPlays = 0;
        aPodium = new String[10];
        ccPodium = new String[10];
        sPodium = new String [15];
        pcPodium = new String [15];
        npStore = new Store(name);
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

    public void showArtists(){
        int a = 1;
        for(int i = 0; i<registredProductors.size(); i++){
            if(registredProductors.get(i) instanceof Artist){
                System.out.println(a + " - " + registredProductors.get(i).getName());
            }
        }
    }

    public String showProductorAudio(String proName){
        String alert = "The productor has not been registered";
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
                    alert = "Content creator";
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
                    alert = obj.simulateAudio(pName, aName);
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
                    alert = obj.simulateAudio(pName, aName);
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
                    alert = obj.simulateAudio(pName, sName);
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
                    alert = obj.simulateAudio(pName, sName);
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

    public String buySong(String aName, String sName){
        String alert = "This artist doesnt exists ";
        boolean stop = false;
        for(int i = 0; i<registredProductors.size() && !stop; i++){
            if(registredProductors.get(i).getName().equalsIgnoreCase(aName)){
                stop = true;
                if(registredProductors.get(i) instanceof Artist){
                    Artist obj = (Artist)registredProductors.get(i);
                    Boolean validation = obj.buySong(sName);
                    Song obj1 = obj.choosenSong(sName);
                    alert = npStore.addTransaction(obj1, validation);
                } else {
                    alert = "This productor is not an artist";
                }
            }
                
        }
        return alert;
    }

    public int totalPlays(){
        int value = getNumPlays(), conValue = 0, proValue = 0, value1= 0;
        for(int i = 0; i<registredProductors.size() ; i++){
            proValue = registredProductors.get(i).getCatergoryPlays() + registredProductors.get(i).getGenrePlays();
        
        }
        for(int i = 0; i<registeredConsumers.size() ; i++){
            conValue = registeredConsumers.get(i).getCatergoryPlays() + registeredConsumers.get(i).getGenrePlays();
        }
        value1 = value + conValue+proValue; 
        setNumPlays(value1);
        return value1;
    }

    public String mostHearedGenreUsr(String uName){
        String alert = "This user doesnt exists";
        Boolean stop = true;
        for(int i = 0; i<registeredConsumers.size() && !stop ; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = "The most heared genre of the user is : " + obj.mostHearedGenreUsr() + " with " + obj.mostHearedGenreValueCon() + "reproductions";
                } else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = "The most heared genre of the user is : " + obj.mostHearedGenreUsr() + " with " + obj.mostHearedGenreValueCon() + "reproductions";
                } 
            }
        }
        return alert;
    }

    public String mostHearedGenre(){
        String alert = "", genre = "";
        int value = 0, conValue = 0, proValue = 0;
        for(int i = 0; i<registeredConsumers.size(); i++){
            conValue += registeredConsumers.get(i).getGenrePlays();
            genre = registeredConsumers.get(i).mostHearedGenreUsr();
        }
        for(int i = 0; i<registredProductors.size(); i++){
            proValue += registredProductors.get(i).getGenrePlays();
        }
        value = conValue + proValue;
        alert = "The most heared genre in the platform is" + genre + " with " + value + " reproductions";
        return alert;
    }

    public String mostHearedCategoryUser(String uName){
        String alert = "This user doesnt exists";
        Boolean stop = true;
        for(int i = 0; i<registeredConsumers.size() && !stop ; i++){
            if(registeredConsumers.get(i).getName().equalsIgnoreCase(uName)){
                if(registeredConsumers.get(i) instanceof Standard){
                    Standard obj = (Standard)registeredConsumers.get(i);
                    alert = "The most heared category of the user is : " + obj.mostHearedCategoryUsr() + " with " + obj.mostHearedCategoryValueCon() + "reproductions";
                } else if(registeredConsumers.get(i) instanceof Premium){
                    Premium obj = (Premium)registeredConsumers.get(i);
                    alert = "The most heared category of the user is : " + obj.mostHearedCategoryUsr() + " with " + obj.mostHearedCategoryValueCon() + "reproductions";
                } 
            }
        }
        return alert;
    }

    public String mostHearedCategory(){
        String alert = "", category = "";
        int value = 0, conValue = 0, proValue = 0;
        for(int i = 0; i<registeredConsumers.size(); i++){
            conValue += registeredConsumers.get(i).getCatergoryPlays();
            category = registeredConsumers.get(i).mostHearedCategoryUsr();
        }
        for(int i = 0; i<registredProductors.size(); i++){
            proValue += registredProductors.get(i).getCatergoryPlays();
        }
        value  = proValue + conValue;
        alert = "The most heared category in the platform is" + category + " with " + value + " reproductions";

        return alert;
    }

    public String artistPodium(){
        String artistPodium = "";
        ArrayList<Productor> podium = registredProductors;
        for(int i = 0; i<podium.size(); i++){
            if(registredProductors.get(i) instanceof Artist){
                for(int j = i; j > 0 ; j--){
                    if(podium.get(j).getTimesPlayed() > podium.get(j-1).getTimesPlayed()){
                        Productor tmp = podium.get(j);
                        podium.set(j, podium.get(j-1));
                        podium.set(j-1, tmp);
                    }
                }
            }
            
        }
        for(int i = 0; i<5 ; i++){
            aPodium[i] = "The artist " + podium.get(i).getName() + " has " + podium.get(i).getTimesPlayed() + " reproductions";
            artistPodium += aPodium[i];
        }
        return artistPodium; 
    }

    public String contentCreatorPodium(){
        String contentCPodium = "";
        ArrayList<Productor> podium = registredProductors;
        for(int i = 0; i<podium.size(); i++){
            if(registredProductors.get(i) instanceof ContentCreator){
                for(int j = i; j > 0 ; j--){
                    if(podium.get(j).getTimesPlayed() > podium.get(j-1).getTimesPlayed()){
                        Productor tmp = podium.get(j);
                        podium.set(j, podium.get(j-1));
                        podium.set(j-1, tmp);
                    }
                }
            }
        }
        for(int i = 0; i<5 ; i++){
            ccPodium[i] = "The artist " + podium.get(i).getName() + " has " + podium.get(i).getTimesPlayed() + " reproductions";
            contentCPodium += ccPodium[i];
        }
        return contentCPodium;
    }

    public String songsPodium(){
        String songPodium = "";
        ArrayList<AudioProduct> soPodium = audioProducts;
        for(int i = 0; i<soPodium.size(); i++){
            if(audioProducts.get(i) instanceof Song){
                for(int j = i; j>0; j--){
                    if(soPodium.get(j).getTimesPlayed() > soPodium.get(j-1).getTimesPlayed()){
                        AudioProduct tmp = soPodium.get(j);
                        soPodium.set(j, soPodium.get(j-1));
                        soPodium.set(j-1, tmp);
                    }
                }
            }
        }
        for(int i = 0; i<10; i++){
            if(soPodium.get(i) instanceof Song){
                Song obj = (Song)soPodium.get(i);
                sPodium[i] = "The Song " + soPodium.get(i).getName() + " of the genre " + obj.getKindGenre() + " has " + soPodium.get(i).getTimesPlayed() + " reproductions";
            }
            
        }
        return songPodium; 
    }

    public String podcastPodium(){
        String podcastPodium = "";
        ArrayList<AudioProduct> poPodium = audioProducts;
        for(int i = 0; i<poPodium.size(); i++){
            if(audioProducts.get(i) instanceof Podcast){
                for(int j = i; j>0; j--){
                    if(poPodium.get(j).getTimesPlayed() > poPodium.get(i).getTimesPlayed()){
                        AudioProduct tmp = poPodium.get(j);
                        poPodium.set(j, poPodium.get(j-1));
                        poPodium.set(j-1, tmp);
                    }
                }
            }
        }
        for(int i = 0; i<10; i++){
            if(poPodium.get(i) instanceof Podcast){
                Podcast obj = (Podcast)poPodium.get(i);
                pcPodium[i] = "The podcast " + poPodium.get(i).getName() + "of the category " + obj.getKind() + " has " + poPodium.get(i).getTimesPlayed() + " reproductions";
            }
        }
        return podcastPodium;
    }

    public String mostSelledGenre(){
        String alert = npStore.mostSelledGenre();
        return alert;
    }

    public String salesSongsGenre(int option){
        String alert = npStore.infoGenre(option);
        return alert;
    }

    public String mostSelledSong(){
        String alert = npStore.mostSelledSong(); 
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
    public int getNumPlays() {
        return numPlays;
    }

    public void setNumPlays(int numPlays) {
        this.numPlays = numPlays;
    }
    
}
