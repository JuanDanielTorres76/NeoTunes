package model;

public abstract class AudioProduct {
    
    //Atributes
    private String name; 
    private double length; 
    private String url;
    private int timesPlayed;


    //methods
    public AudioProduct(String name, double length, String url){
        this.name = name;
        this.length = length;
        this.url = url;
        timesPlayed = 0;
    }
    
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    
    public String getUrl() {
        return url;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

}
