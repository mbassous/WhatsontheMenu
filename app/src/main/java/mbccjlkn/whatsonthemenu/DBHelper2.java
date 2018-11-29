package mbccjlkn.whatsonthemenu;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DBHelper2 extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "myDB";
    private static final int DATABASE_VERSION = 1;

    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}