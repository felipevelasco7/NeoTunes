package model;

import java.util.ArrayList;

public class Creator extends Producer {

    //relations
    private ArrayList<Podcast> myPodcasts;

    /**Creator
     * @param nickname is the nickname if the creator
     * @param id is the id of the creator
     * @param name the name of the creatpr
     * @param url the url to an image
     */
    public Creator(String nickname, String id, String name, String url) {
        super(nickname, id, name, url);
        myPodcasts=new ArrayList<Podcast>();

    }
    
    /**Adds a podcast
     * @param objAudio is the podcast
     */
    public void addPodcast(Podcast objAudio) {
        myPodcasts.add(objAudio);
    }
   
   
    
}
