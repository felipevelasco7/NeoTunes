package model;


public class Producer extends User {
    //attributes

    private String name;
    private String url;
    private int reproductions;
    private double reproductionTime;


    //relations
    
/** 
    * producer User class <br>
    * <b> pre: </b> The object must be created <br>
    * <b> post: </b> Saves the information of a producer user.
    * @param nickname is the nickname of the users.
    * @param id is the id of the user.
    * @param regristrationDate is the date in which the user is registered.
    * @param reproductions is the number of reproductions the audios from this producr has.
    * @param reproductionTime is the time the audios of this producer have been played.
    * @param name is the name of the producer.    
    * @param url the url to a distinctive image of the producer.    
    */
    public Producer (String nickname, String id, String name, String url){
        super(nickname, id);
        reproductions=0;
        reproductionTime=0;       
        this.name=name;
        this.url=url;
        

    }


    /** Adds a reproduction
     * @param time is the time to add 
     */
    public void addReproductions(double time){
        reproductions++;
        reproductionTime=reproductionTime+time;
    }
    
    
    /**Gets the reproductions
     * @return the reproductions
     */
    public int getReproductions(){
        return reproductions;
    }
}
