package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DiningHallDisplayPage extends AppCompatActivity {

    DBAccess db = MainActivity.dba;
    ArrayList<Integer> Fav = MainActivity.Favorites;
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_display_page);
        menu = (Button) findViewById(R.id.menuBTN);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> list = db.viewEatery(extras.getInt("id"));

        FloatingActionButton fabtwo = findViewById(R.id.fab2);
        if (MainActivity.Favorites.contains((Integer) getIntent().getExtras().getInt("id"))){
            fabtwo.setImageResource(R.drawable.ic_star_favorited);
        } else {
            fabtwo.setImageResource(R.drawable.ic_star_unfavorited);
        }

        TextView title = findViewById(R.id.DH_title);
        title.setText(list.get(0));

        TextView hours = findViewById(R.id.hour_details);
        hours.setText(list.get(1));

        String result = "";
        if (list.get(2).equals("1")) result = result.concat("Card ");
        if (list.get(3).equals("1")) result = result.concat("Flexis ");
        if (list.get(4).equals("1")) result = result.concat("Mealplan ");

        if (result.isEmpty()) result = "Cash Only";

        TextView payment = findViewById(R.id.payment_details);
        payment.setText(result);

        TextView loc = findViewById(R.id.location);
        loc.setText(db.getLocation(extras.getInt("id")));

    }

    public void menu(View view){
        Bundle extras = getIntent().getExtras();
        String url = db.getURL(extras.getInt("id"));
        Intent I = new Intent(Intent.ACTION_VIEW);
        I.setData(Uri.parse(url));
        startActivity(I);
    }

    // favorite()
    // pre: none
    // post: if the eatery is unfavorited then this onClick will favorite it.
    //       if the eatery is favorited then this onClick will unfavorite it.
    public void favorite(View view) {

        FloatingActionButton fabtwo = findViewById(R.id.fab2);
        // If this eatery is already favorited
        if (Fav.contains((Integer) getIntent().getExtras().getInt("id"))){
            Toast.makeText(getApplicationContext(), "Unfavorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
            for (int i = 0; i < Fav.size(); i++){
                if (Fav.get(i) == (Integer) getIntent().getExtras().getInt("id")){
                    MainActivity.Favorites.remove(i);
                    fabtwo.setImageResource(R.drawable.ic_star_unfavorited);
                    //fab.setImageDrawable(R.drawable.btn_star_big_off);
                    //fab.setIcon(android.R.drawable.btn_star_big_off);
                    break;
                }
            }
            // If this eatery is not already favorited
        } else {
            Toast.makeText(getApplicationContext(), "Favorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
            Boolean placed = false;

            for (int i = 0; i < Fav.size(); i++){
                if (Fav.get(i) > (Integer) getIntent().getExtras().getInt("id")){
                    MainActivity.Favorites.add(i, (Integer) getIntent().getExtras().getInt("id"));
                    placed = true;
                    break;
                }
            }

            if (!placed){
                MainActivity.Favorites.add((Integer) getIntent().getExtras().getInt("id"));
            }

            fabtwo.setImageResource(R.drawable.ic_star_favorited);
        }
    }


}
