package mbccjlkn.whatsonthemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CafeDisplay extends AppCompatActivity {

    DBHelper db = MainActivity.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_display);

        db = new DBHelper(this, "", null, 1);


        Bundle extras = getIntent().getExtras();
        ArrayList<String> list = db.viewEatery(extras.getInt("id"));

        TextView title = findViewById(R.id.cafe_title);
        title.setText(list.get(0));

        TextView hours = findViewById(R.id.hour_details);
        hours.setText(list.get(1));

        String result = "";
        if (list.get(2).equals("1")) result = result.concat("Card ");
        if (list.get(3).equals("1")) result = result.concat("Flexis ");
        if (list.get(4).equals("1")) result = result.concat("Mealplan ");

        TextView payment = findViewById(R.id.payment_details);
        payment.setText(result);

        ArrayList<String> foodlist = db.viewFood(extras.getInt("id"));

        //show menu header if menu exists
        if (foodlist.size() > 0) {
            findViewById(R.id.menu_header).setVisibility(View.VISIBLE);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                foodlist);
        //configure list view
        ListView menu = (ListView) findViewById(R.id.menu_list);
        menu.setAdapter(adapter);


    }
}
