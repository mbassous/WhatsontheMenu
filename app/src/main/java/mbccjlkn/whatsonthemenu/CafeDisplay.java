package mbccjlkn.whatsonthemenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CafeDisplay extends AppCompatActivity {

    DBAccess db = MainActivity.dba;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_display);

        Bundle extras = getIntent().getExtras();
        int current = extras.getInt("id");
        ArrayList<String> list = db.viewEatery(current);

        {
            SharedPreferences sp = this.getSharedPreferences("WOTM", Context.MODE_PRIVATE);
            String spText = sp.getString("Info", "");
            FloatingActionButton fab = findViewById(R.id.fab);
            ArrayList<Integer> Fav = new ArrayList<Integer>();

            String[] savedIds;
            if (spText.equals(""))
                savedIds = new String[0];
            else
                savedIds = spText.split("-");

            if (savedIds.length > 0)
                for (int i = 0; i < savedIds.length; i++)
                    Fav.add(Integer.parseInt(savedIds[i]));

            if (Fav.contains((Integer) getIntent().getExtras().getInt("id"))) {
                fab.setImageResource(R.drawable.ic_star_favorited);
            } else {
                fab.setImageResource(R.drawable.ic_star_unfavorited);
            }
        }

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData(current);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                /*Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();*/

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                // Here is where we would have detailed info about food items show up

                /*Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();*/
                return false;
            }
        });

        TextView title = findViewById(R.id.cafe_title);
        title.setText(list.get(0));

        TextView hours = findViewById(R.id.hour_details);

        hours.setText(list.get(1));

        String result = "";
        if (list.get(2).equals("1")) result = result.concat("Card ");
        if (list.get(3).equals("1")) result = result.concat("Flexis ");
        if (list.get(4).equals("1")) result = result.concat("Mealplan ");

        if (result.isEmpty()) result = "Cash Only";

        TextView payment = findViewById(R.id.payment_details);
        payment.setText(result);

        /////////////////////////////////////////////////

        findViewById(R.id.menu_header).setVisibility(View.VISIBLE);

        /*
        ArrayList<String> foodlist = db.viewFood(extras.getInt("id"), "ass");

        //show menu header if menu exists
        if (foodlist.size() > 0) {
            findViewById(R.id.menu_header).setVisibility(View.VISIBLE);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                foodlist);
        //configure list view
        //ListView menu = (ListView) findViewById(R.id.menu_list);
        //menu.setAdapter(adapter);


        */
        TextView loc = findViewById(R.id.location);
        loc.setText(db.getLocation(extras.getInt("id")));
    }

    // favorite()
    // pre: none
    // post: if the eatery is unfavorited then this onClick will favorite it.
    //       if the eatery is favorited then this onClick will unfavorite it.
    public void favorite(View view) {
        SharedPreferences sp = this.getSharedPreferences("WOTM", Context.MODE_PRIVATE);
        String spText = sp.getString("Info", "");
        FloatingActionButton fab = findViewById(R.id.fab);
        ArrayList<Integer> Fav = new ArrayList<Integer>();

        String[] savedIds;
        if (spText.equals(""))
            savedIds = new String[0];
        else {
            savedIds = spText.split("-");
            for (int i = 0; i < savedIds.length; i++)
                Fav.add(Integer.parseInt(savedIds[i]));
        }

        if (savedIds.length == 0){
            Log.d("Test", "Here");
            Fav.add((Integer) getIntent().getExtras().getInt("id"));
            fab.setImageResource(R.drawable.ic_star_favorited);
            Toast.makeText(getApplicationContext(), "Favorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
        } else /* savedIds.length > 0 */{
            // If this eatery is already favorited
            if (Fav.contains((Integer) getIntent().getExtras().getInt("id"))) {
                Toast.makeText(getApplicationContext(), "Unfavorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
                for (int i = 0; i < Fav.size(); i++) {
                    if (Fav.get(i) == (Integer) getIntent().getExtras().getInt("id")) {
                        Fav.remove(i);
                        fab.setImageResource(R.drawable.ic_star_unfavorited);
                        break;
                    }
                }
                // If this eatery is not already favorited
            } else {
                Toast.makeText(getApplicationContext(), "Favorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
                Boolean placed = false;

                for (int i = 0; i < Fav.size(); i++) {
                    if (Fav.get(i) > (Integer) getIntent().getExtras().getInt("id")) {
                        Fav.add(i, (Integer) getIntent().getExtras().getInt("id"));
                        placed = true;
                        break;
                    }
                }

                if (!placed) {
                    Fav.add((Integer) getIntent().getExtras().getInt("id"));
                }

                fab.setImageResource(R.drawable.ic_star_favorited);
            }
        }

        String toAdd = "";
        for (int i = 0; i < Fav.size(); i++){
            if (i == (Fav.size() - 1))
                toAdd += Fav.get(i);
            else
                toAdd += (Fav.get(i) + "-");
        }

        sp.edit().clear().commit();
        sp.edit().putString("Info", toAdd).apply();
    }
}