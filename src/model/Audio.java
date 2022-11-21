package model;

public class Audio {
    //attributes
    private String name;
	private double duration;
    private int reproductions;
    private String url;

/** 
    * Audio class <br>
    * <b> pre: </b> The object must be created <br>
    * <b> post: </b> saves the information of the audio.
    * @param name is the name of the audio.
    * @param duration is the duration of the audio
    * @param url is the url of the image of the audio.
    * @param reproductions is the number of times the audio has been played.
    */
    public Audio(String name, double duration, String url){
        this.name=name;
        this.duration=duration;
        this.url=url;
        reproductions=0;
    }

/**
    *Gets the name of the audio <br>
    *<b>pre: </b>The audio must be created <br>
    *<b>post: </b> Informs the name of the audio.
    * @param name is the name of the audio.
    *@return the name of the audio
    */   
    public String getName(){
        return name;
    }

/**Gets the duration of the audio
     * @return the audio duration
     */
    public double getDuration(){
        return duration;
    }

/** adds a reproduction <br>
    *<b>pre: </b>The audio must be created <br>
    *<b>post: </b> adds a reproduction.
    */   
    public void addReproduction(){
        reproductions++;
    
    }

/** gets the reproduction <br>
    *<b>pre: </b>The audio must be created <br>
    *<b>post: </b> gets the reproduction.
    */   
    public int getReproductions(){
        return reproductions;
    }
}
