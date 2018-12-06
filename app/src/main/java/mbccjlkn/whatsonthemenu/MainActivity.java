package mbccjlkn.whatsonthemenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static DBAccess dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dba = DBAccess.getInstance(this);
        dba.open();
        //dba.close();
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
        SharedPreferences sp = this.getSharedPreferences("WOTM", Context.MODE_PRIVATE);
        String spText = sp.getString("Info", "");
        ArrayList<Integer> Fav = new ArrayList<Integer>();

        String[] savedIds;
        if (spText.equals(""))
            savedIds = new String[0];
        else
            savedIds = spText.split("-");

        if(savedIds.length == 0)
            Toast.makeText(view.getContext(), "No Favorites To Display", Toast.LENGTH_LONG).show();
        else
            startActivity(new Intent(this, FavoritesSelection.class));
    }
}