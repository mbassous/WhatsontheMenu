package mbccjlkn.whatsonthemenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    static DBAccess db = MainActivity.dba;

    public static HashMap<String, List<String>> getData( int i) {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        ArrayList<String> categories = db.getCategories(i);

        String temp;

        for(int j = 0; j < categories.size(); j++){
            temp = categories.get(j);
            expandableListDetail.put(temp, db.viewFood(i, temp));
        }

        return expandableListDetail;
    }
}
