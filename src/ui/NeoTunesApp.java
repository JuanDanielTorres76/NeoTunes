package ui;
import model.*;
import java.util.*;

import model.NeoTunesManager;

public class NeoTunesApp {
    public static Scanner read = new Scanner(System.in);

    //atributes 
    private static NeoTunesApp ntApp;

    //methods
    private NeoTunesManager ntManager; 

    public NeoTunesApp(String name, String id){
        ntManager = new NeoTunesManager(name, id);
    }

    public static void main(String[] args) {
        addManager();
        menu();
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
            System.out.println(" 4 - Add song to playlist");
            System.out.println(" 5 - Share Playlist");
            System.out.println(" 6 - Simulate playback of an audio");
            System.out.println(" 7 - Buy a song");
            System.out.println(" 8 - Return to the main menu");
            int option3 = read.nextInt();
            read.nextLine();
            switch(option3){
                case 1: ntApp.registerConsumer();
                    break;
                case 2: ntApp.createPlaylist();
                    break;
                case 3: ntApp.editPlaylist();
                    break;
                case 4: ntApp.addAudioToPlaylist();
                    break;
                case 5: ntApp.sharePlaylist();
                    break;
                case 6: ntApp.simulatePlaybackOfAudio();
                    break;
                case 7: ntApp.buySong();
                    break;
                case 8: System.out.println("Back to the menu");
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

    public void addAudioToPlaylist(){
        System.out.println("Type the name of the user which will add this song");
        System.out.println("Here are the users");
        ntManager.showRegisteredUsers();
        String uName = read.nextLine();
        System.out.println("Type the name of the playlist which will be added");
        System.out.println("Here are the Playlist");
        ntManager.showUserPlaylists(uName);
        String playlistName = read.nextLine();
        System.out.println("Type the name or nickname of the Productor");
        System.out.println("Here are the prodcuctors");
        ntManager.showProductors();
        String pName = read.nextLine();
        String proName = ntManager.showProductorAudio(pName);
        System.out.println("Here are the audios of the " + proName);
        System.out.println("Type the name of the audio you want to add ");
        String aName = read.nextLine();
        String alert = ntManager.addAudioToPlaylist(uName, playlistName, pName, aName);
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
            System.out.println("Choose one of the next options ");
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

    public void sharePlaylist(){
        System.out.println("Type the name of the user which will share this song");
        System.out.println("Here are the users");
        ntManager.showRegisteredUsers(); 
        String uName = read.nextLine();
        System.out.println("Type the name of the playlist which will be shared");
        System.out.println("Here are the Playlist");
        ntManager.showUserPlaylists(uName);
        String playlistName = read.nextLine();
        String alert = ntManager.sharePlaylist(uName, playlistName);
        System.out.println(alert);

    }

    public void simulatePlaybackOfAudio(){
        boolean continuar = true;
        while(continuar){
            System.out.println("Choose one fo the next options");
            System.out.println("1 - To simulate the playback of an audio from an Productor");
            System.out.println("2 - To imulate the playback of an audio from an Consumer ");
            System.out.println("3- To return to the previous menu ");
            int option = read.nextInt();
            switch(option){
                case 1:
                    System.out.println("Type the name of the productor which will simulate the playback of the song");
                    System.out.println("Here are the productors");
                    ntManager.showProductors();
                    String pName = read.nextLine();
                    System.out.println("Type the name of the song which will be simulated");
                    String proName = ntManager.showProductorAudio(pName);
                    System.out.println("Here are the audios of the " + proName);
                    System.out.println("Type the name of the audio you want to simulate ");
                    String aName = read.nextLine();
                    String alert = ntManager.SimulateAudioPr(pName, aName);
                    System.out.println(alert);
                    break;
                case 2:
                    System.out.println("Type the name of the consumer which will simulate the playback of the song");
                    System.out.println("Here are the consumers");
                    ntManager.showRegisteredUsers();
                    String cName = read.nextLine();
                    System.out.println("Type the name ofthe playlist of the consumer");
                    System.out.println("Here are the name of the playlists");
                    ntManager.showUserPlaylists(cName);
                    pName = read.nextLine();
                    System.out.println("Here are the name of the songs");
                    ntManager.showAudioOfPlaylist(cName, pName);
                    System.out.println("Type the name of the song which will be played");
                    String sName = read.nextLine();
                    String alert1 = ntManager.simulateAudioCm(cName, pName, sName);
                    System.out.println(alert1); 
                    break;
                case 3: System.out.println("Heading to the previous menu ");
                    continuar = false;
                    break;
                default: System.out.println("Invalid option");
                    break;
        }

        }
        
        


    }

    public void buySong(){
        System.out.println("Type the name of the artist which you want to buy the song of");
        System.out.println("Here are the artists");
        ntManager.showArtists();
        String aName = read.nextLine();
        System.out.println("Type the name of the song which you want to buy");
        String proName = ntManager.showProductorAudio(aName);
        System.out.println("Here are the songs of the " + proName);
        System.out.println("Type the name of the song you want to buy");
        String sName = read.nextLine();
        String alert = ntManager.buySong(aName, sName);
        System.out.println(alert);
    }

    public void generateInforms(){
        boolean continuar = true;
        while(continuar){
            System.out.println("Choose one of the next options");
            System.out.println(" 1 - Show the total amount of playbacks");
            System.out.println(" 2 - Show the most heared genre for an user");
            System.out.println(" 3 - Show the most heared genre in the platform");
            System.out.println(" 4 - Show the most heared category for an user");
            System.out.println(" 5 - Show the most heared category in the platform");
            System.out.println(" 6 - Show podium of artist");
            System.out.println(" 7 - Show the podium if content creators");
            System.out.println(" 8 - Show the podium of Songs");
            System.out.println(" 9 - Show the podium of Podcasts");
            System.out.println(" 10 - Show sales and songs selled for each genre");
            System.out.println(" 11 - Show info of the most selled song");
            System.out.println(" 12 - To show the most selled genre");
            System.out.println(" 13 - To return ro the previous menu ");
            int option = read.nextInt();
            switch(option){
                case 1: ntApp.showTotalAmountPlays();
                    break;
                case 2: ntApp.showMostHearedGenreOfUser();
                    break;
                case 3: ntApp.showMostHearedGenre();
                    break;
                case 4: ntApp.showMostHearedCategoryOfUser();
                    break;
                case 5: ntApp.showMostHearedCategory();
                    break;
                case 6: ntApp.artsistPodium();
                    break;
                case 7: ntApp.contentCPodium();
                    break;
                case 8: ntApp.podiumSongs();
                    break;
                case 9: ntApp.podiumPodcast();
                    break;
                case 10:
                    break;
                case 11: 
                    break;
                case 12:
                    break;
                case 13: System.out.println("Heading back to the previous menu");
                continuar = false;
                    break;
                default: System.out.println(" Invalid option");
                    break;
            }
        }
        
    }

    public void showTotalAmountPlays(){
        // Count plays, add method to SImulate audio
        int totalValue = ntManager.totalPlays();
        System.out.println("The total amount of played audios is " + totalValue);
    }

    public void showMostHearedGenreOfUser(){
        // Count plays, add method to SImulate audio
        System.out.println("Type the name of the user");
        System.out.println("Here are the users");
        ntManager.showRegisteredUsers(); 
        String uName = read.nextLine();
        String alert = ntManager.mostHearedGenreUsr(uName);
        System.out.println(alert);

    }

    public void showMostHearedGenre(){
        // Count plays, add method to SImulate audio
        String alert = ntManager.mostHearedGenre();
        System.out.println(alert);
    }

    public void showMostHearedCategoryOfUser(){
        // Count plays, add method to SImulate audio
        System.out.println("Type the name of the user");
        System.out.println("Here are the users");
        ntManager.showRegisteredUsers(); 
        String uName = read.nextLine();
        String alert = ntManager.mostHearedCategoryUser(uName);
        System.out.println(alert);
    }

    public void showMostHearedCategory(){
        // Count plays, add method to SImulate audio
        String alert = ntManager.mostHearedCategory();
        System.out.println(alert); 
    }

    public void artsistPodium(){
        String podio = ntManager.artistPodium();
        System.out.println(podio);
    }

    public void contentCPodium(){
        String podio = ntManager.contentCreatorPodium();
        System.out.println(podio);
    }

    public void podiumSongs(){
        String podio = ntManager.songsPodium();
        System.out.println(podio);
    }

    public void podiumPodcast(){
        String podio = ntManager.podcastPodium();
        System.out.println(podio);
    }
    
    public void mostSelledGenre(){
        String alert = ntManager.mostSelledGenre();
        System.out.println(alert);
    }

    public void showSalesAndSongsForEachGenre(){
        System.out.println("Choose one of the next options");
        System.out.println(" 1 - ROCK");
        System.out.println(" 2 - POP");
        System.out.println(" 3 - TRAP");
        System.out.println(" 4 - HOUSE");
        int option = read.nextInt();
        if(option != 1 || option!= 2 || option != 3 || option != 4){
            Boolean validateAns = true;
            while(validateAns){
                System.out.println("Invalid option");
                System.out.println("Please choose a valid one again");
                option = read.nextInt();
                if(option != 1 || option!= 2 || option != 3 || option != 4){
                    validateAns = false;
                }
            }
            
        }

        String alert = ntManager.salesSongsGenre(option);
        System.out.println(alert);

    }

}
