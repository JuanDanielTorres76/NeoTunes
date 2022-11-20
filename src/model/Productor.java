package model;

public abstract class Productor extends User implements Functions{

    //Atributes 
    private int year;
    private int timesPlayed;
    protected int genrePlays[];
    protected int catergoryPlays[];
    

    //methods

    /**
     * Metodo constructor para la clase PRODUCTOR
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se instancia un objeto tipo PRODUCTOR
     * @param name nombre digitado por el usuario
     * @param nickName nickname digitado por el usuario
     * @param date fecha asignada en el momento de creacion del usuario
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     * @param year año digitado por el usuario
     */
    public Productor(String name, String nickName, String date, String id, String url, int year){
        super(name, nickName, date, id, url);
        this.year = year;
        timesPlayed = 0;
        genrePlays = new int[4];
        catergoryPlays = new int[4];
        fillCounters();
    }

    /**
     * Metodo para declarar los contadores del usaurio
     * <b>pre: </b> creacion del objeto tipo PRODUCTOR
     * <b>post: </b> se decalran los contadores
     */
    public void fillCounters(){
        for(int i = 0; i<genrePlays.length; i++){
            genrePlays[i] = 0;
            catergoryPlays[i] = 0;
        }
    }

    /**
     * Metodo para mostrar el genero mas escuchado por el usaurio
     * <b>pre: </b> previamente se debio instanciar el metodo SIMULATEAUDIO
     * <b>post: </b> se muestra pro pantalla el genero mas escuchado 
     * @return se retorna el genero mas escuchado
     */
    public String mostHearedGenrePro(){
        String alert = "";
        if(genrePlays[0] > genrePlays[1] && genrePlays[0] > genrePlays[2] && genrePlays[0] > genrePlays[3]){
            alert = "ROCK";
        } else if(genrePlays[1] > genrePlays[0] && genrePlays[1] > genrePlays[2] && genrePlays[1] > genrePlays[3]){
            alert = "POP";
        } else if(genrePlays[2] > genrePlays[0] && genrePlays[2] > genrePlays[1] && genrePlays[2] > genrePlays[3]){
            alert = "TRAP";
        }else if(genrePlays[3] > genrePlays[0] && genrePlays[3] > genrePlays[1] && genrePlays[3] > genrePlays[2]){
            alert = "HOUSE";
        }
        return alert;
    }

    /**
     * Metodo para mostar la cantidad de veces que se escucho el genero mas escuchado
     * <b>pre: </b> metodo SIMULATEAUDIO previamente ejecutado
     * <b>post: </b> se muestra las veces que se reprodujo el genero mas escuchado
     * @return numero de veces que se escucho el genero 
     */
    public int mostHearedGenreValuePro(){
        int value = 0;
        if(genrePlays[0] > genrePlays[1] && genrePlays[0] > genrePlays[2] && genrePlays[0] > genrePlays[3]){
            value = genrePlays[0];
        } else if(genrePlays[1] > genrePlays[0] && genrePlays[1] > genrePlays[2] && genrePlays[1] > genrePlays[3]){
            value = genrePlays[1];
        } else if(genrePlays[2] > genrePlays[0] && genrePlays[2] > genrePlays[1] && genrePlays[2] > genrePlays[3]){
            value = genrePlays[2];
        }else if(genrePlays[3] > genrePlays[0] && genrePlays[3] > genrePlays[1] && genrePlays[3] > genrePlays[2]){
            value = genrePlays[3];
        }
        return value;
    }

    /**
     * Metodo abstracto para añadir audios a clases hijas
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se añade un audio a la libreria del usuario
     * @param name nombre digitado por el usuario
     * @param length duracion digitado por el usuario
     * @param url url digitado por el usuario
     * @param album album digitado por el usuario
     * @param price precio digitado por el usuario
     * @param kindGenre genero digitado por el usuario
     * @param description descripcion digitado por el usuario
     * @param kind categoria digitado por el usuario
     * @return estado del metodo
     */
    public abstract String addAudio(String name, double length, String url, String album, double price, Genre kindGenre, String description, Category kind);

    /**
     * Metodo get para el atributo year 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se muestra el atributo
     * @return se retorna el atributo en un String
     */
    public int getYear() {
        return year;
    }

    /**
     * Metodo get para el atributo timesplayed 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se muestra el atributo
     * @return se retorna el atriubuto
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * Metodo ste para el atributo timesPlayed 
     * <b>pre: </b> atributos previamente declarados
     * <b>post: </b> se cambia el valor del atributo
     * @param timesPlayed nuevo valor por el que se cambiara al atributo
     */
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }


    
}
