package barryalan.ediary10;

/**
 * Created by Al on 9/20/2017.
 * class which contains all the variables setters and getters for a user
 */

public class User {

//CLASS VARIABLES-----------------------------------------------------------------------------------
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;

//CONSTRUCTORS--------------------------------------------------------------------------------------
    //DEFAULT CONSTRUCTOR
    public User() {
    }

    //PARAMETIZED CONSTRUCTOR
    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    //PARAMETIZED CONSTRUCTOR
    public User(int userId,String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

//GET METHODS---------------------------------------------------------------------------------------
    public int getId() {return userId;}

    public String getUserName() {return userName;}

    public String getUserEmail() {return userEmail;}

    public String getuserPassword() {return userPassword;}

//SETTER METHODS------------------------------------------------------------------------------------
    public void setUserId(int userId){this.userId = userId;}

    public void setUserName(String userName) {this.userName = userName;}

    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

    public void setUserPassword(String userPassword){this.userPassword = userPassword;}
}
