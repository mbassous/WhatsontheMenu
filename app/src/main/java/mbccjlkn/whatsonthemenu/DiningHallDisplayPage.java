package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DiningHallDisplayPage extends AppCompatActivity {

    DBAccess db = MainActivity.dba;
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_hall_display_page);
        menu = (Button) findViewById(R.id.menuBTN);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> list = db.viewEatery(extras.getInt("id"));

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

}
