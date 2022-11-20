package model;

import java.util.ArrayList;

public class Store {
    
    //atribute 
    private String name; 
    protected ArrayList<Song> bougthSongs;
    private int rockTransactions;
    private int popTransactions;
    private int trapTransactions;
    private int houseTransactions;




    /**
     *  Metodo constructor de la clase STORE 
     * <b>pre: </b> atributos declarados previamente 
     * <b>post: </b> creacion del objeto
     * @param name nombre asigando por defecto
     */
    public Store(String name){
        this.name = name;
        bougthSongs = new ArrayList<Song>();
        rockTransactions = 0;
        popTransactions = 0;
        trapTransactions = 0;
        houseTransactions = 0;
    }

    /**
     *  Metodo añadir una transaccion 
     * <b>pre: </b> obajeto STORE previamente insatnciado
     * <b>post: </b> se añade una transaccion 
     * @param obj se obtiene un objeto tipo cancion
     * @param validation se valida la transaccion
     * @return se retorna el estado del metodo
     */
    public String addTransaction(Song obj, boolean validation){
        String alert = "";
        int increase = 0;
        if(validation == true){
            bougthSongs.add(obj);
            Genre kind = obj.getKindGenre(); 
            if(kind == Genre.ROCK){
                increase = getRockTransactions();
                increase++;
                setRockTransactions(increase);
            } else if(kind == Genre.POP){
                increase = getPopTransactions();
                increase++;
                setPopTransactions(increase);
            } else if(kind == Genre.TRAP){
                increase = getTrapTransactions();
                increase++;
                setTrapTransactions(increase);
            } else if(kind == Genre.HOUSE){
                increase = getHouseTransactions();
                increase++;
                setHouseTransactions(increase);
            }
            alert = "Sucesfull trasnsaction";
        } else{
            alert = "The song is not in the library of the artist";
        }
        
        return alert;
    }

    /**
     *  Metodo para mostrar el genero mas vendido 
     * <b>pre: </b> metodo de simulacion de compra de cancion previamente instanciado
     * <b>post: </b> se muestra el genero mas vendido
     * @return se retorna el genero mas vendido
     */
    public String mostSelledGenre(){
        String alert = "", part = "";
        int bigger = 0, countR = 0, countP = 0, countT = 0, countH = 0;
        double price = 0; 
        if(bougthSongs.size() == 0){
            alert = "There havent been any transaction yet";
        } else{
            for(int i = 0; i<bougthSongs.size(); i++){
                price += bougthSongs.get(i).getPrice();
                if(bougthSongs.get(i).getKindGenre() == Genre.ROCK){
                    countR++;
                    part = "The most selled Genre is " + bougthSongs.get(i).getKindGenre();
                } else if(bougthSongs.get(i).getKindGenre() == Genre.POP){
                    countP++;
                } else if(bougthSongs.get(i).getKindGenre() == Genre.TRAP){
                    countT++;
                } else if(bougthSongs.get(i).getKindGenre() == Genre.HOUSE){
                    countH++;
                }
            }  
            if(countR > countP && countR> countT && countR>countH){
                bigger = countR; 
                alert = part + " with " + bigger + " number of sells and $" + price + " dollars of sales" ;
            } else if(countP > countR && countP> countT && countP>countH){
                bigger = countP; 
                alert = part + " with " + bigger + " number of sells and $" + price + " dollars of sales" ;

            } else if(countH > countR && countH> countT && countH>countP){
                bigger = countH; 
                alert = part + " with " + bigger + " number of sells and $" + price + " dollars of sales" ;

            }else if(countT > countR && countT> countH && countT>countP){
                bigger = countT; 
                alert = part + " with " + bigger + " number of sells and $" + price + " dollars of sales" ;

            }
        }
        return alert;
       
    }

    /**
     *  Metodo para mostrar la informacion del genero escogido, como sus ventas y precio de las mismas 
     * <b>pre: </b> metodo de simulacion de compra de la canciones previamente instanciado
     * <b>post: </b> se muestra por pantalla la informacion del genero escogido
     * @param option opcion deigitada por el usuario
     * @return se retorna por pantalla la informacion escogida
     */
    public String infoGenre(int option ){
        int countR = 0, countP = 0, countT = 0, countH = 0;
        String alert = "";
        if(bougthSongs.size() == 0){
            alert = "There havent been any transaction yet";
        } else{
            for(int i = 0; i<bougthSongs.size(); i++){
                if(bougthSongs.get(i).getKindGenre() == Genre.ROCK){
                    countR++;
                } else if(bougthSongs.get(i).getKindGenre() == Genre.POP){
                    countP++;
                } else if(bougthSongs.get(i).getKindGenre() == Genre.TRAP){
                    countT++;
                } else if(bougthSongs.get(i).getKindGenre() == Genre.HOUSE){
                    countH++;
                }
            }
            if(option ==1){
                alert = "The most heared genre is ROCK with " + countR + " number of sales"; 
            } else if( option == 2){
                alert = "The most heared genre is POP with " + countP + " number of sales"; 
            } else if( option == 3){
                alert = "The most heared genre is TRAP with " + countT + " number of sales"; 
            } else if( option == 4){
                alert = "The most heared genre is HOUSE with " + countH + " number of sales"; 
            } else {
                alert = "Invalid option";
            }
        }
        
        return alert;
    }

   /**
    *  Metodo para mostrar la informacion de la cancion mas vendida
     * <b>pre: </b> metodo de simulacion de cancion previamente ejecutado 
     * <b>post: </b> se muetsra el estado del metodo 
     * @return se retorna la informacion de la cancion mas vendida 
     */
     public String mostSelledSong(){
        String alert = "", name = "", mName = "";
        int mostSelled = 0, counter = 0;
        double price = 0, fPrice = 0;
        for(int i = 0 ; i<bougthSongs.size(); i++){
            name = bougthSongs.get(i).getName();
            for(int b = 0; b<bougthSongs.size(); b++){
                if(bougthSongs.get(b).getName().equalsIgnoreCase(name)){
                    counter++; 
                    price += bougthSongs.get(b).getPrice();
                    if(counter>mostSelled){
                        mostSelled = counter;
                        mName = name;
                        fPrice = price;
                    }
                }
            }
        }
        alert = "The most selled song in the platform is "+ mName + " with " + mostSelled + " sales and $" + fPrice + " of earned dollars";
        return alert;
    }



    /**
     *  Metodo get para el atributo name
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo
     * @return se retorna el atributo
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**  
     * Metodo get para el atributo RockTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo
     * @return se retorna el atributo 
     */
    public int getRockTransactions() {
        return rockTransactions;
    }

    /**
     * Metodo set para el atributo RockTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo con su nuevo valor
     * @param rockTransactions valor al que cambiara el atributo 
     */
    public void setRockTransactions(int rockTransactions) {
        this.rockTransactions = rockTransactions;
    }

    /**
     * Metodo get para el atributo PopTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo
     * @return se retorna el atributo 
     */
    public int getPopTransactions() {
        return popTransactions;
    }

    /**
     * * Metodo set para el atributo PopTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo con su nuevo valor
     * @param popTransactions valor al que cambiara el atributo
     */
    public void setPopTransactions(int popTransactions) {
        this.popTransactions = popTransactions;
    }

    /**
     * Metodo get para el atributo TrapTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo
     * @return se retorna el atributo
     */
    public int getTrapTransactions() {
        return trapTransactions;
    }

    /**
     * * Metodo set para el atributo TrapTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo con su nuevo valor
     * @param trapkTransactions valor al que cambiara el atributo 
     */
    public void setTrapTransactions(int trapkTransactions) {
        this.trapTransactions = trapkTransactions;
    }

    /**
     * Metodo get para el atributo HouseTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo
     * @return se retorna el valor
     */
    public int getHouseTransactions() {
        return houseTransactions;
    }

    /**
     * * Metodo set para el atributo HouseTransactions
     * <b>pre: </b> atributo previamente declarado
     * <b>post: </b> se retorna el atributo con su nuevo valor
     * @param houseTransactions valor al que cambiara el atributo
     */
    public void setHouseTransactions(int houseTransactions) {
        this.houseTransactions = houseTransactions;
    }

}
