package mbccjlkn.whatsonthemenu;

import android.graphics.Color;
import android.widget.Button;

public class OpenClosedBehavior {

    //colors the button if its eatery is closed
    public static void colorClosed(Button b){
        if (eateryClosed(b)) {
            b.setTextColor(Color.RED);
        }
    }

    //check if eatery closed
    private static boolean eateryClosed(Button b){
        DBAccess db = MainActivity.dba;
        int id = Integer.parseInt(b.getTag().toString());
        return db.isClosed(id);
    }
}
