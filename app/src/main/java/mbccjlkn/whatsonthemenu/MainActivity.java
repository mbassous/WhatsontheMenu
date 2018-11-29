package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static DBAccess dba;

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

}
