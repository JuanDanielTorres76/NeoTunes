package model;

public abstract class User {

    //atributes
    private String name;
    private String nickName; 
    private String id;
    private String url; 
    private int genrePlays; 
    private int catergoryPlays;

    public User(String name, String nickName, String date, String id, String url){
        this.name = name; 
        this.nickName = nickName;
        this.id = id;
        this.url = url;
        catergoryPlays = 0;
        genrePlays = 0;

    }

    public String toString(){ // añadir metodo abstracto
        String message = name + " " + nickName + " " + id + " " +  url;
        return message;
    }
    
    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getGenrePlays() {
        return genrePlays;
    }
    
    public void setGenrePlays(int genrePlays) {
        this.genrePlays = genrePlays;
    }
    
    public int getCatergoryPlays() {
        return catergoryPlays;
    }
    
    public void setCatergoryPlays(int catergoryPlays) {
        this.catergoryPlays = catergoryPlays;
    }


    
    
}
