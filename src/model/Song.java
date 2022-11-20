package model;

public class Song extends AudioProduct {

    //atributes 
    private String album;
    private double price; 
    private Genre kindGenre;
    private int timesPlayed;
    private int sales;

    //methods
    
    /** 
     * Metodo constructor para el obejto SONG
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se insatncia el objeto
     * @param name nombre digitado por el usuario
     * @param length duracion digitado por el usuario
     * @param url url digitado por el usuario
     * @param album almbum digitado por el usuario
     * @param price precio digitado por el usuario
     * @param kindGenre genero elegido por el usuario
     */
    public Song(String name, double length, String url, String album, double price, Genre kindGenre){
        super(name, length, url);
        this.album = album;
        this.price = price;
        this.kindGenre = kindGenre;
        timesPlayed = 0;
        sales = 0;

    }

    /**
     * Metodo get para el atributo album
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se retorna el album
     * @return se retorna el atributo
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Metodo get para el atributo precio
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se retorna el precio
     * @return se retorna el atributo
     */
    public double getPrice() {
        return price;
    }

    /**
     * Metodo get para el atributo kindGenre
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se retorna el genero
     * @return s retorna el atributo 
     */
    public Genre getKindGenre() {
        return kindGenre;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    /**
     * Metodo get para el atributo sales
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se retorna las ventas
     * @return se retorna el atributo
     */
    public int getSales() {
        return sales;
    }

    /**
     * Metodo set para el atributo sales
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se cambia el valor del atributo ventas
     * @param sales el nuevo valor por el que se cambiara al atributo
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

}
