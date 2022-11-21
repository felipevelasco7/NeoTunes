package model;

import java.time.LocalDate;

public class User {
    //attributes
    private String nickname;
	private String id;
    private LocalDate regristrationDate;

/** 
    * User class <br>
    * <b> pre: </b> The object user must be created <br>
    * <b> post: </b> Saves the information of a user.
    * @param nickname is the nickname of the users.
    * @param id is the id of the user.
    * @param regristrationDate is the date in which the user is registered.
    */
    public User(String nickname, String id){
        this.nickname=nickname;
        this.id=id;
        regristrationDate=LocalDate.now();
    }

/**
    *Gets the id of the user <br>
    *<b>pre: </b>The user must be created <br>
    *<b>post: </b> Informs the id of the user.
    * @param id is the id of the user.
    *@return the id of the user
    */
    public String getId(){
        return id;
    }

    /**Gets the nickname
     * @return the nickname
     */
    public String getNickname(){
        return nickname;
    }

}
