package model;

public class Podcast extends Audio implements Playable{
    //attributes
    public String description;
    
    //relations
    private Category category;
    private Creator creator;
    
/** 
    * Podcast class <br>
    * <b> pre: </b> The object podcast must be created <br>
    * <b> post: </b> saves the information of the podcast.
    * @param name is the name of the podcast.
    * @param duration is the duration of the podcast
    * @param url is the url of the image for the podcast.
    * @param reproductions is the number of times the podcast has been played.
    * @param description is the description of the podcast.
    * @param category is the category of the podcast.
    */   
    public Podcast (String name, double duration, String url, String description, int cat, Creator creator){
        super(name, duration, url);
        this.creator=creator;
        this.description=description;
        switch (cat){
            case 1:this.category=Category.POLITICS;
                break;
            case 2:this.category=Category.ENTRETAINMENT;
                break;
            case 3:this.category=Category.VIDEOGAMES;
                break;
            case 4:this.category=Category.FASHION;
                break;
        }
    }


@Override
public String play() {
System.out.println("*Reproduciendo podcast*"+ getName()); 
addReproduction();   
creator.addReproductions(getDuration());
return null;
}


/**Gets the creator of the podcast
 * @return the creator of the podcast
 */
public Creator getCreator(){
    return creator;
}

/**Gets the category of the podcast
 * @return the podcast category
 */
public Category getCat(){
    return category;
}

    
}
