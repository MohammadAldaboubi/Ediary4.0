package barryalan.ediary10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**+
 * Created by Al on 9/20/2017.
 */

public class testDatabase extends AppCompatActivity{

    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        //CREATE A NEW INSTANCE OF THE DATABASE FOR ACCESS
        LoginDatabaseHelper lbh = new LoginDatabaseHelper(this);

        //CREATE AND ADD A USER
        lbh.addUser(new User("kiffany", "kiffacy@data.com", "workorbust"));

        //FILL A LIST WITH ALL THE USERS ON THE DATABASE
        List<User> users = lbh.getUsers();

        //ITERATE THROUGH THE LIST OF USERS TO GET THEIR INFO INTO TEX STRING
        for(User u: users)
        {
            String log = "ID:" + u.getId() + ", Name: " + u.getUserName() + ", Email " + u.getUserEmail() + " ,Password " + u.getuserPassword() + "\n";
            text = text + log;
        }

    }
}
