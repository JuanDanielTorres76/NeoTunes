package model;

public abstract class Consumer extends User implements Functions{

    //atributes 

    protected int genrePlays[];
    protected int catergoryPlays[];

    //methods
    /**
     *  Metodo construtor para la calse CONUSMER
     * <b>pre: </b> los atributos deben ser declarados previamente
     * <b>post: </b> Se instancia un objeto tipo CONSUMER
     * @param name nombre digitado por el uasuario
     * @param nickName nickName digitado por el usuario
     * @param date date se asigna en el momento de creacion del objeto CONSUMER 
     * @param id id digitado por el usuario
     * @param url url digitado por el usuario
     */
    public Consumer(String name, String nickName, String date, String id, String url){
        super(name, nickName, date, id, url);
        genrePlays = new int[4];
        catergoryPlays = new int[4];
        fillCounters();
    }

    public abstract int countPlayedAudio(String playlistName, String audioName);

    /**
     * Metodo para llenar los contadores de las reproducciones
     * <b>pre: </b> el metodo se ejecuta en el momento que se crea un usuario
     * <b>post: </b> Se instancia un objeto tipo CONSUMER
     */
    public void fillCounters(){
        for(int i = 0; i<genrePlays.length; i++){
            genrePlays[i] = 0;
            catergoryPlays[i] = 0;
        }
    }

    /**
     * Metodo retornar el tipo de genero mas escucahdo por el usuario
     * <b>pre: </b> deben haberse ejecutado el metodo de simulacion de usuario para que previamente se muestre un valor por pantalla
     * <b>post: </b> se muetsra el genero mas escuchado
     * @return se retorna el genero mas escuchado
     */
    public String mostHearedGenreUsr(){
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
     * Metodo retornar el valor de repreducciones del genero mas escucahdo
     * <b>pre: </b> deben haberse ejecutado el metodo de simulacion de usuario para que previamente se muestre un valor por pantalla
     * <b>post: </b> se muetsra el numero de reproducciones del genero mas escuchado
     * @return numero de reproducciones del genero mas escuchado
     */
    public int mostHearedGenreValueCon(){
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
     * Metodo retornar el tipo de categoria mas escucahdo por el usuario
     * <b>pre: </b> deben haberse ejecutado el metodo de simulacion de usuario para que previamente se muestre un valor por pantalla
     * <b>post: </b> se muetsra la categoria mas escuchado
     * @return se retorna la categoria mas escuchada
     */
    public String mostHearedCategoryUsr(){
        String alert = "";
        if(catergoryPlays[0] > catergoryPlays[1] && catergoryPlays[0] > catergoryPlays[2] && catergoryPlays[0] > catergoryPlays[3]){
            alert = "POLITICS";
        } else if(catergoryPlays[1] > catergoryPlays[0] && catergoryPlays[1] > catergoryPlays[2] && catergoryPlays[1] > catergoryPlays[3]){
            alert = "ENTERNTAINMENT";
        } else if(catergoryPlays[2] > catergoryPlays[0] && catergoryPlays[2] > catergoryPlays[1] && catergoryPlays[2] > catergoryPlays[3]){
            alert = "VIDEOGAMES";
        }else if(catergoryPlays[3] > catergoryPlays[0] && catergoryPlays[3] > catergoryPlays[1] && catergoryPlays[3] > catergoryPlays[2]){
            alert = "FASHION";
        }
        return alert;
    }

    /**
     * Metodo retornar el valor de repreducciones de la categoria mas escucahdo
     * <b>pre: </b> deben haberse ejecutado el metodo de simulacion de usuario para que previamente se muestre un valor por pantalla
     * <b>post: </b> se muetsra el numero de reproducciones de la categria mas escuchada
     * @return numero de reproducciones de la categoria mas escuchada
     */
    public int mostHearedCategoryValueCon(){
        int value = 0;
        if(catergoryPlays[0] > catergoryPlays[1] && catergoryPlays[0] > catergoryPlays[2] && catergoryPlays[0] > catergoryPlays[3]){
            value = catergoryPlays[0];
        } else if(catergoryPlays[1] > catergoryPlays[0] && catergoryPlays[1] > catergoryPlays[2] && catergoryPlays[1] > catergoryPlays[3]){
            value = catergoryPlays[1];
        } else if(catergoryPlays[2] > catergoryPlays[0] && catergoryPlays[2] > catergoryPlays[1] && catergoryPlays[2] > catergoryPlays[3]){
            value = catergoryPlays[2];
        }else if(catergoryPlays[3] > catergoryPlays[0] && catergoryPlays[3] > catergoryPlays[1] && catergoryPlays[3] > catergoryPlays[2]){
            value = catergoryPlays[3];
        }
        return value;
    }
}
