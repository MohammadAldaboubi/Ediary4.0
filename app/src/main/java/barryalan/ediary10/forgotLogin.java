package barryalan.ediary10;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class forgotLogin extends AppCompatActivity{

    Button btn_sendEmail;
    EditText et_username;
    EditText et_email;

    //EVERYTHING THAT HAPPENS IN FORGOT LOGIN PAGE RUNS FROM HERE-----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_login);

        btn_sendEmail = (Button) findViewById(R.id.btn_FsendEmail);
        et_username = (EditText) findViewById(R.id.et_Fusername);
        et_email = (EditText) findViewById(R.id.et_Femail);

        //CREATING A NEW INSTANCE OF THE DATABASE IN ORDER TO ACCESS IT
        final LoginDatabaseHelper lbh = new LoginDatabaseHelper(this);

        //IF THE BUTTON CALLED SEND EMAIL IS CLICKED
        btn_sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //IF YOU INPUTTED THE EMAIL IN THE FORGOT LOGIN PAGE
                //IF THE EMAIL ON THE TEXT BOX IS IN THE DATABASE
                if(lbh.isEmailTaken(et_email)) { //sends email to et_email.getText().toString()
                    Log.d("MARKER", "COMMENT"); //shows up on the android monitor down below on run time
                    //SEND EMAIL FROM HERE
                }
                //IF YOU INPUTTED THE USERNAME IN THE FORGOT LOGIN PAGE
                //IF THE USERNAME IS IN THE DATABASE
                else if(lbh.isUsernameTaken(et_username)){
                    Log.d("MARKER","COMMENT");//shows up on the android monitor down below on run time
                    //SEND EMAIL FROM HERE
                }

            }
        });
    }
}
