package barryalan.ediary10;


/**
 * Created by Matthew on 10/5/2017.
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

public class health_excercise extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    User User1 = new User();
    EditText allergies;
    EditText medication;
    EditText vitalSigns;
    EditText diet;
    EditText excercise;

//S MEANS SHOW IN TEXT VIEW
    TextView Sallergies;
    TextView Smedication;
    TextView SvitalSigns;
    TextView Sdiet;
    TextView Sexcercise;

    TextView username;
    Button save;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_excercise);

        //TEXT BOXES TO INPUT INFO
        allergies = (EditText) findViewById(R.id.et_Hallergies);
        medication = (EditText) findViewById(R.id.et_Hmedication);
        vitalSigns = (EditText) findViewById(R.id.et_HvitalSigns);
        diet = (EditText) findViewById(R.id.et_Hdiet);
        excercise = (EditText) findViewById(R.id.et_HexcersicePlan);

        //TEXT BOXES TO DISPLAY
        Sallergies = (TextView) findViewById(R.id.tv_Hallergies);
        Smedication = (TextView) findViewById(R.id.tv_Hmedication);
        SvitalSigns = (TextView) findViewById(R.id.tv_HvitalSigns);
        Sdiet = (TextView) findViewById(R.id.tv_Hdiet);
        Sexcercise = (TextView) findViewById(R.id.tv_Hexcercise);

        username = (TextView) findViewById(R.id.tv_Husername);

        //BUTTONS
        save = (Button) findViewById(R.id.btn_Hsave);
        edit = (Button) findViewById(R.id.btn_Hedit);

        //OPEN DATABASE
        final LoginDatabaseHelper db = new LoginDatabaseHelper(this);

        username.setText(User1.currentUserName);

        //IF SOMETHING IS DONE TO THE EDIT TEXT DISPLAY IT ON THE CORRESPONDING TEXT VIEW REAL TIME

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.getUser(User1.currentUserName).setUserAllergies(allergies.getText().toString());

                db.updateUser(db.getUser(User1.currentUserName));

                Sallergies.setText("Allergies \n" + db.getUser(User1.currentUserName).getUserAllergies());
                Smedication.setText("Medication \n" + medication.getText().toString());
                Sdiet.setText("Diet \n" + diet.getText().toString());
                Sexcercise.setText("Excercise \n" + excercise.getText().toString());
                SvitalSigns.setText("Vital Signs \n" + vitalSigns.getText().toString());

                Sallergies.setVisibility(View.VISIBLE);
                Smedication.setVisibility(View.VISIBLE);
                Sdiet.setVisibility(View.VISIBLE);
                Sexcercise.setVisibility(View.VISIBLE);
                SvitalSigns.setVisibility(View.VISIBLE);

                allergies.setVisibility(View.GONE);
                medication.setVisibility(View.GONE);
                diet.setVisibility(View.GONE);
                excercise.setVisibility(View.GONE);
                vitalSigns.setVisibility(View.GONE);

                save.setVisibility(View.GONE);
                edit.setVisibility(View.VISIBLE);
                //SAVE INFO TO DATABASE
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sallergies.setVisibility(View.INVISIBLE);
                Smedication.setVisibility(View.INVISIBLE);
                Sdiet.setVisibility(View.INVISIBLE);
                Sexcercise.setVisibility(View.INVISIBLE);
                SvitalSigns.setVisibility(View.INVISIBLE);

                allergies.setVisibility(View.VISIBLE);
                medication.setVisibility(View.VISIBLE);
                diet.setVisibility(View.VISIBLE);
                excercise.setVisibility(View.VISIBLE);
                vitalSigns.setVisibility(View.VISIBLE);

                save.setVisibility(View.VISIBLE);
                edit.setVisibility(View.INVISIBLE);
            }
        });
    }

    /*
     * Preparing the list data
     */
//    private void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");
//
//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
//    }

}