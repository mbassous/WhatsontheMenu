package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FoodTruckSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck_selection);
    }

    public void cruzNGourmet(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 1);
        startActivity(I);
    }

    public void drunkMonkey(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 2);
        startActivity(I);
    }

    public void raymondsCatering(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 3);
        startActivity(I);
    }

}
