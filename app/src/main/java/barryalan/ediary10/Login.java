package barryalan.ediary10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    User User1 = new User();
    Button btn_signin;
    Button btn_forgotLogin;
    EditText et_username;
    EditText et_password;
    CheckBox cb_passwordVisibility;
    int numberOfTries = 0;

    //EVERYTHING THAT HAPPENS IN LOGIN PAGE RUNS FROM HERE-----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //CREATE AND LINK BUTTONS AND TEXT BOXES TO THE ONES ON THE DISPLAY
        btn_signin = (Button) findViewById(R.id.btn_Lsignin);
        btn_forgotLogin = (Button) findViewById(R.id.btn_LforgotLogin);
        et_username = (EditText) findViewById(R.id.et_Lusername);
        et_password = (EditText) findViewById(R.id.et_Lpassword);
        cb_passwordVisibility = (CheckBox) findViewById(R.id.cb_LshowPassword);

        //IF THE BUTTON LINKED TO LOGIN IS CLICKED
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CHECK IF THE USER INPUTTED A USERNAME AND PASSWORD
                if (!(isEmpty(et_username)) & !(isEmpty(et_password))) {
                    if (isValid(et_username, et_password)) { //CHECK IF INFO IS A VALID USERS'
                        Log.e("hello", " got into onclick");
                        User1.setCurrentUserName(et_username.getText().toString());
                        gotoHealthActivity(v);
                    }
                }
            }
        });


        //ALLOWS THE USE OF THE SHOW PASSWORD FEATURE IN THE LOGIN PAGE-----------------------------
        cb_passwordVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //CHECKBOX STATUS IS CHANGED FROM UNCHECKED TO CHECKED
                if (!isChecked) {
                    // SHOW PASSWORD
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // MASK PASSWORD
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    //CHECKS IF THE TEXT BOX IS EMPTY OR NOT--------------------------------------------------------
    public boolean isEmpty(EditText edittext) {

        String message;
        String hint = edittext.getHint().toString();
        switch (hint) {
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

    //CHECKS IF USERNAME AND PASSWORD ARE IN THE DATABASE AND MATCH EACHOTHER-----------------------
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
        if (numberOfTries > 1) {
            btn_forgotLogin.setVisibility(View.VISIBLE);
        }
        //VALIDATE THE PASSWORD WITH THE ONE ON THE DATABASE
        if (password.equals(storedPassword)) {
            toast.show();
            return true;
        } else {
            toast1.show();
            numberOfTries++;
            return false;
        }
    }

    //LINK THE LOGIN PAGE TO THE REGISTRATION PAGE THROUGH THE BUTTON-------------------------------
    public void gotoRegistrationActivity(View view) {
        Intent name = new Intent(this, Registration.class);
        startActivity(name);
    }

    //LINK THE LOGIN PAGE TO THE HEALTH PAGE--------------------------------------------------------
    public void gotoHealthActivity(View view) {
        Intent name = new Intent(this, health_excercise.class);
        startActivity(name);
    }

    //LINK THE LOGIN PAGE TO THE FORGOT LOGIN PAGE--------------------------------------------------
    public void gotoForgotLoginActivity(View view) {
        Intent name = new Intent(this, forgotLogin.class);
        startActivity(name);
    }


}


