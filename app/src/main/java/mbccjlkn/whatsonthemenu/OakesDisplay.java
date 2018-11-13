package mbccjlkn.whatsonthemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        String test = db.viewEatery(1);
        tv.setText(test);
    }

}
