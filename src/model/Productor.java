package model;

public abstract class Productor extends User implements Functions{

    //Atributes 
    private int year;
    private int timesPlayed;
    protected int genrePlays[];
    protected int catergoryPlays[];
    

    //methods

    public Productor(String name, String nickName, String date, String id, String url, int year){
        super(name, nickName, date, id, url);
        this.year = year;
        timesPlayed = 0;
        genrePlays = new int[4];
        catergoryPlays = new int[4];
        fillCounters();
    }

    public void fillCounters(){
        for(int i = 0; i<genrePlays.length; i++){
            genrePlays[i] = 0;
            catergoryPlays[i] = 0;
        }
    }

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

    public abstract String addAudio(String name, double length, String url, String album, double price, Genre kindGenre, String description, Category kind);

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }


    
}
