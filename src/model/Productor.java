package model;

public abstract class Productor extends User{

    //Atributes 
    private int year;
    private int timesPlayed;

    //methods

    public Productor(String name, String nickName, String date, String id, String url, int year){
        super(name, nickName, date, id, url);
        this.year = year;
        timesPlayed =0;
    }

    public abstract String addAudio(String name, double length, String url, String album, double price, Genre kindGenre, String description, Category kind);

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }


    
}
