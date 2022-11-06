package model;

public class Song extends AudioProduct {

    //atributes 
    private String album;
    private double price; 
    private Genre kindGenre;

    //methods
    
    public Song(String name, double length, String url, String album, double price, Genre kindGenre){
        super(name, length, url);
        this.album = album;
        this.price = price;
        this.kindGenre = kindGenre;

    }

    public String getAlbum() {
        return album;
    }

    public double getPrice() {
        return price;
    }

    public Genre getKindGenre() {
        return kindGenre;
    }

}
