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

    public void collegeEight(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 6);
        startActivity(I);
    }

    public void cowellCafe(View view) {
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 5);
        startActivity(I);
    }

    public void expressStore(View view) {
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 6);
        startActivity(I);
    }

    public void kresgeCoop(View view) {
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 7);
        startActivity(I);
    }

    public void oakesCafe(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 8);
        startActivity(I);
    }
}