package mbccjlkn.whatsonthemenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

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
    private static final String KEY_EATERY_MEALS = "meals";
    private static final String KEY_EATERY_FAVORITE = "favorite";
    private static final String KEY_EATERY_PHONE = "phone_number";

    //Constructor
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Initialize food item table
        db.execSQL("create table " + TABLE_FOOD + "(" + KEY_FOOD_ID + " integer primary key, " + KEY_FOOD_LOCATION +
                " integer, " + KEY_FOOD_NAME + " String, " + KEY_FOOD_PRICE + " String, " + KEY_FOOD_CATEGORY + " String);");

        //Initialize eatery table
        db.execSQL("create table " + TABLE_EATERY + "("+KEY_EATERY_ID+" integer primary key, "+ KEY_EATERY_NAME+
                " String, "+KEY_EATERY_HOURS+" String, "+KEY_EATERY_CARD+" integer, "+KEY_EATERY_FLEXIS+
                " integer, "+KEY_EATERY_MEALS+" integer, "+KEY_EATERY_FAVORITE+" integer, "+KEY_EATERY_PHONE+" String);");

        Toast.makeText(ctx, "Database created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EATERY);
            DATABASE_VERSION ++;
            onCreate(db);
        }
    }


    public long insertFood(int location, String food, String price, String category){
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FOOD_LOCATION, location);
        contentValues.put(KEY_FOOD_NAME, food);
        contentValues.put(KEY_FOOD_PRICE, price);
        contentValues.put(KEY_FOOD_CATEGORY, category);
        return db.insert(TABLE_FOOD, null, contentValues);
    }


    public void insertEatery(String name, String hours, Integer card, Integer flexis, Integer meals, Integer favorite, String phone){
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_EATERY_NAME, name);
        contentValues.put(KEY_EATERY_HOURS, hours);
        contentValues.put(KEY_EATERY_CARD, card);
        contentValues.put(KEY_EATERY_FLEXIS, flexis);
        contentValues.put(KEY_EATERY_MEALS, meals);
        contentValues.put(KEY_EATERY_FAVORITE, favorite);
        contentValues.put(KEY_EATERY_PHONE, phone);
        db.insert(TABLE_EATERY, null, contentValues);

    }

    public ArrayList<String> viewFood(int location){
        db = getReadableDatabase();
        ArrayList<String> menu = new ArrayList<String>();
        String filters = "SELECT * FROM " + TABLE_FOOD + " WHERE " + KEY_FOOD_LOCATION + " = " + location + ";";
        Cursor cr = db.rawQuery(filters, null);

        int i = 0; // Variable to count where we
        while(cr.moveToNext()){
            String tempString = "";
            for(int j = 2; j < 4; j++) {
                tempString += cr.getString(j);

                if (j == 2) tempString += "\t\t";
            }
            menu.add(tempString);
            i++;
        }

        return menu;
    }

    public ArrayList<String> viewEatery(int row){
        db = getReadableDatabase();
        ArrayList<String> rowData = new ArrayList<String>();
        String filters = "select * from " + TABLE_EATERY + " where " + KEY_EATERY_ID + " = "+ row +";";
        Cursor cr = db.rawQuery(filters,null);

        StringBuilder sr = new StringBuilder();

        cr.moveToNext();

        for(int i = 1; i < 8; i++ ) {
            rowData.add(cr.getString(i));
        }

        Log.d("apples", sr.toString());
        //Toast.makeText(ctx, rowData.get(0), Toast.LENGTH_LONG).show();
        return rowData;
    }
}