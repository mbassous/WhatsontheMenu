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

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DBAccess(Context context) {
        this.openHelper = new DBHelper2(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DBAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DBAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public ArrayList<String> viewFood(int location) {

        ArrayList<String> menu = new ArrayList<String>();
        String filters = "SELECT * FROM Foods WHERE eateryID = " + location + ";";
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
