package mbccjlkn.whatsonthemenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    static DBAccess db = MainActivity.dba;

    public static HashMap<String, List<String>> getData( int i) {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        ArrayList<String> foodlist = db.viewFood(i);

        expandableListDetail.put("ALL FOOD", foodlist);

        return expandableListDetail;
    }
}
