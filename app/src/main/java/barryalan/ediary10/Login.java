package barryalan.ediary10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btn_signin;
    Button btn_forgotLoging;
    EditText username;
    EditText password;
    int numberOfTries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //CREATE AND LINK BUTTONS AND TEXT BOXES TO THE ONES ON THE DISPLAY
        btn_signin = (Button) findViewById(R.id.btn_Lsignin);
        btn_forgotLoging = (Button) findViewById(R.id.btn_forgotLogin);
        username = (EditText) findViewById(R.id.et_Lusername);
        password = (EditText) findViewById(R.id.et_Lpassword);

        //IF THE BUTTON LINKED TO LOGIN IS CLICKED
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CHECK IF THE USER INPUTTED A USERNAME AND PASSWORD
                if (!(isEmpty(username)) & !(isEmpty(password))) {
                    if(isValid(username, password)) { //CHECK IF INFO IS A VALID USERS'
                       // gotoMockActivity(v); // go to a different page(activity) to show that you have logged in
                    }
                }
            }
        });
    }


    //CHECKS IF THE TEXT BOX IS EMPTY OR NOT
    public boolean isEmpty(EditText edittext) {

        String message = "";
        String hint =  edittext.getHint().toString();
        switch (hint){
            case "Name":
                message = "Enter a name";
                break;
            case "Password":
                message = "Enter a password";
                break;
            default:
                message = "Enter a value";
                break;
        }
        //VARIABLES FOR THE MESSAGE
        Context context = getApplicationContext();
        CharSequence text = "Please Enter all values";
        int duration = Toast.LENGTH_SHORT;

        //CREATES MESSAGE
        Toast toast = Toast.makeText(context, text, duration);

        String value = edittext.getText().toString();
        if (value.isEmpty()) {
            edittext.setError(message);//message is chosen on switch statement above
            toast.show(); //DISPLAYS MESSAGE
            return true;
        } else {
            return false;
        }

    }

    //CHECKS IF USERNAME AND PASSWORD ARE IN THE DATABASE AND MATCH EACHOTHER
    public boolean isValid(EditText usernametext, EditText passwordtext) {

        //CREATING THE LOGIN SUCCESSFUL MESSAGE
        Context context = getApplicationContext();
        CharSequence text = "Login Successful!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);

        //CREATING THE LOGIN FAILED MESSAGE
        Context context1 = getApplicationContext();
        CharSequence text1 = "Login Failed!" + numberOfTries;
        int duration1 = Toast.LENGTH_SHORT;
        Toast toast1 = Toast.makeText(context1, text1, duration1);

        //CREATING A NEW INSTANCE OF THE DATABASE IN ORDER TO ACCESS IT
        LoginDatabaseHelper lbh = new LoginDatabaseHelper(this);

        //GET THE INPUTTED TEXT FROM THE TEXT BOXES
        String userName = usernametext.getText().toString();
        String password = passwordtext.getText().toString();

        // FETCH THE PASSWORD FROM THE DATABASE FROM THE RESPECTIVE USERNAME
        String storedPassword = lbh.getUserPassword(userName);

        //GIVES YOU THREE TRIES UNTIL THE SYSTEM ALLOWS FOR A FORGOT LOGIN
        if(numberOfTries > 1){
            btn_forgotLoging.setVisibility(View.VISIBLE);
        }
        //VALIDATE THE PASSWORD WITH THE ONE ON THE DATABASE
        if(password.equals(storedPassword)) {
            toast.show();
            return true;
        }
        else {
            toast1.show();
            numberOfTries ++;
            return false;
        }
    }

    //LINK THE LOGIN PAGE TO THE REGISTRATION PAGE THROUGH THE BUTTON
    public void gotoRegistrationActivity(View view){
        Intent name = new Intent(this, Registration.class);
        startActivity(name);
    }

    //LINK THE LOGIN PAGE TO THE INSIDE OF THE APP
    public void gotoMockActivity(View view){
        Intent name = new Intent(this, mock.class);
        startActivity(name);
    }


    //LINK THE LOGIN PAGE TO THE INSIDE OF THE APP
    public void gotoForgotLoginActivity(View view){
        Intent name = new Intent(this, forgotLogin.class);
        startActivity(name);
    }
}


