package model;

public class Song extends AudioProduct {

    //atributes 
    private String album;
    private double price; 
    private Genre kindGenre;
    private int timesPlayed;
    private int sales;

    //methods
    
    public Song(String name, double length, String url, String album, double price, Genre kindGenre){
        super(name, length, url);
        this.album = album;
        this.price = price;
        this.kindGenre = kindGenre;
        timesPlayed = 0;
        sales = 0;

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

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

}
