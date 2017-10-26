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
    private String userMedication;
    private String userDiet;
    private String userAllergies;
    private String userVitalSigns;
    private String userExcercisePlan;
    private String userGoal1;
    private String userGoal2;
    private String userGoal3;
    private String userGoal4;
    private String userLongGoal;

    public static String currentUserName = "";

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

    //PARAMETIZED CONSTRUCTOR USED IN LOGIN PAGE
    public User(int userId,String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

   // PARAMETIZED CONSTRUCTOR USED IN HEALTH CARE PAGE
    public User(int userId,String userName, String userEmail, String userPassword, String userAllergies,
                String userMedication, String userDiet, String userExcercisePlan, String userVitalSigns,
                String userGoal1, String userGoal2, String userGoal3, String userGoal4, String userLongGoal ) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userMedication = userMedication;
        this.userAllergies = userAllergies;
        this.userVitalSigns = userVitalSigns;
        this.userDiet = userDiet;
        this.userExcercisePlan = userExcercisePlan;
        this.userGoal1 = userGoal1;
        this.userGoal2 = userGoal2;
        this.userGoal3 = userGoal3;
        this.userGoal4 = userGoal4;
        this.userLongGoal = userLongGoal;
    }

//GET METHODS---------------------------------------------------------------------------------------
    public int getId() {return userId;}

    public String getUserName() {return userName;}

    public String getUserEmail() {return userEmail;}

    public String getuserPassword() {return userPassword;}

    public String getUserAllergies() {return userAllergies;}

    public String getUserMedications() {return userMedication;}

    public String getUserVitalSigns() {return userVitalSigns;}

    public String getUserExcercisePlan() {return userExcercisePlan;}

    public String getUserDiet() {return userDiet;}

    public String getUserGoal1() {return userGoal1;}

    public String getUserGoal2() {return userGoal2;}

    public String getUserGoal3() {return userGoal3;}

    public String getUserGoal4() {return userGoal4;}

    public String getUserLongGoal() {return userLongGoal;}



    //SETTER METHODS------------------------------------------------------------------------------------
    public void setUserId(int userId){this.userId = userId;}

    public void setUserName(String userName) {this.userName = userName;}

    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

    public void setUserPassword(String userPassword){this.userPassword = userPassword;}

    public void setUserAllergies(String userAllergies) {this.userAllergies = userAllergies;}

    public void setUserMedications(String userMedication) {this.userMedication = userMedication;}

    public void setUserVitalSigns(String userVitalSigns) {this.userVitalSigns = userVitalSigns;}

    public void setUserExcercisePlan(String userExcercisePlan) {this.userExcercisePlan = userExcercisePlan;}

    public void setUserDiet(String userDiet) {this.userDiet = userDiet;}

    public void setCurrentUserName(String username){ this.currentUserName = username; }

    public void setUserGoal1(String userGoal1) { this.userGoal1 = userGoal1;}

    public void setUserGoal2(String userGoal2) { this.userGoal1 = userGoal2;}

    public void setUserGoal3(String userGoal3) { this.userGoal1 = userGoal3;}

    public void setUserGoal4(String userGoal4) { this.userGoal4 = userGoal4;}

    public void setUserLongGoal (String userLongGoal) {this.userLongGoal = userLongGoal;}
}
