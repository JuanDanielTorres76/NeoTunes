package model;

public abstract class Consumer extends User implements Functions{

    //atributes 

    protected int genrePlays[];
    protected int catergoryPlays[];

    //methods
    public Consumer(String name, String nickName, String date, String id, String url){
        super(name, nickName, date, id, url);
        genrePlays = new int[4];
        catergoryPlays = new int[4];
        fillCounters();
    }

    public abstract int countPlayedAudio(String playlistName, String audioName);

    public void fillCounters(){
        for(int i = 0; i<genrePlays.length; i++){
            genrePlays[i] = 0;
            catergoryPlays[i] = 0;
        }
    }

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
