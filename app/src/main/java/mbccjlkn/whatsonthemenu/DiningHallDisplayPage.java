package mbccjlkn.whatsonthemenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DiningHallDisplayPage extends AppCompatActivity {

    DBAccess db = MainActivity.dba;
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_display_page);
        menu = (Button) findViewById(R.id.menuBTN);

        final Bundle extras = getIntent().getExtras();
        int current = extras.getInt("id");
        ArrayList<String> list = db.viewEatery(extras.getInt("id"));

        ImageView imageView = findViewById(R.id.dhImage);
        AssetManager assetManager = getAssets();
        String file = "images/img"+current+".jpg";

        InputStream is = null;
        try {
            is = assetManager.open(file);
            Drawable d = Drawable.createFromStream(is, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }


            SharedPreferences sp = this.getSharedPreferences("WOTM", Context.MODE_PRIVATE);
            String spText = sp.getString("Info", "");
            FloatingActionButton fab = findViewById(R.id.fab2);
            ArrayList<Integer> Fav = new ArrayList<Integer>();

            String[] savedIds;
            if (spText.equals(""))
                savedIds = new String[0];
            else
                savedIds = spText.split("-");

            if (savedIds.length > 0)
                for (int i = 0; i < savedIds.length; i++)
                    Fav.add(Integer.parseInt(savedIds[i]));

            if (Fav.contains((Integer) getIntent().getExtras().getInt("id"))) {
                fab.setImageResource(R.drawable.ic_star_favorited);
            } else {
                fab.setImageResource(R.drawable.ic_star_unfavorited);
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
        SharedPreferences sp = this.getSharedPreferences("WOTM", Context.MODE_PRIVATE);
        String spText = sp.getString("Info", "");
        FloatingActionButton fab = findViewById(R.id.fab2);
        ArrayList<Integer> Fav = new ArrayList<Integer>();

        String[] savedIds;
        if (spText.equals(""))
            savedIds = new String[0];
        else {
            savedIds = spText.split("-");
            for (int i = 0; i < savedIds.length; i++)
                Fav.add(Integer.parseInt(savedIds[i]));
        }

        if (savedIds.length == 0){
            Log.d("Test", "Here");
            Fav.add((Integer) getIntent().getExtras().getInt("id"));
            fab.setImageResource(R.drawable.ic_star_favorited);
            Toast.makeText(getApplicationContext(), "Favorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
        } else /* savedIds.length > 0 */{
            // If this eatery is already favorited
            if (Fav.contains((Integer) getIntent().getExtras().getInt("id"))) {
                Toast.makeText(getApplicationContext(), "Unfavorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
                for (int i = 0; i < Fav.size(); i++) {
                    if (Fav.get(i) == (Integer) getIntent().getExtras().getInt("id")) {
                        Fav.remove(i);
                        fab.setImageResource(R.drawable.ic_star_unfavorited);
                        break;
                    }
                }
                // If this eatery is not already favorited
            } else {
                Toast.makeText(getApplicationContext(), "Favorited: " + FavoritesSelection.eateryNames[((Integer) getIntent().getExtras().getInt("id")) - 1], Toast.LENGTH_SHORT).show();
                Boolean placed = false;

                for (int i = 0; i < Fav.size(); i++) {
                    if (Fav.get(i) > (Integer) getIntent().getExtras().getInt("id")) {
                        Fav.add(i, (Integer) getIntent().getExtras().getInt("id"));
                        placed = true;
                        break;
                    }
                }

                if (!placed) {
                    Fav.add((Integer) getIntent().getExtras().getInt("id"));
                }

                fab.setImageResource(R.drawable.ic_star_favorited);
            }
        }

        String toAdd = "";
        for (int i = 0; i < Fav.size(); i++){
            if (i == (Fav.size() - 1))
                toAdd += Fav.get(i);
            else
                toAdd += (Fav.get(i) + "-");
        }

        sp.edit().clear().commit();
        sp.edit().putString("Info", toAdd).apply();
    }
}