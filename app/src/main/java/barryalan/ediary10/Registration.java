package barryalan.ediary10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.message;

public class Registration extends AppCompatActivity {

    //REGISTRATION PAGE BUTTONS
    Button btn_submit;
    EditText et_name;
    EditText et_password;
    EditText et_username;
    EditText et_email;
    //LOGIN PAGE BUTTONS
    EditText et_username1;
    EditText et_password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //CREATE AND LINK REGISTRATION PAGE BUTTONS AND TEXT BOXES TO THE ONES ON THE DISPLAY
        btn_submit = (Button) findViewById(R.id.btn_Rsubmit);
        et_name = (EditText) findViewById(R.id.et_Rname);
        et_password = (EditText) findViewById(R.id.et_Rpassword);
        et_username = (EditText) findViewById(R.id.et_Rusername);
        et_email = (EditText) findViewById(R.id.et_Remail);

        //CREATE AND LINK LOGIN PAGE BUTTONS AND TEXT BOXES TO THE ONES ON THE DISPLAY
        et_password1 = (EditText) findViewById(R.id.et_Lpassword);
        et_username1 = (EditText) findViewById(R.id.et_Lusername);

        //CREATE A NEW INSTANCE OF THE DATABASE FOR ACCESS
        final LoginDatabaseHelper db = new LoginDatabaseHelper(this);

        //IF THE BUTTON LINKED TO BTN IS CLICKED
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //IF USER INPUTS SOMETHING INTO ALL FIELDS
                if(!(isEmpty(et_name)) & !(isEmpty(et_password)) & !(isEmpty(et_username)) & !(isEmpty(et_email))){//check if all boxes have an input
                    if(!(db.isUsernameTaken(et_username))){ //check if username is taken
                        if(!(db.isEmailTaken(et_email))){ //check if email is taken
                            db.addUser(new User(et_username.getText().toString(), et_email.getText().toString(), et_password.getText().toString()));
                            db.close();
                            gotoLoginPage();
                        }
                        else{
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, "Email is already taken" , duration);
                            toast.show();
                        }
                    }
                }
            }
        });

    }

    //LINK THE REGISTRATION PAGE TO THE LOGIN PAGE THROUGH THE BUTTON
    private void gotoLoginPage() {
        Intent name = new Intent(this, Login.class);
        startActivity(name);
    }

    //CHECKS IF THE TEXT BOX IS EMPTY OR NOT
    public boolean isEmpty(EditText edittext) {

        String message;
        String hint =  edittext.getHint().toString();
        switch (hint){
            case "Name":
                message = "Enter a name";
                break;
            case "Password":
                message = "Enter a password";
                break;
            case "Username":
                message = "Enter a username";
                break;
            case "Email":
                message = "Enter an email address";
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

}



