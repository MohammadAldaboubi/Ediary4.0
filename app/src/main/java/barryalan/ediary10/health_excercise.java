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


    EditText allergies;
    EditText medication;
    EditText vitalSigns;
    EditText diet;
    EditText excercise;

////    //S MEANS SHOW IN TEXT VIEW
//       TextView username = (TextView) findViewById(R.id.tv_Husername);

//    TextView Sallergies = (EditText) findViewById(R.id.tv_Hallergies);
//    TextView Smedication = (EditText) findViewById(R.id.tv_Hmedication);
//    TextView SvitalSigns = (EditText) findViewById(R.id.tv_HvitalSigns);
//    TextView Sdiet = (EditText) findViewById(R.id.tv_Hdiet);
//    TextView Sexcercise = (EditText) findViewById(R.id.tv_Hexcercise);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_excercise);

        allergies = (EditText) findViewById(R.id.et_Hallergies);
        medication = (EditText) findViewById(R.id.et_Hmedication);
        vitalSigns = (EditText) findViewById(R.id.et_HvitalSigns);
        diet = (EditText) findViewById(R.id.et_Hdiet);
        excercise = (EditText) findViewById(R.id.et_HexcersicePlan);

        //OPEN DATABASE
        final LoginDatabaseHelper db = new LoginDatabaseHelper(this);



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