package model;

public abstract class User {

    //atributes
    private String name;
    private String nickName; 
    private String id;
    private String url; 
    private int genrePlays; 
    private int catergoryPlays;

    /**
     * Metodo cosntructor para la calse USER
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto de tipo USER
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha otrogada al momento en el que se intancia el objeto
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     */
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
    
    /**
     * Metodo get para el atributo name
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo 
     * @return se retorna el atributo 
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo get para el atributo nickname
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo 
     * @return se retorna el atributo 
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Metodo get para el atributo id
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo 
     * @return se retorna el atributo 
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo get para el atributo url
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo 
     * @return se retorna el atributo
     */
    public String getUrl() {
        return url;
    }

    /**
     * Metodo get para el atributo genrePlays
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo 
     * @return se retorna el atributo
     */
    public int getGenrePlays() {
        return genrePlays;
    }
    
    /**
     * Metodo set para el atributo genrePlays
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo con su nuevo valor 
     * @param genrePlays valoe al que cambiara el atributo
     */
    public void setGenrePlays(int genrePlays) {
        this.genrePlays = genrePlays;
    }
    
    /**
     * Metodo get para el atributo categoryPlays
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo 
     * @return se retorna el atributo
     */
    public int getCatergoryPlays() {
        return catergoryPlays;
    }
    
    /**
     * Metodo set para el atributo categoryPlays
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo con su nuevo valor 
     * @param catergoryPlays valor al que cambiara el atributo
     */
    public void setCatergoryPlays(int catergoryPlays) {
        this.catergoryPlays = catergoryPlays;
    }


    
    
}
