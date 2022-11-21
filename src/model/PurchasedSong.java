package model;

import java.time.LocalDate;

public class PurchasedSong {
    private LocalDate operationDate;
    private Song song;

    /**Purchased Songs
     * @param song is the song purchased
     */
    public PurchasedSong(Song song){
        operationDate=LocalDate.now();
        this.song=song;

    }

    
}
