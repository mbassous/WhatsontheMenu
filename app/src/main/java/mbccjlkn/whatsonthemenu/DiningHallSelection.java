package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiningHallSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_selection);
    }

    public void startDHActivity(View view){
        Intent I = new Intent(this, DHDisplay.class);
        startActivity(I);
    }


}
