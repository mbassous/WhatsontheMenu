package mbccjlkn.whatsonthemenu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DBAccess instance;


    private DBAccess(Context context) {
        this.openHelper = new DBHelper2(context);
    }


    public static DBAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DBAccess(context);
        }
        return instance;
    }


    public void open() {
        this.database = openHelper.getWritableDatabase();
    }


    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public ArrayList<String> viewFood(int location, String cat) {

        ArrayList<String> menu = new ArrayList<String>();
        String filters = "SELECT * FROM Foods WHERE eateryID = " + location + " AND category = '" + cat + "';";

        Cursor cr = database.rawQuery(filters, null);

        int i = 0; // Variable to count where we
        while(cr.moveToNext()) {
            String tempString = "";
            for (int j = 2; j < 4; j++) {
                tempString += cr.getString(j);

                if (j == 2) tempString += "\t\t";
            }
            menu.add(tempString);
            i++;
        }

        return menu;
    }

    public ArrayList<String> getCategories(int location){
        ArrayList<String> cats = new ArrayList<String>();
        String filters = "SELECT DISTINCT category FROM Foods WHERE eateryID = "+location+";";
        Cursor cr = database.rawQuery(filters, null);

        while(cr.moveToNext()) {
            cats.add(cr.getString(0));
        }

        return cats;
    }

    public ArrayList<String> viewEatery(int row) {
        ArrayList<String> rowData = new ArrayList<String>();
        String filters = "SELECT * FROM Eateries WHERE id = " + row + ";";
        Cursor cr = database.rawQuery(filters, null);

        cr.moveToNext();

        for (int i = 1; i < 8; i++) {
            rowData.add(cr.getString(i));
        }
        return rowData;
    }
}
