package model;

public class Song extends Audio implements Playable, Buyable{
    //attributes
    private String album;
    public double price;
    public int numberOfSales;


    //relations
    private Genre genre;
    private Artist artist;


/** 
    * Song class <br>
    * <b> pre: </b> The object Song must be created <br>
    * <b> post: </b> saves the information of the song.
    * @param name is the name of the song.
    * @param duration is the duration of the song
    * @param url is the url of the image for the song album.
    * @param album is the name of the album of the song.
    * @param reproductions is the number of times the song has been played.
    * @param numberOfSales is the number of times the song has been sold.
    * @param genre is the genre of the song.
    */
    public Song (String name, double duration, String url, String album, double price, int genreNUM, Artist objArtist){
        super(name, duration, url);
        this.artist=objArtist;
        this.album=album;
        this.price=price;
        numberOfSales=0;
        switch (genreNUM){
            case 1:genre=Genre.ROCK;
                break;
            case 2:genre=Genre.POP;
                break;
            case 3:genre=Genre.TRAP;
                break;
            case 4:genre=Genre.HOUSE;
                break;
        }
    }


@Override
public String play() {
    System.out.println("*Reproduciendo cancion*"+ getName());    
    addReproduction();
    artist.addReproductions(getDuration());
    return null;
}

@Override
public String buy() {
    numberOfSales++;
    return null;
}


/**Gets the genre
 * @return the genre
 */
    public Genre getGenre() {
        return genre;
    }

    /**Gets the sales
     * @return the number of sales
     */
    public int getNumberOfSales() {
        return numberOfSales;
    }

    /**Gets the total sold
     * @return the total amount of money sold
     */
    public double getTotalSold() {
        return numberOfSales*price;
    }
}
