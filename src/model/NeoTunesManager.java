package model;
import java.util.*;

public class NeoTunesManager {

    //atributes
    private String name;
    private String id; 
    protected ArrayList <Consumer> registeredConsumers;
    protected ArrayList <Productor> registredProductors;
    protected ArrayList <AudioProduct> audioProducts;

    //relations 
    public NeoTunesManager(String name, String id){
        this.name = name; 
        this.id = id;
        registeredConsumers = new ArrayList<Consumer>();
        registredProductors = new ArrayList<Productor>();
        audioProducts = new ArrayList<AudioProduct>();
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
