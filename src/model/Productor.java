package model;

public abstract class Productor extends User{

    //Atributes 
    private int year;

    //methods

    public Productor(String name, String nickName, String date, String id, String url, int year){
        super(name, nickName, date, id, url);
        this.year = year;
    }

    public abstract String addAudio(String name, double length, String url, String album, double price, Genre kindGenre, String description, Category kind);

    public int getYear() {
        return year;
    }


    
}
