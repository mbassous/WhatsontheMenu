package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class CafeSelection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_selection);
    }

    public void cafe(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        startActivity(I);
    }

    public void oakes(View view){
        Intent I = new Intent(this, OakesDisplay.class);
        startActivity(I);
    }
}
