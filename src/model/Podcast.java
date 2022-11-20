package model;

public class Podcast extends AudioProduct {
    
    //atributes 
    private String description; 
    private Category kind;

    //methods
    
    /** 
     * Metodo constructro de la clase tipo PODCAST
     * <b>pre: </b> debe existir una clase previamente instanciada que pueda almacenar el objeto
     * <b>post: </b> se instancia un objeto tipo PODCAST
     * @param name nombre digitado por el usuario
     * @param length duracion digitada por el usuario
     * @param url url digitada por el usuario
     * @param description descripcion digitada por el usuario 
     * @param kind tipo de categoria elegida por el usuario 
     */
    public Podcast(String name, double length, String url, String description, Category kind){
        super(name, length, url);
        this.description = description;
        this.kind = kind;
    }

    /**
     * Metodo get para el atributo DESCRIPTION
     * <b>pre: </b> debe existir una clase previamente instanciada
     * <b>post: </b> se retorna el atributo
     * @return se retorna el atributo
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo get para el tipo de categoria del objeto
     * <b>pre: </b> debe existir una clase previamente instanciada que pueda almacenar el objeto
     * <b>post: </b> se retorna el tipo de catgoria del objeto 
     * @return tipo de categoria 
     */
    public Category getKind() {
        return kind;
    }


}
