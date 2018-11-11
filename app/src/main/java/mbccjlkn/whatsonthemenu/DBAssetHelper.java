package mbccjlkn.whatsonthemenu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBAssetHelper extends SQLiteAssetHelper {
    SQLiteDatabase db;
    Context ctx;

    //Info
    private static final String DATABASE_NAME = "WOTM_DB";

    //Table Names
    private static final String TABLE_FOOD = "food_table";
    private static final String TABLE_EATERY = "eatery_table";

    //Version
    private static int DATABASE_VERSION = 1;

    //food_table columns
    private static final String KEY_FOOD_ID = "id";
    private static final String KEY_FOOD_LOCATION = "location";
    private static final String KEY_FOOD_NAME = "name";
    private static final String KEY_FOOD_PRICE = "price";
    private static final String KEY_FOOD_CATEGORY = "category";
    //private static final String KEY_FOOD_DESCRIPTION = "description";

    //eatery_table columns
    private static final String KEY_EATERY_ID = "id";
    private static final String KEY_EATERY_NAME = "name";
    private static final String KEY_EATERY_HOURS = "hours";
    private static final String KEY_EATERY_CARD = "card";
    private static final String KEY_EATERY_FLEXIS = "flexis";
    private static final String KEY_EATERY_FAVORITE = "favorite";
    public DBAssetHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;
    }
}
