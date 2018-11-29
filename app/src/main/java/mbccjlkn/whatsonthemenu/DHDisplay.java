package mbccjlkn.whatsonthemenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DHDisplay extends AppCompatActivity {

    public boolean fav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhdisplay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fav) {
                    Snackbar.make(view, "Added to favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fav = true;
                } else {
                    Snackbar.make(view, "Added to favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fav = false;
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
