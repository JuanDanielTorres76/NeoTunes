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




    public Store(String name){
        this.name = name;
        bougthSongs = new ArrayList<Song>();
        rockTransactions = 0;
        popTransactions = 0;
        trapTransactions = 0;
        houseTransactions = 0;
    }

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRockTransactions() {
        return rockTransactions;
    }

    public void setRockTransactions(int rockTransactions) {
        this.rockTransactions = rockTransactions;
    }

    public int getPopTransactions() {
        return popTransactions;
    }

    public void setPopTransactions(int popTransactions) {
        this.popTransactions = popTransactions;
    }

    public int getTrapTransactions() {
        return trapTransactions;
    }

    public void setTrapTransactions(int trapkTransactions) {
        this.trapTransactions = trapkTransactions;
    }

    public int getHouseTransactions() {
        return houseTransactions;
    }

    public void setHouseTransactions(int houseTransactions) {
        this.houseTransactions = houseTransactions;
    }

}
