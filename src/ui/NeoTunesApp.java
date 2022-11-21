package ui;
import model.Controler;

//import model.*;
import java.util.Scanner;

public class NeoTunesApp{
    public static Scanner input=new Scanner(System.in);
    public static Controler controler;

    public static void main(String args[]) {
        NeoTunesApp objMain= new NeoTunesApp();
        controler= new Controler();
        menu();
    }

/** 
     * Menu <br>
    * <b> pre: </b> The App must be initialiced <br>
    * <b> post: </b> The option that the user chooses will be done.
    * @param choice is the number of the option from the menu.
    */
    public static void menu(){
        System.out.println("Menu: Ingrese el numero de la operacion que desea realizar");
        System.out.println("1. Registrar usuarios productores, artistas y creadores de contenido.");
        System.out.println("2. Registrar usuarios consumidores, estándar y premium.");
        System.out.println("3. Registrar canciones y podcasts.");
        System.out.println("4. Crear una lista de reproducción.");
        System.out.println("5. Editar una lista de reproducción.");
     
        System.out.println("6. Compartir una lista de reproducción.");
        System.out.println("7. Simular la reproducción de una canción o podcast (estándar y premium).");
        System.out.println("8. Comprar una canción.");
        System.out.println("9. Generar informes con los datos registrados:");

        System.out.println("10. Finalizar");
        String choice= input.nextLine();
        switch (choice) {
            case "1":
                registerProducers();
                menu();
                break;
            case "2":
                registerConsumers();
                menu();
                break;
            case "3":
                registerAudio();
                menu();
                break;
            case "4":
                createPlaylist();
                menu();
                break;
            case "5":
                editPlaylist();
                menu();
                break;
        
            case "6":
                sharePlaylist();
                menu();
                break;
            case "7":
                playAudio();
                menu();
                break;
            case "8":
                buySong();
                menu();
                break;
            case "9":
                generateInfo();
                menu();
                break;

            case "10":
                System.out.println("Gracias");
                break;
            default: 
                System.out.println("Ingrese una opcion valida");
                menu();
        }
    }

/**
    *Registers a new producer <br>
    *<b>pre: </b>The user chooses the option to register a producer in the menu<br>
    *<b>post: </b> Creates a new producer  with the given data.
    *@param nickname Is the unique identifier of the producer.
    *@param name is the name of the user
    *@param id The id number of the user.
    *@param url The url to the image that represents the producer.
    */
    public static void registerProducers(){
        System.out.println("1. Registrar usuarios productores, artistas y creadores de contenido");
        System.out.println("Ingrese el Nickname");
        String nickname= input.nextLine();
        System.out.println("Es un productor: \n 1. Artista \n 2. Creador de contenido");
        String type= input.nextLine();
        System.out.println("Ingrese su cedula");
        String id= input.nextLine();
        System.out.println("Ingrese su nombre");
        String name= input.nextLine();
        System.out.println("Ingrese la URL de la imagen");
        String url= input.nextLine();
        System.out.println(controler.registerProducers(nickname,id,name,url,type));
        
    }

/**
    *Registers a new consumer <br>
    *<b>pre: </b>The user chooses the option to register a consumer in the menu<br>
    *<b>post: </b> Creates a new consumer  with the given data.
    *@param nickname Is the unique id of the user.
    *@param lvl is the subscription level of the consumer.
    *@param id The id number of the user.
    */
    public static void registerConsumers(){
        System.out.println("2. Registrar usuarios consumidores, estándar y premium.");
        System.out.println("Ingrese el Nickname");
        String nickname= input.nextLine();
        System.out.println("Ingrese su cedula");
        String id= input.nextLine();
        System.out.println("Es un usuario: \n 1. Premium \n 2. Estandar");
        String lvl= input.nextLine();

        System.out.println(controler.registerConsumers(nickname,id,lvl));
    }

/**
    *Registers a new Audio <br>
    *<b>pre: </b>The user chooses the option to register an audio in the menu<br>
    *<b>post: </b> Creates a new audio  with the given data.
    *@param name Is the name of the audio.
    *@param duration is the duration of the audio.
    *@param choice Indicates if the audio is a song or a podcast.
    *@param album The name of the album.
    *@param genre The genre of the song.
    *@param albumURL The url to the album image.
    *@param price The price of the song.
    *@param description The description to the podcast.
    *@param imageURL The url of the image of the podcast.
    *@param cat The category of the podcast.
    */
    public static void registerAudio(){

        System.out.println("3. Registrar canciones y podcasts.");

        System.out.println("Ingrese el nombre");
        String name= input.nextLine();
        System.out.println("Ingrese la duracion");
        double duration= input.nextDouble();
        if(controler.isAvailable(name)){
            System.out.println("¿Que tipo de audio desea registrar? \n 1. Cancion \n 2. Podcast");
            input.nextLine();
            String choice= input.nextLine();

            switch (choice) {
            case "1":
            System.out.println("Ingrese el nickname del artista");
            String artistName= input.nextLine();
            System.out.println("Ingrese el nombre del album");
            String album= input.nextLine();
            System.out.println("Ingrese el numero del genero de la cancion: \n 1. Rock \n 2. Pop \n 3. Trap \n 4. House");
            int genre= input.nextInt();
            input.nextLine();
            System.out.println("Ingrese la URL de la caratula del album");
            String albumURL= input.nextLine();
            System.out.println("Ingrese el precio de compra de la cancion");
            double price= input.nextDouble();
            input.nextLine();
            System.out.println(controler.registerAudio(name,duration, album, albumURL, price, genre, artistName));
                break;
            case "2":
                System.out.println("Ingrese el nickname del creador de contenido");
                String creatorName= input.nextLine();
                System.out.println("Ingrese la descripcion del podcast");
                String description= input.nextLine();
                System.out.println("Ingrese la URL de la imagen distintiva");
                String imageURL= input.nextLine();
                System.out.println("Ingrese el numero de la categoria del podcast: \n 1. Politica \n 2. Entretenimiento \n 3. Videojuegos \n 4. Moda");
                int cat= input.nextInt();
                input.nextLine();
                System.out.println(controler.registerAudio(name,duration, description, imageURL, cat, creatorName));
                break;
            default: 
                System.out.println("Ingrese una opcion valida");
                registerAudio();
            }
        }
        else{
            System.out.println("Error, ya hay un audio con este nombre");

        }
    }

/**
    *Registers a new playlist <br>
    *<b>pre: </b>The user chooses the option to register a playlist in the menu<br>
    *<b>post: </b> Creates a new playlist.
    *@param name Is the name of the playlist.
    */
    public static void createPlaylist(){
        System.out.println("4. Crear una lista de reproducción.");
        System.out.println("Ingrese el nombre de la playlist");
        String name= input.nextLine();
        System.out.println(controler.createPlaylist(name));

    }

/**
    *Edits a  playlist <br>
    *<b>pre: </b>The user chooses the option to edit a playlist in the menu<br>
    *<b>post: </b> edits an existing playlist.
    *@param name Is the name of the playlist.
    *@param choice indicates if the user wants to remove or add an audio to the playlist.
    *@param audio Is the name of the audio. 
    */ 
    public static void editPlaylist(){
        System.out.println("5. Editar una lista de reproducción.");
        System.out.println("Ingrese el nombre de la playlist a editar");
        String name= input.nextLine();
        
        System.out.println("Ingrese el numero de la opcion que desea realizar: \n 1. Añadir un audio \n 2. Eliminar un audio");
        String choice= input.nextLine();
        System.out.println("Ingrese el nombre del audio");
        String audio= input.nextLine();
        System.out.println(controler.editPlaylist(name, audio, choice));
        
    }

/**
    *Creates a code to share a  playlist <br>
    *<b>pre: </b>The user chooses the option to share a playlist in the menu<br>
    *<b>post: </b> creates a code for an existing playlist.
    *@param name Is the name of the playlist.
    */ 
    public static void sharePlaylist(){
        System.out.println("6. Compartir una lista de reproducción.");
        System.out.println("Ingrese el nombre de la playlist a compartir");
        String name= input.nextLine();
        System.out.println(controler.sharePlaylist(name));
    }

/** Simulates playing an audio <br>
    *<b>pre: </b>The user chooses the option to play an audio in the menu<br>
    *<b>post: </b> simulates playing an audio.
    *@param nickname Is the nickname of the consumer user.
    *@param audioName Is the name of the audio to listen.
    *@param choice Indicates if the user wants to listen to another audio.
    */ 
    public static void playAudio(){
        System.out.println("7. Simular la reproducción de una canción o podcast.");
        System.out.println("Ingrese su nickname");
        String nickname= input.nextLine();
        System.out.println("Ingrese el nombre del audio (Cancion o Podcast) que quiere reproducir:");
        String audioName= input.nextLine();         
        System.out.println(controler.playAudio(nickname, audioName));
        System.out.println("Desea escuchar otro audio?: \n1. Si \n2. No");
        String choice= input.nextLine();  
        while(choice.equalsIgnoreCase("1")){
            System.out.println("Ingrese el nombre del audio (Cancion o Podcast) que quiere reproducir:");
            audioName= input.nextLine();      
            System.out.println(controler.playAudio(nickname, audioName));
            System.out.println("Desea escuchar otro audio?: \n1. Si \n2. No");
            choice= input.nextLine();  
        }
        
        
    }

/** Buys a song <br>
     *<b>pre: </b>The user chooses the option to buy a song in the menu <br>
     *<b>post: </b> buys a song.
     * @param nickname is the nickname of the user.
     * @param songName is the name of the song
     */
    public static void buySong(){
        System.out.println("8. Comprar una canción.");
        System.out.println("Ingrese su nickname");
        String nickname= input.nextLine();
        System.out.println("El nombre de la cancion que quiere comprar");
        String songName= input.nextLine();
        System.out.println(controler.buySong(nickname, songName));

       
    }

/** Generates info <br>
     *<b>pre: </b>The user chooses the option to generate info in the menu <br>
     *<b>post: </b> Shows the information that the user wants to see.
     * @param choice is the choice of the user.
     * @param nickname is the nickname of the user.
     */
    public static void generateInfo(){
        System.out.println("9. Generar informes con los datos registrados");
        System.out.println("Ingrese el numero de la opcion que desea realizar:\n 1. informar el total de reproducciones de audio y podcast\n2.Informar el género de canción más escuchado para un usuario específico y para toda la plataforma\n3. nformar la categoría de podcast más escuchada para un usuario y de toda la plataforma.\n4. Top 5 de artistas y del Top 5 de creadores\5. Top 10 de canciones y del Top 10 de podcast\6. De cada género, informar el número de canciones vendidas y el valor total de ventas\n7. La Canción más vendida en la plataforma, el número total de ventas y el valor total de venta\n 8. Finalizar  .");
        String choice=input.nextLine();
        switch(choice){
            case"1":
            System.out.println(controler.totalReproductions());
            generateInfo();
            break;
            case"2":
            System.out.println("Ingrese el nickname del usuario");
            String nickname=input.nextLine();
            System.out.println(controler.bestGenre(nickname));
            generateInfo();
            break;
            case"3":
            System.out.println("Ingrese el nickname del usuario");
            nickname=input.nextLine();
            System.out.println(controler.bestCat(nickname));
            generateInfo();
            break;
            case"4":
            System.out.println("Top 5");
            System.out.println(controler.top5());
            generateInfo();
            break;
            case"5":
            System.out.println("Top 10");
            System.out.println(controler.top10Audios());
            generateInfo();
            break;
            case"6":
            System.out.println(controler.genreInfo());
            generateInfo();
            break;
            case"7":
            System.out.println(controler.mostSoldSong());
            generateInfo();
            break;
            case"8":
            break;
            default:
            System.out.println("Ingrese una opcion valida");
            generateInfo();
        }
    }
}