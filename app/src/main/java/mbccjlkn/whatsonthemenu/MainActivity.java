package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static DBAccess dba;
    public static ArrayList<Integer> Favorites = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dba = DBAccess.getInstance(this);
        dba.open();
        //ArrayList<String> list = dba.viewEatery(1);
        //Log.d("meme", list.get(1));
        //dba.close();
        //initializeEateryTable();
        //initializeFoodTable();
        Favorites.add(1);
        Favorites.add(2);
        Favorites.add(24);
        Favorites.add(23);

        if(Favorites.size() > 0)
            startActivity(new Intent(this, FavoritesSelection.class));

    }

    public void diningHall(View view){
        Intent I = new Intent(this, DiningHallSelection.class);
        startActivity(I);
    }

    public void cafe(View view){
        Intent I = new Intent(this, CafeSelection.class);
        startActivity(I);
    }

    public void foodTrucks(View view){
        Intent I = new Intent(this, FoodTruckSelection.class);
        startActivity(I);
    }

    public void favorites(View view){
        if(Favorites.size() == 0){
            Toast.makeText(view.getContext(), "No Favorites To Display", Toast.LENGTH_LONG).show();
        } else{
            Intent I = new Intent(this, FavoritesSelection.class);
            startActivity(I);
        }

    }






    // initializeEateryTable()
    // pre: none
    // post: adds specified eateries into TABLE_EATERY
}