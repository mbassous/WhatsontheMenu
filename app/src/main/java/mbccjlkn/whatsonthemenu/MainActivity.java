package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this, "WOTM_DB",null, 1);
        initializeEateryTable();
    }

    public void diningHall(View view){
        Intent I = new Intent(this, DiningHallSelection.class);
        startActivity(I);
    }

    public void cafe(View view){
        Intent I = new Intent(this, CafeSelection.class);
        startActivity(I);
    }

    public void foodTrucks(View view){
        Intent I = new Intent(this, FoodTruckSelection.class);
        startActivity(I);
    }

    public void map(View view){
        Intent I = new Intent(this, Map.class);
        startActivity(I);
    }

    public void initializeEateryTable(){
        String[][] eateryInfo = new String[][] { {"1", "Cruz N'Gourmet", "Monday 11:45am - 2:00pm\nTuesday 11:45am - 2:00pm\nWednesday 11:45am - 2:00pm\nThursday 11:45am - 2:00pm\nFriday 11:45am - 2:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "(831) 251-2223"},
                                                 {"2", "Drunk Monkey", "Switches Weekly\nM/W/F/ 11:30am - 2:00pm\nAnd Then\n T/TH 11:30am - 2:00pm", "0", "0", "0", "0", "(831) 818-9523"},
                                                 {"3", "Raymonds Catering", "Monday Closed\nTuesday 12:00pm - 2:00pm\nWednesday 12:00pm - 2:00pm\nThursday 12:00pm - 2:00pm\nFriday12:00pm - 2:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "phone"},
                                                 {"6", "College Eight Cafe", "Monday 8:00am - 8:00pm\nTuesday 8:00am - 8:00pm\nWednesday 8:00am - 8:00pm\nThursday 8:00am - 8:00pm\nFriday 8:00am - 8:00pm\nSaturday Closed\nSunday Closed", "1", "1", "1", "0", "(831) 459-4567"},
                                                 {"12", "Oakes Cafe", "Monday 8:30am - 10:00pm\nTuesday 8:30am - 10:00pm\nWednesday 8:30am - 10:00pm\nThursday 8:30am - 10:00pm\nFriday 8:30am - 5:00pm\nSaturday Closed\nSunday Closed", "1", "1", "1", "0", "(831) 459-2640"} };
        //Log.d("bananas", "initializeEateryTable:" + eateryInfo[0].length);
        //Log.d("bananas", "initializeEateryTable:" + eateryInfo[1].length);
        //Log.d("bananas", "initializeEateryTable:" + eateryInfo[2].length);
        //Log.d("bananas", "initializeEateryTable:" + eateryInfo[3].length);
        //Log.d("bananas", "initializeEateryTable:" + eateryInfo[4].length);
        //Log.d("bananas", "initializeEateryTable:" + eateryInfo[5].length);
        for(int i = 0; i < eateryInfo.length; i++){

            /*Log.d("bananas", "initializeEateryTable: Table Contents "/*+ eateryInfo[i].toString());
            if (i != 0) {
                Log.d("bananas", "initializeEateryTable: Table Contents "/*+ eateryInfo[i].toString());
                for (int j = 0; j < 8; j++) {
                    Log.d("bananas", "initializeEateryTable: " + j + " " + eateryInfo[i][j]   + eateryInfo[i].toString());
                }
            }
            */

            db.insertEatery(eateryInfo[i][1], eateryInfo[i][2], Integer.parseInt(eateryInfo[i][3]), Integer.parseInt(eateryInfo[i][4]), Integer.parseInt(eateryInfo[i][5]), Integer.parseInt(eateryInfo[i][6]), eateryInfo[i][7]);
        }

        db.viewEatery(2);
    }
}
