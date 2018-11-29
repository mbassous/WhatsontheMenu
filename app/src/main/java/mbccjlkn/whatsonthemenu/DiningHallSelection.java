package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Display;

import android.view.View;

public class DiningHallSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_selection);
    }

    /*public void collegeTen(View view) {
        Intent I = new Intent(this, DHDisplay.class);
        I.putExtra("id", 21);
        startActivity(I);
    }

    public void cowell(View view) {
        Intent I = new Intent(this, DHDisplay.class);
        I.putExtra("id", 22);
        startActivity(I);
    }

    public void crown(View view) {
        Intent I = new Intent(this, DHDisplay.class);
        I.putExtra("id", 23);
        startActivity(I);
    }

    public void porter(View view) {
        Intent I = new Intent(this, DHDisplay.class);
        I.putExtra("id", 24);
        startActivity(I);
    }

    public void rachelCarson(View view) {
        Intent I = new Intent(this, DHDisplay.class);
        I.putExtra("id", 25);
        startActivity(I);
    }*/

}
