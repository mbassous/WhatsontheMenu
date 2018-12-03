package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;

import java.util.ArrayList;

public class FavoritesSelection extends AppCompatActivity {

    ArrayList<Integer> fav = MainActivity.Favorites;
    public int i;
    public static String[] eateryNames = { "Cruz N' Gourmet",
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

        LinearLayout ll = (LinearLayout)findViewById(R.id.FavLL);

        Button[] buttons = new Button[fav.size()];
        Space[] spaces = new Space[fav.size()];

        for (i = 0; i < buttons.length; i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    200);

            buttons[i] = new Button(this);
            buttons[i].setText(eateryNames[(fav.get(i) - 1)]);
            buttons[i].setTextSize(17);
            buttons[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            buttons[i].setBackgroundResource(R.drawable.rounded_button);
            buttons[i].setId(fav.get(i));
            ll.addView(buttons[i], params);

            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if ((int)view.getId() < 21){
                        Intent I = new Intent(FavoritesSelection.this, CafeDisplay.class);
                        I.putExtra("id", (int)view.getId());
                        startActivity(I);
                    } else {
                        Intent I = new Intent(FavoritesSelection.this, DiningHallDisplayPage.class);
                        I.putExtra("id", (int)view.getId());
                        startActivity(I);
                    }
                }
            });

            spaces[i] = new Space(this);
            spaces[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 40));

            ll.addView(spaces[i]);
        }
    }
}