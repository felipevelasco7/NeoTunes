package model;

public class Standard extends Consumer{
    //attributes
    private int reproductions;
    private Playlist[] myPlaylists;
    private PurchasedSong[] mySongs;

/** 
    * Standard consumer class <br>
    * <b> pre: </b> The object standard must be created <br>
    * <b> post: </b> Saves the information of a standard user.
    * @param nickname is the nickname of the users.
    * @param id is the id of the user.
    * @param myPlaylists is the array for the consumers playlists
    * @param mySongs is the array for the consumers songs.
    */
    public Standard(String nickname, String id){
        super(nickname, id);
        myPlaylists= new Playlist[20];
        mySongs= new PurchasedSong[100];
        reproductions=0;
    }
    
/** Gets reproductions <br>
     * <b> pre: </b> The object standard must be created <br>
     * <b> post: </b> gets the number of reproductions.
     * @return reproducrions
     */
    public int getReproductions(){
        return reproductions;
    }
    
/** adds reproductions <br>
     * <b> pre: </b> The object standard must be created <br>
     * <b> post: </b> adds 1 to the number of reproductions.
     */
    public void addReproductions(){
        reproductions++;
    }
    
/** Buy a song <br>
     * <b> pre: </b> The  standard user must be created <br>
     * <b> post: </b> adds the song to the mySongs array.
     * @param song is the song to buy.
     * @return a confirmation message.
     */
     public String buySong(Song song){
        String msg="Error, no hay espacio para comprar esta cancion";
        for(int i=0; i<mySongs.length;i++){
            if(mySongs[i]==null){
                mySongs[i]= new PurchasedSong(song);
                msg="Cancion comprada exitosamente";
                i=mySongs.length;
            }
        }
        return msg;
    }
}
