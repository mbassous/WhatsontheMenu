package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FoodTruckSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck_selection);
    }

    @Override
    protected void onResume() {
        super.onResume();

        View vg = findViewById(android.R.id.content);
        ArrayList<View> allButtons = vg.getTouchables();

        for (View b: allButtons){
            OpenClosedBehavior.colorClosed((Button) b);
        }
    }

    public void openTruck(View view){
        int id = Integer.parseInt(view.getTag().toString());
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", id);
        startActivity(I);
    }

}
