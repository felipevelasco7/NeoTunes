package model;

import java.util.ArrayList;

public class Artist extends Producer{
    //relations
    private ArrayList<Song> mySongs;
     
/**Creates a artist
     * @param nickname is the nickname of the artist
     * @param id is the artist id
     * @param name is the artist name
     * @param url the url to an image of the artist
     */
    public Artist(String nickname, String id, String name, String url) {
        super(nickname, id, name, url);
        mySongs=new ArrayList<Song>();
    }
    
/** Adds a song to an artist
     * @param objAudio is the object containing the audio
     */
    public void addSong(Song objAudio) {
        mySongs.add(objAudio);
    }
    
    
}
