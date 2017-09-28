package barryalan.ediary10;

import android.widget.TextView;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class mock extends AppCompatActivity {

    TextView textView;

    String text ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView) findViewById(R.id.textView);



        LoginDatabaseHelper lbh = new LoginDatabaseHelper(this);

        //insert some new contact info

        //lbh.addUser(new User("kiffany", "kiffacy@data.com", "workorbust"));

        //read and display contact
        List<User> users = lbh.getUsers();

        for(User u: users)
        {
            String log = "ID:" + u.getId() + ", Name: " + u.getUserName() + ", Email " + u.getUserEmail() + " ,Password " + u.getuserPassword() + "\n";
            text = text + log;
        }

        textView.setText(text);

    }
}

