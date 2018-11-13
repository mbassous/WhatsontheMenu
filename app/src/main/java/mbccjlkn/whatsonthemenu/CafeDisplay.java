package mbccjlkn.whatsonthemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class CafeDisplay extends AppCompatActivity {

    DBHelper db = MainActivity.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_display);

        db = new DBHelper(this, "", null, 1);

        ArrayList<String> list = db.viewEatery(5);

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


    }
}
