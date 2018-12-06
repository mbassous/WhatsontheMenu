package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FavoritesSelection extends AppCompatActivity {

    ArrayList<Integer> fav = MainActivity.Favorites;
    public int i;
    public String[] eateryNames = { "Cruz N' Gourmet",
                                    "Drunk Monkey",
                                    "Raymond's Catering",
                                    "Banana Joe's (Crown)",
                                    "Bowls (Porter)",
                                    "College 8 Cafe",
                                    "Cowell Coffee Shop",
                                    "Express Store (Quarry)",
                                    "Global Village Cafe (Mchenry)",
                                    "Iveta (Quarry)",
                                    "Kresge Co-op",
                                    "Oakes Cafe",
                                    "Owl's Nest (Kresge)",
                                    "Perk Coffee (J Baskin)",
                                    "Perk Coffee (Earth and Marine)",
                                    "Perk Coffee (Physical Sciences)",
                                    "Perk Coffee (Terra Fresca)",
                                    "Stevenson Coffee House",
                                    "Terra Fresca (College 9/10)",
                                    "Vivas (Merrill)",
                                    "College 9/10",
                                    "Cowell/Stevenson",
                                    "Crown/Merrill",
                                    "Porter/Kresge",
                                    "Rachel Carson/Oakes" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_selection);

        ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.FavCL);
        LinearLayout ll = (LinearLayout)findViewById(R.id.FavLL);

        Button[] buttons = new Button[fav.size()];
        for (i = 0; i < buttons.length; i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            buttons[i] = new Button(this);
            buttons[i].setText(eateryNames[(fav.get(i) - 1)]);
            buttons[i].setTextSize(17);
            //buttons[i].setTextColor(024);
            //buttons[i].setLayoutParams(new LinearLayout.LayoutParams(300, 60));
            buttons[i].setWidth(300);
            buttons[i].setHeight(60);
            buttons[i].setBackgroundResource(R.drawable.rounded_button);
            buttons[i].setId(fav.get(i));
            //buttons[i].set
            cl.addView(buttons[i], params);

            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if ((int)view.getId() < 21){
                        Intent I = new Intent(FavoritesSelection.this, CafeDisplay.class);
                        I.putExtra("id", (int)view.getId());
                        startActivity(I);
                    } else {
                        /*Intent I = new Intent(FavoritesSelection.this, DiningHallDisplay.class);
                        I.putExtra("id", (int)view.getId());
                        startActivity(I);*/
                    }
                }
            });
        }



        /*


            for (int i = 1; i <= 20; i++) {
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    Button btn = new Button(this);
    btn.setId(i);
    final int id_ = btn.getId();
    btn.setText("button " + id_);
    btn.setBackgroundColor(Color.rgb(70, 80, 90));
    linear.addView(btn, params);
    btn1 = ((Button) findViewById(id_));
    btn1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                    "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                    .show();
        }
    });
}

         */
    }
}
