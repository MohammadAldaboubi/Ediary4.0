package barryalan.ediary10;

/**
 * Created by MOHAMMAD on 10/26/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;


public class personal_goal extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    User User1 = new User();

    TextView short_term1;
    TextView short_term2;
    TextView short_term3;
    TextView short_term4;
    TextView long_term;
    TextView username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_goals);

        //TEXT BOXES TO INPUT INFO
        short_term1 = (TextView) findViewById(R.id.short_term1);
        short_term2 = (TextView) findViewById(R.id.short_term2);
        short_term3 = (TextView) findViewById(R.id.short_term3);
        short_term4 = (TextView) findViewById(R.id.short_term4);
        long_term = (TextView) findViewById(R.id.long_term);

        username = (TextView) findViewById(R.id.usernames);

        final LoginDatabaseHelper db = new LoginDatabaseHelper(this);

        username.setText(User1.currentUserName);

        //----------------------------------

        db.getUser(User1.currentUserName).setUserGoal1(short_term1.getText().toString());

        db.updateUser(db.getUser(User1.currentUserName));

        short_term1.setText("Goal1 \n" + db.getUser(User1.currentUserName).getUserGoal1()); //This line takes information from the database of the goal1 column and output it.
        short_term2.setText("Goal2 \n" + short_term2.getText().toString());
        short_term3.setText("Goal3 \n" + short_term3.getText().toString());
        short_term4.setText("Goal4 \n" + short_term4.getText().toString());
        long_term.setText("LongGoal \n" + long_term.getText().toString());

        short_term1.setVisibility(View.VISIBLE);
        short_term2.setVisibility(View.VISIBLE);
        short_term3.setVisibility(View.VISIBLE);
        short_term4.setVisibility(View.VISIBLE);
        long_term.setVisibility(View.VISIBLE);

    }
}
