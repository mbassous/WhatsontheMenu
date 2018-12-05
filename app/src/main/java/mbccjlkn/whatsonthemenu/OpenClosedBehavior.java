package mbccjlkn.whatsonthemenu;

import android.graphics.Color;
import android.widget.Button;

import java.util.Random;

public class OpenClosedBehavior {

    //colors the button if its eatery is closed
    public static void colorClosed(Button b){
        if (eateryClosed(b)) {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            b.setTextColor(color);
        }
    }

    //check if eatery closed
    private static boolean eateryClosed(Button b){
        return false;
    }
}
