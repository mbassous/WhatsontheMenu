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
  
    public void bananaJoes(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 4);
        startActivity(I);
    }

    public void bowls(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 5);
        startActivity(I);
    }

    public void collegeEight(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 6);
        startActivity(I);
    }

    public void cowellCafe(View view) {
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 7);
        startActivity(I);
    }

    public void expressStore(View view) {
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 8);
        startActivity(I);
    }

    public void globalVillage(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 9);
        startActivity(I);
    }

    public void iveta(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 10);
        startActivity(I);
    }

    public void kresgeCoop(View view) {
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 11);
        startActivity(I);
    }

    public void oakesCafe(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 12);
        startActivity(I);
    }

    public void owlsNest(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 13);
        startActivity(I);
    }

    public void perk1(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 14);
        startActivity(I);
    }

    public void perk2(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 15);
        startActivity(I);
    }

    public void perk3(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 16);
        startActivity(I);
    }

    public void perk4(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 17);
        startActivity(I);
    }

    public void stevensonCafe(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 18);
        startActivity(I);
    }

    public void terraFresca(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 19);
        startActivity(I);
    }

    public void vivas(View view){
        Intent I = new Intent(this, CafeDisplay.class);
        I.putExtra("id", 20);
        startActivity(I);
    }

}

