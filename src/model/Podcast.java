package model;

public class Podcast extends AudioProduct {
    
    //atributes 
    private String description; 
    private Category kind;

    //methods
    
    public Podcast(String name, double length, String url, String description, Category kind){
        super(name, length, url);
        this.description = description;
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public Category getKind() {
        return kind;
    }


}
