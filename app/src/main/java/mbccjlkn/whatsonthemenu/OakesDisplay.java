package mbccjlkn.whatsonthemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class OakesDisplay extends AppCompatActivity {

    DBHelper db = MainActivity.db;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oakes_display);
        tv = findViewById(R.id.tv);
        view();
    }

    public void view(){
        //String test = db.viewEatery(12).get(1);
        //tv.setText(test);
    }

}
