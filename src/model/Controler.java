package model;
import java.util.ArrayList;

public class Controler {
    //attributes

	//relations
    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Playlist> playlists;
    private Add adds;
    
	//methods

/** 
    * Controler class <br>
    * <b> pre: </b> The object Controler must be created <br>
    * <b> post: </b> Creates the arrays of the audios, users and playlists.
    * @param users is the arraylist of the users.
    * @param audios is the arraylist of the audios.
    * @param playlists iis the arraylist of the playlists.
    */
    public Controler(){
        users=new ArrayList<User>();
        audios=new ArrayList<Audio>();
        playlists=new ArrayList<Playlist>();
        adds= new Add ();
    }

/** 
    *Adds a new producer <br>
    * <b> pre: </b> the array users must be created <br>
    * <b> post: </b> adds a new producer to the array.
    *@param nickname Is the unique identifier of the producer.
    *@param name is the name of the user
    *@param id The id number of the user.
    *@param msg a confirmation or error message displayed after trying to add a new producer.
    *@param objUser an object containing the information of a user.
    *@return the confirmation message when completed 
    */
    public String registerProducers(String nickname, String id, String name, String url, String type){
        String msg="";
        if(isRegistered(nickname)){
            msg="Este nickname ya esta registrado";
        }
        else{
            switch(type){
                case "1": 
                    Artist objUser= new Artist(nickname, id, name, url);
                    users.add(objUser);
                    msg="Artista agregado exitosamente";
                    break;
                case "2": 
                    Creator objUser1= new Creator(nickname, id, name, url);
                    users.add(objUser1);
                    msg="Creador de contenido agregado exitosamente";
                    break;
                default: msg="Ingrese un tipo de usuario valido";
            }
        }
        return msg;
    }

/** 
    *Adds a new consumer <br>
    * <b> pre: </b> the array users must be created <br>
    * <b> post: </b> adds a new consumer to the array.
    *@param nickname Is the unique identifier of the consumer.
    *@param name is the name of the user
    *@param id The id number of the user.
    *@param msg a confirmation or error message displayed after trying to add a new consumer.
    *@param objUser an object containing the information of a  premium user.
    *@param objUser1 an object containing the information of a Standard user.
    *@return the confirmation message when completed 
    */
    public String registerConsumers(String nickname, String id, String lvl){
        String msg="";
        if(isRegistered(nickname)){
            msg="Este nickname ya esta registrado";
        }
        else{
            switch (lvl){
                case "1":
                    User objUser= new Premium(nickname, id);
                    users.add(objUser);
                    msg="Usuario Consumidor Premium agregado exitosamente";
                    break;
                case "2":
                    User objUser1= new Standard(nickname, id);
                    users.add(objUser1);
                    msg="Usuario Consumidor Standard agregado exitosamente";
                    break;
                default: msg="Ingrese un tipo de usuario valido";

            }
            
        }
        return msg;
    }
    
/** 
    *Verifies if the user is already registered <br>
    * <b> pre: </b> the array users must be created <br>
    * <b> post: </b> true if the nickname is already registered.
    *@param isRegistered indicates if the nickname is already registered.
    *@param nickname is the nickname of the user to verify.
    *@return true if the nickname is already registered.
    */
    public boolean isRegistered(String nickname){
        boolean isRegistered=false;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                isRegistered=true;
                i=users.size();
            }
        }
        return isRegistered;
    }

/** 
    *Verifies if the audio is already registered <br>
    * <b> pre: </b> the array audios must be created <br>
    * <b> post: </b> true if the song is already registered.
    *@param isRegistered indicates if the audio is already registered.
    *@param audio is the name of the song to verify.
    *@return true if the audio is already registered.
    */
    public boolean isAvailable(String audioName){
        boolean isAvailable=true;
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i).getName().equalsIgnoreCase(audioName)){
                isAvailable=false;
                i=users.size();
            }
        }
        return isAvailable;
    }

/**Gets the position of a user in the user array<br>
     * <b> pre: </b> the array users must be created <br>
     * <b> post: </b> Gets the position of a user in the user array.
     * @param nickname is the nickname of the user.
     * @return the position of the user in the arraylist.
     */
    public int getUserPosition(String nickname){
        int position=-1;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                position=i;
                i=users.size();
            }
        }
        return position;
    }

/** 
    *Adds a new audio <br>
    * <b> pre: </b> the array audios must be created <br>
    * <b> post: </b> adds a new audio to the array.
    *@param objAudio is the object created.
    *@param msg a confirmation or error message displayed after trying to add a new consumer.
    *@return the confirmation message when completed 
    */
    public String registerAudio(String name, double duration, String album, String albumURL, double price, int genre, String artistName){
        String msg="Error, el artista ingresado no esta registrado";
        if(isRegistered(artistName)){
            

            for(int i=0; i<users.size();i++){  
                if(users.get(i).getNickname().equalsIgnoreCase(artistName) && users.get(i) instanceof Artist){
                    Artist obj= (Artist) users.get(i);

                    Song objAudio= new Song (name, duration, album, albumURL, price, genre, obj);
                    audios.add(objAudio);
                    obj.addSong(objAudio);
                }
            }

            msg="Cancion agregada exitosamente";
        }
        return msg;
        
    }

/** 
    *Adds a new audio <br>
    * <b> pre: </b> the array audios must be created <br>
    * <b> post: </b> adds a new audio to the array.
    *@param objAudio is the object created.
    *@param msg a confirmation or error message displayed after trying to add a new consumer.
    *@return the confirmation message when completed 
    */
    public String registerAudio(String name, double duration, String description, String imageURL, int cat, String creatorName){
        String msg="Error, el creador de contenido ingresado no esta registrado";
        
        if(isRegistered(creatorName)){
            

            for(int i=0; i<users.size();i++){  
                if(users.get(i).getNickname().equalsIgnoreCase(creatorName) && users.get(i) instanceof Creator){
                    Creator obj= (Creator) users.get(i);
                    Podcast objAudio= new Podcast (name, duration, description, imageURL, cat, obj);
                    audios.add(objAudio);
                    obj.addPodcast(objAudio);
                }
            }
            msg="Podcast agregada exitosamente";

        }
        return msg;
    }

/** 
    *Adds a new Playlist <br>
    * <b> pre: </b> the array playlist must be created <br>
    * <b> post: </b> adds a new playlist to the array.
    *@param objPlaylist is the object created.
    *@param msg a confirmation or error message displayed after trying to add a new consumer.
    *@return the confirmation message when completed 
    */
    public String createPlaylist(String name){
        String msg="";
        if(exists(name)){
            msg="Esta playlist ya existe,  eliga otro nombre";
        }
        else {
            
            Playlist objPlaylist= new Playlist(name);
            playlists.add(objPlaylist);
            msg="Playlist creada exitosamente";
        }
        return msg;
    }

/** 
    *Verifies if the playist is already registered <br>
    * <b> pre: </b> the array playlist must be created <br>
    * <b> post: </b> true if the playlist name is already registered.
    *@param isRegistered indicates if the playlist is already registered.
    *@param playlistName is the name of the playlist to verify.
    *@return true if the playlist is already registered.
    */
    public boolean exists(String playlistName){
        boolean isRegistered=false;
        for (int i = 0; i < playlists.size(); i++) {
            if(playlists.get(i).getName().equalsIgnoreCase(playlistName)){
                isRegistered=true;
                i=users.size();
            }
        }
        return isRegistered;
    }

/** 
    *Edits a Playlist <br>
    * <b> pre: </b> the  playlist must be created <br>
    * <b> post: </b> edits a song from a playlisty.
    *@param msg a confirmation or error message displayed after trying to edit a playlist.
    *@param exists indicates if the playlist already exists.
    *@param position indicates in which position of the array the playlist is set.
    *@return the confirmation message when completed 
    */
    public String editPlaylist(String name, String audioName, String choice){
        String msg="";
        boolean exists=false;
        int position=-1;

        for (int i = 0; i < playlists.size(); i++) {
            if(playlists.get(i).getName().equalsIgnoreCase(name)){
                exists=true;
                position=i;
                i=playlists.size();
            }
        }
        if(exists){
            switch(choice){
                case "1":
                    msg="Este audio no esta registrado";
                    for (int i = 0; i < audios.size(); i++) {
                        if(audios.get(i).getName().equalsIgnoreCase(audioName)){
                            if(audios.get(i) instanceof Song){
                                Song objAudio= (Song)audios.get(i);
                                msg= playlists.get(position).addSong(objAudio);
                            }
                            else{
                                Podcast objAudio= (Podcast)audios.get(i);
                                msg= playlists.get(position).addPodcast(objAudio);
                            }
                            i=playlists.size();
                        }
                    }
                    break;

                case "2":
                    msg=playlists.get(position).remove(audioName);
                    break;
                default:
                msg="Ingrese una opcion valida";
            }
        }
        else{
            msg="Esta playlist no existe";
        }
        
        return msg;
    }

/** 
    *Creates a code to share a Playlist <br>
    * <b> pre: </b> the  playlist must be created <br>
    * <b> post: </b> creates a code.
    *@param msg the unique code generated to share the playlist.
    *@return the confirmation message with the code. 
    */
    public String sharePlaylist(String name){
        String msg="";
        if(exists(name)){
            for (int i = 0; i < playlists.size(); i++) {
                if(playlists.get(i).getName().equalsIgnoreCase(name)){
                    msg=msg+playlists.get(i).generateCode(name);
                    i=playlists.size();
                }
            }
        }
        else{
            msg="La playlist ingresada no esta registrada";

        }
        return msg;
    }

/** Simulates playing an audio <br>
    *<b>pre: </b>The users, and audios arraylist must be created <br>
    *<b>post: </b> simulates playing an audio.
    *@param nickname Is the nickname of the consumer user.
    *@param audioName Is the name of the audio to listen.
    *@return a message simulating playing a song. 
    */ 
    public String playAudio(String nickname, String audioName){
        String msg="";
        if(isAvailable(audioName)){
            msg="Este audio no esta registrado";
        }
        else{
            for (int i = 0; i < users.size(); i++) {

                if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                    Consumer objConsumer= (Consumer)users.get(i);

                    for (int j = 0; j < audios.size(); j++) {

                        if(audios.get(j).getName().equalsIgnoreCase(audioName)){
                            
                            if(audios.get(j) instanceof Podcast){
                                Podcast objPodcast=(Podcast)audios.get(j);

                                if(users.get(i) instanceof Standard){
                                    adds.play();
                                } 
                                objPodcast.play();
                                objConsumer.addPodcastListen(objPodcast);
                            }
                            
                            else if (audios.get(j) instanceof Song){
                                Song objSong=(Song)audios.get(j);

                                if(users.get(i) instanceof Standard){
                                    Standard objStandard = (Standard)objConsumer;
                                    if (objStandard.getReproductions()%2==0){
                                        adds.play();
                                        objStandard.addReproductions();
                                    }
                                } 
                                objSong.play();
                                objConsumer.addSongListen(objSong);
                            }
                            i=users.size();
                        }
                    }
                }
                else{
                    msg="El nickname ingresado no esta registrado";

                }

            }
        }
        return msg;
    }

/** Buys a song <br>
     *<b>pre: </b>The audios, and users arraylist must be created <br>
     *<b>post: </b> buys a song.
     * @param nickname is the nickname of the user.
     * @param songName is the name of the song
     * @return a confirmation message.
     */
    public String buySong(String nickname, String songName){
        String msg="Este usuario no esta registrado";
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getNickname().equalsIgnoreCase(nickname)){
                for (int j = 0; j < audios.size(); j++) {
                    if(audios.get(j).getName().equalsIgnoreCase(songName)&& audios.get(j) instanceof Song){
                        Song objSong= (Song)audios.get(j);
                        objSong.buy();

                        if(users.get(i) instanceof Premium){
                            Premium objPremium= (Premium) users.get(i);
                            msg= objPremium.buySong(objSong);
            
                        }
                        else if(users.get(i) instanceof Standard){
                            Standard objStandard= (Standard) users.get(i);
                            msg= objStandard.buySong(objSong);
                        }
                        j=audios.size();
                    }
                    else{
                        msg="Esta cancion no existe";
                    }
                }
            }
            
        }
        return msg;
    }
    
/** Shows the total number of reproductions of each Audio type <br>
     *<b>pre: </b>The audios arraylist must be created <br>
     *<b>post: </b> Shows the total number of reproductions of each Audio type.
     * @return a message with the information.
     */
    public String totalReproductions(){
       
        int counterPodcast=0;
        int counterSongs=0;
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Podcast){
                counterPodcast=counterPodcast+audios.get(i).getReproductions();
            }
            else{
                counterSongs=counterSongs+audios.get(i).getReproductions();

            }
        }
        String msg=" El total de reproducciones es:\n "+counterPodcast+" para podcast. \n"+counterSongs+" Para canciones";
        return msg;
    }

/** Shows the most reproduced genre <br>
     *<b>pre: </b>The audios arraylist must be created <br>
     *<b>post: </b> Shows the most reproduced genre of a user and in all the program.
     * @param nickname is the nickname of the user.
     * @return a message with all the information.
     */
    public String bestGenre(String nickname){
        String bestGenre="";
        int rock=0;
        int pop=0;
        int trap=0;
        int house=0;
        for (int i = 0; i < audios.size(); i++) {
            
            if(audios.get(i) instanceof Song){
                Song objSong=(Song) audios.get(i) ;
                int reproductions=objSong.getReproductions();
                if(objSong.getGenre()==Genre.ROCK){
                    rock=rock+reproductions;
                }
                else if(objSong.getGenre()==Genre.POP){
                    pop=pop+reproductions;
                }
                else if(objSong.getGenre()==Genre.TRAP){
                    trap=trap+reproductions;
                }
                else if(objSong.getGenre()==Genre.HOUSE){
                    house=house+reproductions;
                }
            }

        }

        if(rock+pop+trap+house==0){
            bestGenre="No hay reproducciones aun";

        }
        else if(rock>=pop && rock>=trap && rock>=house){
            bestGenre="rock";
        }
        else if(pop>=rock && pop>=trap && pop>=house){
            bestGenre="pop";
        }
        else if(trap>=rock && trap>=pop && trap>=house){
            bestGenre="trap";
        }
        else if(house>=rock && house>=pop && house>=trap){
            bestGenre="house";
        }
        
        String msg="El genero de cancion mas escuchado de toda la plataforma es: "+ bestGenre;

        if(isRegistered(nickname)){
            Consumer objConsumer=(Consumer)users.get(getUserPosition(nickname));
            msg=msg+"\n El genero favorito de "+nickname+" es: "+ objConsumer.getFavGenre();
        }
        else{
            msg="Este nickname no esta registrado";
        }

        return msg;
    }
    
/** Shows the most reproduced Category <br>
     *<b>pre: </b>The audios arraylist must be created <br>
     *<b>post: </b> Shows the most reproduced category of a user and in all the program.
     * @param nickname is the nickname of the user.
     * @return a message with all the information.
     */
    public String bestCat(String nickname){
        String bestCat="";

        int politics=0;
        int entret=0;
        int video=0;
        int fashion=0;
        for (int i = 0; i < audios.size(); i++) {
            
            if(audios.get(i) instanceof Podcast){
                Podcast objPodcast=(Podcast) audios.get(i) ;
                int reproductions=objPodcast.getReproductions();
                if(objPodcast.getCat()==Category.POLITICS){
                    politics=politics+reproductions;
                }
                else if(objPodcast.getCat()==Category.ENTRETAINMENT){
                    entret=entret+reproductions;
                }
                else if(objPodcast.getCat()==Category.VIDEOGAMES){
                    video=video+reproductions;
                }
                else if(objPodcast.getCat()==Category.FASHION){
                    fashion=fashion+reproductions;
                }
            }

        }
        if(politics+entret+video+fashion==0){
            bestCat="No hay reproducciones aun";

        }
        else if(politics>=entret && politics>=video && politics>=fashion){
            bestCat="politica";
        }
        else if(entret>=politics && entret>=video && entret>=fashion){
            bestCat="Entretenimiento";
        }
        else if(video>=politics && video>=entret && video>=fashion){
            bestCat="video";
        }
        else if(fashion>=politics && fashion>=entret && fashion>=video){
            bestCat="fashion";
        }
        
        String msg="El genero de podcast mas escuchado de toda la plataforma es: "+ bestCat;

        if(isRegistered(nickname)){
            Consumer objConsumer=(Consumer)users.get(getUserPosition(nickname));
            msg=msg+"\n La Categoria favorita de "+nickname+" es: "+ objConsumer.getFavCat();
        }
        else{
            msg=msg+"\nEste nickname no esta registrado";
        }

        return msg;
    }
    
/** Shows the top 5 Artists and Creators <br>
     *<b>pre: </b>The users arraylist must be created <br>
     *<b>post: </b> Shows the top 5 Artists and Creators.
     * @return a message with all the information.
     */
    public String top5(){
        String msg="Error";
        String [] top5arr = new String[5];
        int [] top5RepProd = new int[5];

        String [] top5arrArtists = new String[5];
        int [] top5RepArt = new int[5];

        for(int x=0; x<top5arr.length; x++){
            top5arr[x]="No hay Creadores registrados";
            top5arrArtists[x]="No hay artistas registrados";
            top5RepProd[x]=0;
            top5RepArt[x]=0;

            for (int i = 0; i < users.size(); i++) {    
                
                if(users.get(i) instanceof Creator){
                    if(!users.get(i).getNickname().equalsIgnoreCase(top5arr[0])&& !users.get(i).getNickname().equalsIgnoreCase(top5arr[1])&& !users.get(i).getNickname().equalsIgnoreCase(top5arr[2])&& !users.get(i).getNickname().equalsIgnoreCase(top5arr[3])&& !users.get(i).getNickname().equalsIgnoreCase(top5arr[4])){
                        Creator objProd=(Creator)users.get(i);
                        int points=objProd.getReproductions();
                        top5arr[x]=objProd.getNickname();
                        top5RepProd[x]= objProd.getReproductions();

    
                        for(int j=0; j<users.size(); j++){
                            if(users.get(j) instanceof Creator){
                                Creator objProd1=(Creator)users.get(j);
                                if(!users.get(j).getNickname().equalsIgnoreCase(top5arr[0])&& !users.get(j).getNickname().equalsIgnoreCase(top5arr[1])&& !users.get(j).getNickname().equalsIgnoreCase(top5arr[2])&& !users.get(j).getNickname().equalsIgnoreCase(top5arr[3])&& !users.get(j).getNickname().equalsIgnoreCase(top5arr[4]) && objProd1.getReproductions()>points){
                                    points=objProd1.getReproductions();
                                    top5arr[x]=objProd1.getNickname();
                                    top5RepProd[x]= objProd1.getReproductions();

                                }
                            }
                            
                        }
                    }   
                }
                else if(users.get(i) instanceof Artist){
                    if(!users.get(i).getNickname().equalsIgnoreCase(top5arrArtists[0])&& !users.get(i).getNickname().equalsIgnoreCase(top5arrArtists[1])&& !users.get(i).getNickname().equalsIgnoreCase(top5arrArtists[2])&& !users.get(i).getNickname().equalsIgnoreCase(top5arrArtists[3])&& !users.get(i).getNickname().equalsIgnoreCase(top5arrArtists[4])){
                        Artist objArtist=(Artist)users.get(i);
                        int points=objArtist.getReproductions();
                        top5arrArtists[x]=objArtist.getNickname();
                        top5RepArt[x]= objArtist.getReproductions();

    
                        for(int j=0; j<users.size(); j++){
                            if(users.get(j) instanceof Artist){
                                Artist objArtist1=(Artist)users.get(j);
                                if(!users.get(j).getNickname().equalsIgnoreCase(top5arrArtists[0])&& !users.get(j).getNickname().equalsIgnoreCase(top5arrArtists[1])&& !users.get(j).getNickname().equalsIgnoreCase(top5arrArtists[2])&& !users.get(j).getNickname().equalsIgnoreCase(top5arrArtists[3])&& !users.get(j).getNickname().equalsIgnoreCase(top5arrArtists[4]) && objArtist1.getReproductions()>points){
                                    points=objArtist1.getReproductions();
                                    top5arrArtists[x]=objArtist1.getNickname();
                                    top5RepArt[x]= objArtist1.getReproductions();
                                }
                            }
                            
                        }
                    }   
    
                }

            }
        }
        msg="Top 5 Creadores \n1. "+top5arr[0]+" Reproducciones: "+top5RepProd[0] +"\n2. "+top5arr[1]+" Reproducciones: "+top5RepProd[1]+"\n3. "+top5arr[2]+" Reproducciones: "+top5RepProd[2]+"\n4. "+top5arr[3]+" Reproducciones: "+top5RepProd[3]+"\n5. "+top5arr[4]+" Reproducciones: "+top5RepProd[4];
        msg=msg+"\nTop 5 Artistas \n1. "+top5arrArtists[0]+" Reproducciones: "+top5RepArt[0] +"\n2. "+top5arrArtists[1]+" Reproducciones: "+top5RepArt[1]+"\n3. "+top5arrArtists[2]+" Reproducciones: "+top5RepArt[2]+"\n4. "+top5arrArtists[3]+" Reproducciones: "+top5RepArt[3]+"\n5. "+top5arrArtists[4]+" Reproducciones: "+top5RepArt[4];

        return msg;
    }

/** Shows the top 10 podcasts and Songs <br>
     *<b>pre: </b>The users arraylist must be created <br>
     *<b>post: </b> Shows the top 10 podcasts and Songs 
     * @return a message with all the information.
     */
    public String top10Audios(){
        String msg="Error";
        String [] top10Podcast = new String[10];
        int [] top5RepPod = new int[10];
        int [] top5RepSong = new int[10];
        String [] top10Songs = new String[10];
        for(int x=0; x<top10Podcast.length; x++){
            top10Podcast[x]="No hay Creadores registrados";
            top10Songs[x]="No hay artistas registrados";

            for (int i = 0; i < audios.size(); i++) {    
                
                if(audios.get(i) instanceof Podcast){
                    if(!audios.get(i).getName().equalsIgnoreCase(top10Podcast[0])&& !audios.get(i).getName().equalsIgnoreCase(top10Podcast[1])&& !audios.get(i).getName().equalsIgnoreCase(top10Podcast[2])&& !audios.get(i).getName().equalsIgnoreCase(top10Podcast[3])&& !audios.get(i).getName().equalsIgnoreCase(top10Podcast[4])){
                        Podcast objPod=(Podcast)audios.get(i);
                        int points=objPod.getReproductions();
                        top10Podcast[x]=objPod.getName();
                        top5RepPod[x]=objPod.getReproductions();
    
                        for(int j=0; j<audios.size(); j++){
                            if(audios.get(j) instanceof Podcast){
                                Podcast objPod1=(Podcast)audios.get(j);
                                if(!audios.get(j).getName().equalsIgnoreCase(top10Podcast[0])&& !audios.get(j).getName().equalsIgnoreCase(top10Podcast[1])&& !audios.get(j).getName().equalsIgnoreCase(top10Podcast[2])&& !audios.get(j).getName().equalsIgnoreCase(top10Podcast[3])&& !audios.get(j).getName().equalsIgnoreCase(top10Podcast[4]) && objPod1.getReproductions()>points){
                                    points=objPod1.getReproductions();
                                    top10Podcast[x]=objPod1.getName();
                                    top5RepPod[x]=objPod1.getReproductions();
    
                                }
                            }
                            
                        }
                    }   
                }
                else if(audios.get(i) instanceof Song){
                    
                    if(!audios.get(i).getName().equalsIgnoreCase(top10Songs[0])&& !audios.get(i).getName().equalsIgnoreCase(top10Songs[1])&& !audios.get(i).getName().equalsIgnoreCase(top10Songs[2])&& !audios.get(i).getName().equalsIgnoreCase(top10Songs[3])&& !audios.get(i).getName().equalsIgnoreCase(top10Songs[4])){
                        Song objArtist=(Song)audios.get(i);
                        int points=objArtist.getReproductions();
                        top10Songs[x]=objArtist.getName();
                        top5RepSong[x]=objArtist.getReproductions();

    
                        for(int j=0; j<audios.size(); j++){
                            if(audios.get(j) instanceof Song){
                                Song objSong1=(Song)audios.get(j);
                                if(!audios.get(j).getName().equalsIgnoreCase(top10Songs[0])&& !audios.get(j).getName().equalsIgnoreCase(top10Songs[1])&& !audios.get(j).getName().equalsIgnoreCase(top10Songs[2])&& !audios.get(j).getName().equalsIgnoreCase(top10Songs[3])&& !audios.get(j).getName().equalsIgnoreCase(top10Songs[4]) && objSong1.getReproductions()>points){
                                    points=objSong1.getReproductions();
                                    top10Songs[x]=objSong1.getName();
                                    top5RepSong[x]=objSong1.getReproductions();
    
                                }
                            }
                            
                        }
                    }   
    
                }

            }
        }
        msg="Top 10 Podcast \n1. "+top10Podcast[0]+" Reproducciones: "+top5RepPod[0]+"\n2. "+top10Podcast[1]+" Reproducciones: "+top5RepPod[1]+"\n3. "+top10Podcast[2]+" Reproducciones: "+top5RepPod[2]+"\n4. "+top10Podcast[3]+" Reproducciones: "+top5RepPod[3]+"\n5. "+top10Podcast[4]+" Reproducciones: "+top5RepPod[4]+ "\n6. "+top10Podcast[5]+" Reproducciones: "+top5RepPod[5]+"\n7. "+top10Podcast[6]+" Reproducciones: "+top5RepPod[6]+"\n8. "+top10Podcast[7]+" Reproducciones: "+top5RepPod[7]+"\n9. "+top10Podcast[8]+" Reproducciones: "+top5RepPod[8]+"\n10. "+top10Podcast[9]+" Reproducciones: "+top5RepPod[9];
        msg=msg+"\nTop 10 Canciones \n1. "+top10Songs[0]+" Reproducciones: "+top5RepSong[0]+"\n2. "+top10Songs[1]+" Reproducciones: "+top5RepSong[1]+"\n3. "+top10Songs[2]+" Reproducciones: "+top5RepSong[2]+"\n4. "+top10Songs[3]+" Reproducciones: "+top5RepSong[3]+"\n5. "+top10Songs[4]+" Reproducciones: "+top5RepSong[4]+"\n6. "+top10Songs[5]+" Reproducciones: "+top5RepSong[5]+"\n.7 "+top10Songs[6]+" Reproducciones: "+top5RepSong[6]+"\n8. "+top10Songs[7]+" Reproducciones: "+top5RepSong[7]+"\n9. "+top10Songs[8]+" Reproducciones: "+top5RepSong[8]+"\n10. "+top10Songs[9]+" Reproducciones: "+top5RepSong[9];

        return msg;
    }

/** Shows the info of the songs genre <br>
     *<b>pre: </b>The audios arraylist must be created <br>
     *<b>post: </b> Shows the info of the songs genre.
     * @return a message with all the information.
     */
    public String genreInfo(){
        int rock=0;
        int pop=0;
        int trap=0;
        int house=0;
        double rockMoney=0;
        double popMoney=0;
        double trapMoney=0;
        double houseMoney=0;
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                Song objSong=(Song) audios.get(i) ;
                int reproductions=objSong.getNumberOfSales();
                double money=objSong.getTotalSold();

                if(objSong.getGenre()==Genre.ROCK){
                    rock=rock+reproductions;
                    rockMoney=rockMoney+money;
                }
                else if(objSong.getGenre()==Genre.POP){
                    pop=pop+reproductions;
                    popMoney=popMoney+money;

                }
                else if(objSong.getGenre()==Genre.TRAP){
                    trap=trap+reproductions;
                    trapMoney=trapMoney+money;

                }
                else if(objSong.getGenre()==Genre.HOUSE){
                    house=house+reproductions;
                    houseMoney=houseMoney+money;
                }
            }
        }
        String msg="Rock: "+rock+" canciones vendidas, con un valor total de ventas de: "+rockMoney+"\n Pop: "+pop+" canciones vendidas, con un valor total de ventas de: "+popMoney+"\n Trap: "+trap+" canciones vendidas, con un valor total de ventas de: "+trapMoney+"\n House: "+house+" canciones vendidas, con un valor total de ventas de: "+houseMoney;
        return msg;
    }

/** Shows the info of the most sold songs <br>
     *<b>pre: </b>The audios arraylist must be created <br>
     *<b>post: </b> Shows the info of the most sold songs .
     * @return a message with all the information.
     */
    public String mostSoldSong(){
        String msg="Aun no hay canciones compradas";
        int mostSold=-1;
        int position=-1;
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                Song objSong=(Song) audios.get(i);
                if(objSong.getNumberOfSales()>mostSold){
                    mostSold=objSong.getNumberOfSales();
                    position=i;
                }
            }
        }
        if(position>-1){
            Song obj=(Song) audios.get(position);
            msg="La cancion mas vendida es: " +obj.getName()+ " Ventas: "+obj.getNumberOfSales()+" Total vendido: "+obj.getTotalSold();
        }
        return msg;
    }

}
