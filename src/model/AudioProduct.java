package model;

public abstract class AudioProduct {
    
    //Atributes
    private String name; 
    private double length; 
    private String url;
    private int timesPlayed;


    //methods
    /**
     * Metodo constructor para la clase AUDIOPORDUCT
     * <b>pre: </b> Deben haber previamente instanciados objetos tipo PLAYLIST
     * <b>post: </b> Se instancia el obejto tipo AUDIPRODUCT
     * @param name nombre digitado pro el usuario 
     * @param length logitud digitada por el usuario 
     * @param url url digitada por el usuario
     */
    public AudioProduct(String name, double length, String url){
        this.name = name;
        this.length = length;
        this.url = url;
        timesPlayed = 0;
    }
    
    /**
     *  Metodo get para el atributo Name
     * <b>pre: </b> los atributos deben ser declarados previamente
     * <b>post: </b> Se retorna el atributo name
     * @return atributo name
     */
    public String getName() {
        return name;
    }

    /**
     *  Metodo get para el atributo length
     * <b>pre: </b> los atributos deben ser declarados previamente
     * <b>post: </b> Se retorna el atributo length
     * @return atributo length
     */
    public double getLength() {
        return length;
    }

    
    /**
     *  Metodo get para el atributo irl
     * <b>pre: </b> los atributos deben ser declarados previamente
     * <b>post: </b> Se retorna el atributo url
     * @return atributo length
     */
    public String getUrl() {
        return url;
    }

    /**
     *  Metodo get para el atributo timesPlayed
     * <b>pre: </b> los atributos deben ser declarados previamente
     * <b>post: </b> Se retorna el atributo timesPlayed
     * @return atributo timesPlayed
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     *  Metodo set para el atributo timesPlayed
     * <b>pre: </b> los atributos deben ser declarados previamente
     * <b>post: </b> Se cambia el atributo timesPlayed
     * @param timesPlayed nuevo valor al que se cambiara timesPlayed
     */
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

}
