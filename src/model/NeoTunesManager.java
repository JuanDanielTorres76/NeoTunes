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
    /**
     * Metodo constructor para la clase NeoTunesManager
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto tipo NeoTunesManager
     * @param name nombre asignado por defecto 
     * @param id id asignado por defecto
     */
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

    /**
     * Metodo constructor para llenar los contadores de la clase 
     * <b>pre: </b> contadores declarados
     * <b>post: </b> se inicializan los contadores desde 0 
     */
    public void fillCounters(){
        for(int i = 0; i<playedGenres.length; i++){
            playedGenres[i] = 0;
            playedCategories[i] = 0;
        }
    }

    /**
     * Metodo para instnaciar un objeto heredado de la clase  CONSUMER 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto de las clases hijas del objeto tipo CONSUMER
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha asignada en el momento exacto de la creacion 
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     * @param numOfAds numero de anuncios asigando por defecto
     * @return retorna el estado del metodo 
     */
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

    /**
     *  Metodo para instnaciar un objeto heredado de la clase  CONSUMER 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto de las clases hijas del objeto tipo CONSUMER
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha asignada en el momento de creacion del usuario 
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     * @param label label digitado por el usuario
     * @return retorna el esatdo del metodo
     */
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

    /**
     * Metodo para instnaciar un objeto heredado de la clase  PORDUCTOR 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto de las clases hijas del objeto tipo PRODCUTOR
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha asignada en el momento de creacion del usuario 
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     * @param year año digitado por el usuario
     * @param country pais digitado por el usuario
     * @return retorna el estado del metodo
     */
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

    /**
     * Metodo para instnaciar un objeto heredado de la clase  PORDUCTOR 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto de las clases hijas del objeto tipo PRODCUTOR
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha asignada en el momento de creacion del objeto
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     * @param year año digitado por el usuario
     * @return retorna el estado del metodo
     */
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

    /**
     * Metodo para validar la existencia de un objeto tipo CONSUMER
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo CONSUMER 
     * <b>post: </b> se valida la existencia del objeto 
     * @param nickName nombre digitado por el usuario
     * @return se retorna la validacion de la existencia del objeto 
     */
    public boolean validateConsumer(String nickName){
        boolean validation = false; 
        for(int i = 0; i<registeredConsumers.size(); i++){
            if(registeredConsumers.get(i).getNickName().equalsIgnoreCase(nickName)){
                validation = true;
            }    
        }
        return validation;
    }

    /**
     * Metodo para validar la existencia de un objeto tipo PRODUCTOR
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo PRODUCTOR 
     * <b>post: </b> se valida la existencia del objeto 
     * @param nickName nickname digitado por el usuario
     * @return se retorna la validacion de la existencia del objeto
     */
     public boolean validateProductor(String nickName){
        boolean validation = false; 
        for(int i = 0; i<registredProductors.size(); i++){
            if(registredProductors.get(i).getNickName().equalsIgnoreCase(nickName)){
                validation = true;
            }    
        }
        return validation;
    }

    /**
     * Metodo para instanciar un objeto tipo SONG 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo USER para añdir una cancion 
     * <b>post: </b> Se instancia el objeto 
     * @param name nombre digitado por el usuario
     * @param length duracion digitado por el usuario
     * @param url url digitado por el usuario
     * @param album album digitado por el usuario
     * @param price precio digitado por el usuario
     * @param kindGenre genero escogido por el usuario
     * @param aName nombre del artista digitado por el usuario
     * @return retorna el estado del metodo
     */
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

    /**
     *  Metodo para validar la existencia de un objeto tipo SONG 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> Se valida la existencia del objeto 
     * @param name nombre digitado por el usuario
     * @return se retorna la validacion de la existencia del objeto 
     */
    public boolean validateSong(String name){
        boolean validation = false;
        for(int i = 0; i<audioProducts.size(); i++){
            if(audioProducts.get(i) instanceof Song && audioProducts.get(i).getName().equalsIgnoreCase(name)){
                validation = true;
            }
        }
        return validation;
    }

    /**
     * Metodo para instanciar un objeto tipo PODCAST 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo USER para añdir una cancion 
     * <b>post: </b> Se instancia el objeto tipo PODCAST
     * @param name nombre digitado por el usuario
     * @param length duracion digitada por el usuario
     * @param url url digitado por el usuario
     * @param description descripcion digitado por el usuario
     * @param kind categoria escogido por el usuario 
     * @param ccName nombre del creador de contenido degitado por el usuario
     * @return se retorna el estado del metodo 
     */
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

    /**
     * Metodo para validar la existencia de un objeto tipo PODCAST 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> Se valida la existencia del objeto 
     * @param name nombre escogido por el usuario
     * @return se retorna la validacion del objeto
     */
    public boolean validatePodcast(String name){
        boolean validation = false; 
        for( int i = 0; i<audioProducts.size(); i++){
            if(audioProducts.get(i) instanceof Podcast && audioProducts.get(i).getName().equalsIgnoreCase(name)){
                validation = true;
            }
        }
        return validation;
    }

    /**
     * Metodo para añadir un objeto tipo PLAYLSIT 
     * <b>pre: </b> debe haberse instanciado al menos una objeto tipo CONSUMER
     * <b>post: </b> Se crea el objeto
     * @param name nombre escogido por el usuario
     * @param nickname nickname escogido por el usuario
     * @return retorna el estado del metodo
     */
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

    /**
     * Metodo para editar un objeto de tipo PLAYLIST
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> de realiza la opcion que se escogio
     * @param uName nombre del usuario
     * @param pName nombre de la playlist
     * @param sName nombre de la cancion
     * @return se retorna el estado del metodo
     */
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

   /**
     * Metodo para mostrar por pantalla los usaurios registrados 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> Se muestran los usuarios registrados
     */
     public void showRegisteredUsers(){
        for(int i = 0; i<registeredConsumers.size(); i++){
            System.out.println(i + " - " +  registeredConsumers.get(i).getName());
        }
    }

    /**
     * Metodo para mostrar por pantalla los porductores registrados 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> Se muestran los productores registrados
     */
    public void showProductors(){
        for(int i = 0; i<registredProductors.size(); i++){
            System.out.println(i + " - " + registredProductors.get(i).getName());
        }
    }

    /**
     * Metodo para mostrar por pantalla los artistas registrados 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> Se muestran los artistas registrados
     */
    public void showArtists(){
        int a = 1;
        for(int i = 0; i<registredProductors.size(); i++){
            if(registredProductors.get(i) instanceof Artist){
                System.out.println(a + " - " + registredProductors.get(i).getName());
            }
        }
    }

    /**
     * Metodo para mostrar por pantalla los objetos tipo AUDIO registrados dentro de un PRODUCTOR 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de este tipo 
     * <b>post: </b> Se muestran las canciones registradas de un productor
     * @param proName nombre del productor
     * @return retorna por pantalla los audios de un productor
     */
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

    /**
     * Metodo para añadir un objeto AUDIO a una playlist
     * <b>pre: </b> debe haberse instanciado al menos un objeto ripo PLAYLIST 
     * <b>post: </b> Se añade un objeto tipo AUDIO a una playlist
     * @param uName nombre del usuario
     * @param playlistName nombre de la playlist 
     * @param pName nombre del productor 
     * @param aName nombre del audio
     * @return se retorna el estado del metodo 
     */
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
   
    /**
     * Metodo para cambiar las posiciones de obejtos audio dentro de una playlist 
     * <b>pre: </b> debe haberse instanciado un objeto tipo PLAYLIST con minimo dos audios instanciados dentro de la PLAYLIST
     * <b>post: </b> los objetos seleccionados cambian de posicion
     * @param uName nombre de usuario
     * @param pName nombre de la playlist
     * @param fSong nombre del primer audio
     * @param sSong nombre del segundo audio
     * @return muestra el estado del metodo
     */
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


    /**
     * Metodo para mostrar las playlist añadidas de un usuario
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo consumer con una playlist añadida
     * <b>post: </b> Se muestran las playlist añadidas del usuario
     * @param uName nombre del usuario
     */
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

    /**
     * Metodo para mostrar los audios de una playlist de un usuario
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo consumer con una playlist y audios dentro de esta
     * <b>post: </b> Se muestran los aduidos dentro de la playlist escogida
     * @param uName nombre del usaurio
     * @param pName nombre de la playlist
     */
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

    /**
     *  Metodo para compartir una playlist
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo consumer con una playlist añadida
     * <b>post: </b> Se retorna un codigo de la playlist
     * @param uName nombre del usaurio
     * @param playlistName nombre de la playlist
     * @return se retorna el estado del metodo
     */
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

    /**
     * Metodo para simular la reproduccion de un audio
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo productor con una playlist añadida y audios dentro de esta.
     * <b>post: </b> Se aumentan los contadores que tienen registro de la reproduccion de los audios
     * @param pName nombre de la playlist
     * @param aName nombre del audio
     * @return Se retorna el estado del metodo
     */
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

    /**
     *  Metodo para simular la reproduccion de un audio
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo consumer con una playlist añadida y audios dentro de esta.
     * <b>post: </b> Se aumentan los contadores que tienen registro de la reproduccion de los audios
     * @param cName nombre del usuario
     * @param pName nombre de la playlist
     * @param sName nombre de la cancion
     * @return se retorna el estado del metodo
     */
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

    /**
     * Metodo para simular la compra de una cancion 
     * <b>pre: </b> debe haberse instanciado al menos una objeto de tipo SONG  dentro de un usuario
     * <b>post: </b> Se añade una transaccion a la clase SHOP
     * @param aName nombre del artista
     * @param sName nombre de la cancion
     * @return retorna el estado del metodo
     */
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

    /**
     *  Metodo para retornar el total de reproducciones de la cancion
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se aumentan los contadores que tienen registro de la reproduccion de los audios
     * @return se retorna el valor del total de ventas
     */
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

    /**
     * Metodo para mostrar el genero mas escuchado de un usuario
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retorna en string el valor de reproducciones del genero mas escuchado 
     * @param uName nombre del usuario
     * @return retorna el genero mas escuchado.
     */
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

    /**
     * Metodo para mostrar el genero mas escuchado de la plataforma
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retorna en string el genero mas escuchado
     * @return retorna el genero mas escucahdo
     */
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

    /**
     * Metodo para mostrar la catgeoria mas escuchado de un usuario
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retorna en string el valor de reproducciones de categoria mas escuchado por un usuario
     * @param uName nombre del usuario
     * @return retorna el genero mas escuchado
     */
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

    /**
     * Metodo para mostrar el genero mas escuchado de la plataforma
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retorna en string el valor de reproducciones del genero mas escuchado  en la plataforma
     * @return se retorna la categoria mas escuchado
     */
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

    /**
     * Metodo para mostrar el top de los artistas mas escuchados
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retornan por impresion los 5 primeros artsitas de acuerdo a su atributo de las reporducciones 
     * @return se retorna el podio de los artistas
     */
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

    /**
     * Metodo para mostrar el top de los artistas mas escuchados
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retornan por impresion los 5 primeros creadores de contenido de acuerdo a su atributo de las reporducciones
     * @return se retorna el podio de los creadores de contenido 
     */
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

    /**
     * Metodo para mostrar el top de las canciones mas escuchadas
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retornan por impresion las 10 primeros canciones de acuerdo a sus reporducciones
     * @return se retorna el podio de la top de las canciones
     */
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

    /**
     * Metodo para mostrar el top de los podcast mas escuchados
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de audio previamente
     * <b>post: </b> Se retornan por impresion las 10 primeros podcast de acuerdo a sus reporducciones
     * @return se retorna el podio de podcast
     */
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

    /**
     * Metodo para mostrar el genero mas vendido
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de compra de cancione 
     * <b>post: </b> Se retornan el genero mas vendido de canciones
     * @return se retorna el genero mas vendido
     */
    public String mostSelledGenre(){
        String alert = npStore.mostSelledGenre();
        return alert;
    }

    /**
     * Metodo para mostrar las ventas de un genero seleccionado
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de compra de una cancion 
     * <b>post: </b> Se retornan el valor de ventas de un genero seleccionado.
     * @param option
     * @return
     */
    public String salesSongsGenre(int option){
        String alert = npStore.infoGenre(option);
        return alert;
    }

    /**
     * Metodo para mostrar la cancion mas vendida.
     * <b>pre: </b> debe haberse instanciado el metodo de simulacion de compra de canciones 
     * <b>post: </b> Se retorna el nombre de la cacnion mas vendida
     * @return se retorna la cancion mas vendida
     */
    public String mostSelledSong(){
        String alert = npStore.mostSelledSong(); 
        return alert;
    }

    /**
     * Metodo get para el atributo id
     * <b>pre: </b> debe haberse declarado los atributos
     * <b>post: </b> Se retorna el atributo 
     * @return se retorna el atributo 
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo set para el atributo id
     * <b>pre: </b> debe haberse declarado los atributos
     * <b>post: </b> Se retorna el atributo con el valor nuevo
     * @param id valor nuevo el que tomara el id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo get para el atributo name
     * <b>pre: </b> debe haberse declarado los atributos
     * <b>post: </b> Se retorna el atributo 
     * @return se retorna el atributo
     */
    public String getName() {
        return name;
    }

    /**
     *  Metodo set para el atributo name
     * <b>pre: </b> debe haberse declarado los atributos
     * <b>post: </b> Se retorna el atributo con el valor nuevo
     * @param name nuevo nombre el que tomara el atributo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo get para el atributo numPlays
     * <b>pre: </b> debe haberse declarado los atributos
     * <b>post: </b> Se retorna el atributo 
     * @return se retorna el atributo
     */
    public int getNumPlays() {
        return numPlays;
    }

    /**
     * Metodo set para el atributo numPlays
     * <b>pre: </b> debe haberse declarado los atributos
     * <b>post: </b> Se retorna el atributo con el valor nuevo
     * @param numPlays nuevo valor al que tomara el atributo
     */
    public void setNumPlays(int numPlays) {
        this.numPlays = numPlays;
    }
    
}
