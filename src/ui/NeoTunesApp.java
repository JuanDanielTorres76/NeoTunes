package ui;
import model.*;
import java.util.*;

import model.NeoTunesManager;

public class NeoTunesApp {
    public static Scanner read = new Scanner(System.in);

    //atributes 
    private static NeoTunesApp ntApp; 

    //relations
    private NeoTunesManager ntManager; 

    public NeoTunesApp(String name, String id){
        ntManager = new NeoTunesManager(name, id);
    }

    public static void main(String[] args) {
        
    }

    public static void addManager(){    
        String name = "NeoTunes";
        String id = "123456789";
        ntApp = new NeoTunesApp(name, id);

    }
    
    public static void menu(){
        boolean continuar = true; 
        while(continuar){
            System.out.println("Choose one of the next options");
            System.out.println("1 - to initialize the menu of a productor");
            System.out.println("2 - to initialize the menu of a consumer");
            System.out.println("3 - to end the program");
            int option = read.nextInt();
            read.nextLine();
            switch(option){
                case 1: ntApp.productorMenu();
                    break;
                case 2: ntApp.consumerMenu();
                    break;
                case 3: System.out.println(" The program has ended");
                    continuar = false;
                    break;
                default: System.out.println("ERROR. invalid option");
                    break;
            }
        }
    }

    public void productorMenu(){
        boolean continar1 = true; 
        while(continar1){
            System.out.println("Choose one of the next options");
            System.out.println(" 1 - Register a productor");
            System.out.println(" 2 - Register a Song");
            System.out.println(" 3 - Register a Podcast");
            System.out.println(" 4 - Return to the main menu");
            int option2 = read.nextInt();
            read.nextLine();
            switch(option2){
                case 1: ntApp.registerProductor();
                    break;
                case 2: ntApp.registerSong();
                    break;
                case 3: ntApp.registerPodcast();
                    break; 
                case 4: System.out.println("Back to the menu");
                continar1 = false; 
                    break; 
                default: System.out.println(" Invalid option");
                    break;
                
            }
        }
    }

    public void consumerMenu(){
        boolean continuar2 = true;
        while(continuar2){
            System.out.println("Choose one of the next options");
            System.out.println(" 1 - Register a Consumer");
            System.out.println(" 2 - Create a Playlist");
            System.out.println(" 3 - Edit a playlist");
            System.out.println(" 4 - Return to the main menu");
            int option3 = read.nextInt();
            read.nextLine();
            switch(option3){
                case 1: ntApp.registerConsumer();
                    break;
                case 2: ntApp.createPlaylist();
                    break;
                case 3: ntApp.editPlaylist();
                    break;
                case 4: System.out.println("Back to the menu");
                continuar2 = false; 
                    break;
                default:
                    break;
            }

        }
    }

    public void registerProductor(){
        System.out.println("Type the name of the Prodcutor ");
        String name = read.nextLine(); 
        System.out.println("Type the nickname of the Productor");
        String nickName = read.nextLine();
        System.out.println("Type the id of the Productor");
        String id = read.nextLine();
        System.out.println("Type the url of the Productor");
        String url = read.nextLine();
        // se añade la fecha en la que se regitro el usuario} 
        String date = "El usuario se registro a: " + new Date();
        System.out.println("Type the year that the user started making its productions");
        int year = read.nextInt(); 
        while(year<1900 && year>2022){
            System.out.println("ERROR. Type a valid year");
            year = read.nextInt();
        }
        System.out.println("Choose one of the next options");
        System.out.println(" 1 - Artist  ( Song creator ) ");
        System.out.println(" 2 - Content Creator ( Podcats creator ) ");
        int option = read.nextInt();
        read.nextLine();
        while(option != 1 && option != 2){
            System.out.println(" Type a valid option");
            option = read.nextInt();
            read.nextLine();
        }
        if(option == 1){
            System.out.println("Type the country of the artists");
            String country = read.nextLine();
            String alert = ntManager.addProductor(name, nickName, date, id, url, year, country);
            System.out.println(alert);
        }
        else if(option == 2){
           String alert = ntManager.addProductor(name, nickName, date, id, url, year);
           System.out.println(alert);
        }

    }

    public void registerConsumer(){
        System.out.println("type the name of the consumer");
        String name = read.nextLine(); 
        System.out.println("Type the nickname of the consumer");
        String nickName = read.nextLine();
        System.out.println("Type the id of the consumer");
        String id = read.nextLine();
        System.out.println("Type the url of the consumer");
        String url = read.nextLine();
        String date = "El usuario se registro a: " + new Date();
        System.out.println("Choose one of the next options");
        System.out.println(" 1 - Standard ");
        System.out.println(" 2 -  Premium ");
        int option = read.nextInt();
        read.nextLine();
        while(option != 1 && option != 2){
            System.out.println(" Type a valid option");
            option = read.nextInt();
            read.nextLine();
        }
        if(option == 1){
            int numOfAds = 3;
            String alert = ntManager.addConsumer(name, nickName, date, id, url, numOfAds);
            System.out.println(alert);
        }
        else if(option == 2){
            String label = "Premium";
            String alert = ntManager.addConsumer(name, nickName, date, id, url, label);
            System.out.println(alert);
        }

    }

    public void registerSong(){
        System.out.println("Type the name of it");
        String name = read.nextLine();
        System.out.println("Type the length of it");
        double length = read.nextDouble();
        System.out.println("Type the url of the audio");
        String url = read.nextLine();
        System.out.println(" Type the name of the album");
        String album = read.nextLine();
        System.out.println("Type the price of the song, rember ith maximus its $5.00 dollars");
        double price = read.nextDouble();
        while(price<0 && price>5){
            System.out.println("The maximum price its $5.00 dollars, type a valid option");
            price = read.nextDouble();
        }
        System.out.println("Choose one of the next genres");
        System.out.println(" 1 - POP");
        System.out.println(" 2 - ROCK");
        System.out.println(" 3 - TRAP");
        System.out.println(" 4 - HOUSE");
        int genreOption =read.nextInt();
        read.nextLine();
        Genre kindGenre;
        switch(genreOption){
            case 1: kindGenre = Genre.POP;
                break;
            case 2:  kindGenre = Genre.ROCK;
                break;
            case 3: kindGenre = Genre.TRAP;
                break;
            case 4: kindGenre = Genre.HOUSE;
                break;
            default: kindGenre = Genre.NONE;
                break;
            }
        System.out.println("Type the name or the nickname of the artist which you want to add this song");
        String aName = read.nextLine();
        String alert = ntManager.addSong(name, length, url, album, price, kindGenre, aName);
        System.out.println(alert);

    }

    public void registerPodcast(){
        System.out.println("Type the name of it");
        String name = read.nextLine();
        System.out.println("Type the length of it");
        double length = read.nextDouble();
        System.out.println("Type the url of the audio");
        String url = read.nextLine();
        System.out.println("Write down the description of the podcast");
        String description = read.nextLine();
        System.out.println("Choose one of the next categories");
        System.out.println(" 1 - POLITICS");
        System.out.println(" 2 - ENTERNTAINMENT");
        System.out.println(" 3 - VIDEOGAMES");
        System.out.println(" 4 - FASHION");
        int categoryOption = read.nextInt();
        read.nextLine();
        Category kind;
        switch(categoryOption){
            case 1: kind = Category.POLITICS;
                break;
            case 2:  kind = Category.ENTERNTAINMENT;
                break;
            case 3: kind = Category.VIDEOGAMES;
                break;
            case 4: kind = Category.FASHION;
                break;
            default: kind = Category.NONE;
                break;
        }
        System.out.println("Type the name or the nickname of the content creator which you want to add this podcats");
        String ccName= read.nextLine();
        String alert = ntManager.addPodcast(name, length, url, description, kind, ccName);
        System.out.println(alert);
    }

    public void createPlaylist(){
        System.out.println(" Name the playlist");
        String name = read.nextLine();
        System.out.println("Type the nickname of the User which will add this playlist");
        String nickname = read.nextLine();
        String alert = ntManager.addPlaylist(name, nickname);
        System.out.println(alert);
    }

    public void editPlaylist(){
        System.out.println("Here are the registered users");
        ntManager.showRegisteredUsers();
        System.out.println("Type the nick name of the user which you want to use");
        String uName = read.nextLine();
        boolean uValidation = ntManager.validateConsumer(uName);
        while(uValidation == false){
            System.out.println("This user hasnt been registered yet");
            System.out.println("Here are the registered users");
            ntManager.showRegisteredUsers();
            uName = read.nextLine();
            uValidation = ntManager.validateConsumer(uName);
        }
        boolean continar = true;
        while(continar){
            System.out.println("Digita una de las siguientes opciones ");
            System.out.println("1 - Remove an item for the playlist");
            System.out.println("2 - Switch positions of songs ");
            System.out.println("3 - Get back to the previous menu");
            int option = read.nextInt();
            read.nextLine();
            switch(option){
                case 1:
                System.out.println("Type the name of the playlist which will be edited");
                System.out.println("Here are the name of the playlists");
                ntManager.showUserPlaylists(uName);
                String pName = read.nextLine(); 
                System.out.println("Type the name of the song which will be removed ");
                System.out.println("Here are the name of the songs");
                ntManager.showAudioOfPlaylist(uName, pName);
                String sName = read.nextLine();
                String alert = ntManager.editPlaylist(uName, pName, sName);
                System.out.println(alert);
                    break;
                case 2:System.out.println(" Type the name of the playlist which will be edited");
                System.out.println("Here are the name of the playlists");
                ntManager.showUserPlaylists(uName);
                pName = read.nextLine();
                System.out.println("Here are the name of the songs");
                ntManager.showAudioOfPlaylist(uName, pName);
                System.out.println("Type the name of the first song which will be switched");
                String fSong = read.nextLine();
                System.out.println("Here are the name of the songs again");
                ntManager.showAudioOfPlaylist(uName, pName);
                System.out.println("Type the name of the seocnd song which will be switched");
                String sSong = read.nextLine();
                alert = ntManager.switchPositions(uName, pName, fSong, sSong);
                System.out.println(alert);
                    break;
                case 3:
                continar = false;
                    break;
                default:
                System.out.println("Invalid option");
                    break;    
            }
        }
        

    }

     
}
