package model;

import java.util.ArrayList;

public class ContentCreator extends Productor {

    //atributes
    protected ArrayList<Podcast> contentCreatorPodcasts;

    //Methods
    /**
     * Metodo  constructor de la clase tipo CONTENTCREATOR
     * <b>pre: </b> atributos declaraddos previamente
     * <b>post: </b> se instancia un objeto tipo AUDIO PRODUCT
     * @param name nombre digitado por el usuario 
     * @param nickName nickName digitado por le usuario 
     * @param date la fecha se asigna en el momento que se crea el usuario
     * @param id el id se digita por el usuario
     * @param url la url se digita por el usuario 
     * @param year el años de digita por el usuario
     */
    public ContentCreator(String name, String nickName, String date, String id, String url, int year){
        super(name, nickName, date, id, url, year);
    }

    public String addAudio(String name, double length, String url, String album, double price, Genre kindGenre,String description, Category kind){
        String alert = "";
        contentCreatorPodcasts.add(new Podcast(name, length, url, description, kind));
        alert = " The podcast has been sucesfully added to the content creator";
        return alert;
    }

    /**
     * Metodo mostrar los podcaste del artista
     * <b>pre: </b> deben haber instanciado previamente un objeto tipo CONTENTCREATOR
     * <b>post: </b> se muetran los podcast registrados en esta clase
     */
    public void showPodcasts(){
        for(int i = 0; i<contentCreatorPodcasts.size(); i++){
            System.out.println( i + " - " + contentCreatorPodcasts.get(i).getName());
        }
    }

    /**
     * Metodo retornar un objeto PODCAST que fue registrado dentro del objeto CONTENTCREATOR
     * <b>pre: </b> Deben existier podcast registrados 
     * <b>post: </b> Se retorna un objeto PODCAST 
     * @param podName nombre elegido por el usuari
     * @return se retorna un objeto PODCAST
     */
    public Podcast choosenPodcast(String podName){
        boolean continuar = false;
        Podcast obj = null;
        for(int i = 0; i<contentCreatorPodcasts.size()&& !continuar; i++){
            if(contentCreatorPodcasts.get(i).getName().equalsIgnoreCase(podName)){
                obj = contentCreatorPodcasts.get(i);
                continuar = true;
            }
        }
        return obj; 
    }

    public String simulateAudio(String name, String aName){
        String alert = "This Podcats is not in the library of the Content creator";
        boolean stop = false;
        for(int i = 0; i<contentCreatorPodcasts.size() && !stop; i++){
            if(contentCreatorPodcasts.get(i).getName().equalsIgnoreCase(aName)){
                alert = "The Podcast " + contentCreatorPodcasts.get(i).getName() + " is being played";
            }
        }
        return alert;
    }

    /**
     * Metodo retornar el numero de podcast reproducidos
     * <b>pre: </b> previamnente se debio ejecutar el metodo simulateAudio
     * <b>post: </b> Se muestra el numero de reproducciones de Podcast por el usuario
     * @param aName nombre del objeto tipo PODCAST
     * @return se retorna el numero de reproducciones del podcast elegido
     */
    public int countPlayedPodcasts(String aName){
        boolean stop = false;
        int option = 4;
        for(int i = 0; i<contentCreatorPodcasts.size() && !stop; i++){
            if(contentCreatorPodcasts.get(i).getName().equalsIgnoreCase(aName)){
                if(contentCreatorPodcasts.get(i).getKind() == Category.POLITICS){
                    option = 0;
                } else if(contentCreatorPodcasts.get(i).getKind() == Category.ENTERNTAINMENT){
                    option = 1;
                } else if(contentCreatorPodcasts.get(i).getKind() == Category.VIDEOGAMES){
                    option = 2; 
                } else if(contentCreatorPodcasts.get(i).getKind() == Category.FASHION){
                    option = 3;
                }
            } 
        } 
        return option;
    }


    
}
