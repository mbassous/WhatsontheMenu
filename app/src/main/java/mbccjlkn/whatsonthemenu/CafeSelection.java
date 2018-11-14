package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CafeSelection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_selection);
    }

    public void oakesCafe(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 5);
        startActivity(I);
    }

    public void collegeEight(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 4);
        startActivity(I);
    }
}
