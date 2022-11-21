package model;
import java.util.ArrayList;

public class Playlist {
    
    //attributes
    private String name;
    private ArrayList<Audio> audios;
    private int[][] playlistID;

/** Playlist class <br>
    * <b> pre: </b> The object must be created <br>
    * <b> post: </b> saves the information of the playlist.
    * @param name is the name of the playlist.
    * @param id is the id of the playlist
    * @param audios is the arraylist containing the audios of the playlist.
    */       
    public Playlist(String name){
        this.name=name;
        audios=new ArrayList<Audio>();
        playlistID= new int[6][6];
        createMatrix(playlistID);
        //deplegarMatriz(playlistID);
    }
    
/*  public static void deplegarMatriz(int[][]matriz){
        for(int i=0; i<matriz.length;i++){
            for(int j=0; j<matriz[i].length;j++){
                if(matriz[i][j]<10){
                    System.out.print(" "+matriz[i][j]+" ");
                }
                else{
                    System.out.print(matriz[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    */
    
/** Adds random numbers to a matrix <br>
    *<b>pre: </b>The playlist must be created <br>
    *<b>post: </b> fills a matrix with random numbers.
    *@param matrix is a the matrix to fill.
    */
    public static void createMatrix(int[][]matrix){
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[i].length;j++){
                matrix[i][j]=(int)(Math.random()*10);
            }
        }
    }
   
/** Gets the name of the playlist <br>
    *<b>pre: </b>The playlist must be created <br>
    *<b>post: </b> Informs the name of the playlist.
    * @param name is the name of the playlist.
    *@return the name of the playlist
    */
    public String getName(){
        return name;
    }
 
/** Adds a song to the playlist <br>
    *<b>pre: </b>The playlist must be created <br>
    *<b>post: </b> Adds a song to the playlist.
    *@param msg is a confirmation or error message.
    *@return a confirmation or error message.
    */
    public String addSong(Song audio){
        String msg="Audio agregado";
        audios.add(audio);
        return msg;
    }

/** Adds a podcast to the playlist <br>
    *<b>pre: </b>The playlist must be created <br>
    *<b>post: </b> Adds a podcast to the playlist.
    *@param msg is a confirmation or error message.
    *@return a confirmation or error message.
    */
    public String addPodcast(Podcast audio){
        String msg="Audio agregado";
        audios.add(audio);
        return msg;
    }

/** Removes a song from the playlist <br>
    *<b>pre: </b>The playlist must be created <br>
    *<b>post: </b> Removes a song to the playlist.
    *@param msg is a confirmation or error message.
    *@return a confirmation or error message.
    */
    public String remove(String audioName){
        String msg="Este audio no esta en esta playlist";
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i).getName().equalsIgnoreCase(audioName)){
                audios.remove(i);
                msg="Audio eliminado";
                i=audios.size();
            }
        }
        return msg;
    }

    /** Generates a unique code for the playlist <br>
     *<b>pre: </b>The playlist must be created <br>
     *<b>post: </b> creates a code of the playlist.
     * @param code is the code
     * @param hasSongs indicates if the playlist has songs in it.
     * @param hasPodcast indicates if the playlist has podcasts in it.
     * @param msg is the message displayed after the process is completed.
     * @return a message informing the code
     */
    public String generateCode(String name){
        String code="";
        boolean hasSongs=false;
        boolean hasPodcast=false;
        String msg="";

        for(int i=0; i<audios.size();i++){
            if(audios.get(i) instanceof Song){
                hasSongs=true;
            }
            if(audios.get(i) instanceof Podcast){
                hasPodcast=true;
            }
        }

        int size=playlistID.length-1;

        if(hasSongs&& hasPodcast){
            for(int i=size; i>=0 ;i--){
                for(int j=size; j>=0;j--){
                    if((i+j)%2!=0 && (i+j)>1){
                        code=code+playlistID[i][j];
                    }
                }
            }
        }
        
        else if(hasSongs){
            for(int j=size; j>0;j--){
                code= code+playlistID[j][0];
            }
            for(int i=0; i<size;i++){
                code= code+playlistID[i][i];
            }
            for(int j=size; j>=0;j--){
                code= code+playlistID[j][size];
            }
        }

        else if(hasPodcast){
            code= code+playlistID[0][0];
            code= code+playlistID[0][1];

            for(int i=0; i<playlistID.length;i++){
                code= code+playlistID[i][2];
            }
            for(int j=size; j>=0;j--){
                code= code+playlistID[j][3];
            }
            code= code+playlistID[0][4];
            code= code+playlistID[0][5];
        }
        
        else{
            msg="No hay ningun audio en esta playlist, no se puede generar un codigo";
        }

        msg="El codigo de la playlist "+name+" es: ";

        return msg;
    }
    
}
