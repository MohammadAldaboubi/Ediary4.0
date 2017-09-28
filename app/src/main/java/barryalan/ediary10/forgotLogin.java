package barryalan.ediary10;



import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotLogin extends AppCompatActivity{

    Button btn_sendEmail;
    EditText et_username;
    EditText et_email;

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
                if(et_email.getText().toString()!= "") {
                    //sends email to et_email.getText().toString()
                }
                else{
                    String storedEmail = lbh.getUserEmail(et_email.getText().toString());
                    //sends email to storedEmail
                }
            }
        });
    }



    //first email
    protected void sendEmail(String destinationEmail, String subjectMessage, String bodyMessage ) {
        Log.i("Send email", "hi");
        String[] TO = {destinationEmail};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectMessage);
        emailIntent.putExtra(Intent.EXTRA_TEXT, bodyMessage);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Email sent", "bye");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(forgotLogin.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
