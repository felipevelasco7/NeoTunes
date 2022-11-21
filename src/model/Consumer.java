package model;

public class Consumer extends User {
    //attributes

    private double podcastListeningTime;
    private double musicListeningTime;
      
    private String favoriteGenre;
    private String favoriteCategory;
    private String favoriteArtist;
    private String favoriteCreator;
    private int[] favGen;
    private int[] favCat;
  
    //relations
  
/** 
    * Consumer User class <br>
    * <b> pre: </b> The object must be created <br>
    * <b> post: </b> Saves the information of a consumer user.
    * @param nickname is the nickname of the user.
    * @param id is the id of the user.
    */
    public Consumer (String nickname, String id){
        super(nickname, id);
        podcastListeningTime=0;
        musicListeningTime=0;   
        favoriteGenre="No hay datos sufucientes";
        favoriteCategory="No hay datos sufucientes";
        favoriteArtist="No hay datos sufucientes";
        favoriteCreator="No hay datos sufucientes";
        
        favGen = new int[]{0,0,0,0};
        favCat = new int[]{0,0,0,0};

    }
    
    /** Adds a podcast reproduction to a user
     * @param podcast is the podcast listened
     */
    public void addPodcastListen(Podcast podcast){
        podcastListeningTime= podcastListeningTime+ podcast.getDuration();
        if(podcast.getCat()==Category.POLITICS){
            favCat[0]=favCat[0]+1;
        }    
        else if(podcast.getCat()==Category.ENTRETAINMENT){
            favCat[1]=favCat[1]+1;

        }
        else if(podcast.getCat()==Category.VIDEOGAMES){
            favCat[2]=favCat[2]+1;

        }
        else if(podcast.getCat()==Category.FASHION){
            favCat[3]=favCat[3]+1;
        }

    }
    
    /** Adds a Song reproduction to a user
     * @param song is the song reproduced
     */
    public void addSongListen(Song song){
        musicListeningTime= musicListeningTime+ song.getDuration();
        if(song.getGenre()==Genre.ROCK){
            favGen[0]=favGen[0]+1;
        }    
        else if(song.getGenre()==Genre.POP){
            favGen[1]=favGen[1]+1;

        }
        else if(song.getGenre()==Genre.TRAP){
            favGen[2]=favGen[2]+1;

        }
        else if(song.getGenre()==Genre.HOUSE){
            favGen[3]=favGen[3]+1;
        }
    }
    
    /** gets the favorite genre of the consumer
     * @return a the most listened genre
     */
    public String getFavGenre(){
        int most=0;
        int position=-1;
        for (int i = 0; i < favGen.length; i++) {
            if(favGen[i]>most){
                most=favGen[i];
                position=i;
            }
        }
        switch(position){
            case 0: favoriteGenre="Rock";
            break;
            case 1: favoriteGenre="Pop";
            break;
            case 2: favoriteGenre="Trap";
            break;
            case 3: favoriteGenre="House";
            break;
            case -1: favoriteGenre="No Hay reproducciones aun ";
            break;
        }
        return favoriteGenre;
    }
    
    /**gets the favorite cat of the consumer
     * @return the favorite genre of the consumer
     */
    public String getFavCat(){
        int most=0;
        int position=-1;
        for (int i = 0; i < favCat.length; i++) {
            if(favCat[i]>most){
                most=favCat[i];
                position=i;
            }
        }
        switch(position){
            case 0: favoriteCategory="Politica";
            break;
            case 1: favoriteCategory="Entretenimiento";
            break;
            case 2: favoriteCategory="VideoJuegos";
            break;
            case 3: favoriteCategory="Moda";
            break;
            case -1: favoriteCategory="No Hay reproducciones aun ";
            break;
        }
        return favoriteCategory;
    }

  
    
}
