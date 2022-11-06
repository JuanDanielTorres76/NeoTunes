package model;

public abstract class AudioProduct {
    
    //Atributes
    private String name; 
    private double length; 
    private String url;


    //methods
    public AudioProduct(String name, double length, String url){
        this.name = name;
        this.length = length;
        this.url = url;
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

}
