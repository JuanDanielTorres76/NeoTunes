package model;

import java.util.ArrayList;

public class Artist extends Productor {

    //Atributes
    private String country; 
    protected ArrayList<Song> artistSongs;

    //Methods

    /**
     * Metodo constructor para la clase ARTSIST
     * <b>pre: </b> atributos declarados 
     * <b>post: </b> Se crea un objeto de la clase ARTIST 
     * @param name El nombre del artista lo asigna el usuario
     * @param nickName NickName digitado por el usuario 
     * @param date La fecha se asigna de acuerdo al momento exacto en el que se intancia el objeto
     * @param id EL ID lo digita el usuario
     * @param url la URL la digita el usuario
     * @param year el año la digita el usuario
     * @param country el pais lo digita el usuario
     */
    public Artist(String name, String nickName, String date, String id, String url, int year, String country){
        super(name, nickName, date, id, url, year);
        this.country = country;
        artistSongs = new ArrayList<Song>();

    } 

    @Override
    public String addAudio(String name, double length, String url, String album, double price, Genre kindGenre,String description, Category kind) {
        String alert = "";
        artistSongs.add(new Song(name, length, url, album, price, kindGenre));
        alert = "The song has been added to the Artist";
        return alert;
    }

    /**
     * Metodo para mostrar las canciones dentro de la calse ARTIST
     * <b>pre: </b>  debe existrir un objeto ARTIST instanciado 
     * <b>post: </b> Se muestran los objeto SONG dentro de la calse ARTIST 
     */
    public void showSongs(){
        for(int i = 0; i<artistSongs.size(); i++){
            System.out.println( i + " - " + artistSongs.get(i).getName());
        }
    }

    /**
     *  Metodo para mostrar una clase SONG elegida por el usuario
     * <b>pre: </b> deben existir cacniones instanciadas previamente 
     * <b>post: </b> Se retorna el objeto SONG
     * @param sName nombre de la cancion
     * @return Se retorna el objeto SONG
     */
    public Song choosenSong(String sName){
        boolean continuar = false;
        Song obj = null;
        for(int i = 0; i<artistSongs.size()&& !continuar; i++){
            if(artistSongs.get(i).getName().equalsIgnoreCase(sName)){
                obj = artistSongs.get(i);
                continuar = true;
            }
        }
        return obj; 
    }

    public String simulateAudio(String name, String aName){
        String alert = "This song is not in the library of the artist";
        boolean stop = false;
        for(int i = 0; i<artistSongs.size() && !stop; i++){
            if(artistSongs.get(i).getName().equalsIgnoreCase(aName)){
                alert = "The song " + artistSongs.get(i).getName() + " is being played";
            }
        }
        return alert;
    }

    /**
     *  Metodo para mostrar contar las canciones reproducidads por un usuario 
     * <b>pre: </b> Se debe instanciar previamente el metodo de simular audio   
     * <b>post: </b> se retorna el valor de numeros contados
     * @param aName El nombre de la cancion 
     * @return retorna el valor de numeros contados
     */
    public int CountPlayedSong(String aName){
        boolean stop = false;
        int option = 4;
        for(int i = 0; i<artistSongs.size() && !stop; i++){
            if(artistSongs.get(i).getName().equalsIgnoreCase(aName)){
                if(artistSongs.get(i).getKindGenre() == Genre.ROCK){
                    option = 0;
                } else if(artistSongs.get(i).getKindGenre() == Genre.POP){
                    option = 1;
                } else if(artistSongs.get(i).getKindGenre() == Genre.TRAP){
                    option = 2; 
                } else if(artistSongs.get(i).getKindGenre() == Genre.HOUSE){
                    option = 3;
                }
            } 
        } 
        return option;
    }

    /**
     * Metodo para simular la compra de una cancion
     * <b>pre: </b> deben existir objetos SONG dentro de la clase insatnciados previamente
     * <b>post: </b> Se retorna el una alerta que representa el exito de la simulacion
     * @param sName nombre de la cancion
     * @return se retorna una alerta
     */
    public boolean buySong(String sName){
        boolean stop = false;
        for(int i = 0; i<artistSongs.size() && !stop; i++){
            if(artistSongs.get(i).getName().equalsIgnoreCase(sName)){
                stop = true;    
            }
        }
        return stop;
    }

    /**
     * Metodo para zñadir una valor al contador de ventas despues de simular una compra
     * <b>pre: </b> instanciar el metodo buySong previamente
     * <b>post: </b> Se aumenta el contador de ventas 
     * @param sName el nombre de la cancion
     * @return aumenta el contador de ventas
     */
    public boolean addSale(String sName){
        boolean stop = false;
        for(int i = 0; i<artistSongs.size() && !stop; i++){
            if(artistSongs.get(i).getName().equalsIgnoreCase(sName)){
                stop = true;
            }
        }
        return stop;
    }

    /**
     * Metodo para añadir una transacion 
     * <b>pre: </b> deben existir canciones instanciadas previamente 
     * <b>post: </b> Se aumenta el valor de las transaciones
     * @param sName nombre de la cancion
     * @return se retorna el valor de las canciones
     */
    public double addTransaction(String sName){
        double price = 0;
        boolean stop = false;
        for(int i = 0; i<artistSongs.size() && !stop; i++){
            if(artistSongs.get(i).getName().equalsIgnoreCase(sName)){
                stop = true;
                price = artistSongs.get(i).getPrice();
            }
        }
        return price;
    }

    /**
     * Metodo get para obtener el pais de un artista 
     * <b>pre: </b> El atributo debe estar declarado previamente
     * <b>post: </b> se retorna el atributo
     * @return se retorna el atributo
     */
    public String getCountry() {
        return country;
    }

    
}
