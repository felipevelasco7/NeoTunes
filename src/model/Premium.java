package model;

import java.util.ArrayList;

public class Premium extends Consumer {
     //attributes
     
    //relations
    private ArrayList<PurchasedSong> mySongs;
    private ArrayList<Playlist> myPlaylists;


/** 
    * Premium consumer class <br>
    * <b> pre: </b> The object premium must be created <br>
    * <b> post: </b> Saves the information of a premium user.
    * @param nickname is the nickname of the users.
    * @param id is the id of the user.
    * @param myPlaylists is the arraylist for the consumers playlists
    * @param mySongs is the arraylist for the consumers songs.
    */
    public Premium(String nickname, String id){
        super(nickname, id);
        mySongs=new ArrayList<PurchasedSong>();
        myPlaylists=new ArrayList<Playlist>();        
    }
    
    /**Buys a song
     * @param song is the song to buy
     * @return a confirmation message
     */
    public String buySong(Song song){
        PurchasedSong objPurchase= new PurchasedSong(song);
        mySongs.add(objPurchase);
        return "Cancion Comprada exitosamente";
    }
}
