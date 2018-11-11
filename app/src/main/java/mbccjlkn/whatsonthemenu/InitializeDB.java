package mbccjlkn.whatsonthemenu;

import mbccjlkn.whatsonthemenu.DBHelper;
import mbccjlkn.whatsonthemenu.MainActivity;

public class InitializeDB {
    DBHelper db = MainActivity.db;

    public static void initializeFoodTable(){

    }

    public void initializeEateryTable(){
        String[][] eateryInfo = new String[][] { {"1", "Cruz N'Gourmet", "Monday 11:45am - 2:00pm\nTuesday 11:45am - 2:00pm\nWednesday 11:45am - 2:00pm\nThursday 11:45am - 2:00pm\nFriday 11:45am - 2:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "(831) 251-2223"},
                                                 {"2", "Drunk Monkey", "Switches Weekly\nM/W/F/ 11:30am - 2:00pm\nAnd Then\n T/TH 11:30am - 2:00pm", "0", "0", "0", "0", "(831) 818-9523"},
                                                 {"3", "Raymonds Catering", "Monday Closed\nTuesday 12:00pm - 2:00pm\nWednesday 12:00pm - 2:00pm\nThursday 12:00pm - 2:00pm\nFriday12:00pm - 2:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "phone"},
                                                 {"6", "College Eight Cafe", "Monday 8:00am - 8:00pm\nTuesday 8:00am - 8:00pm\nWednesday 8:00am - 8:00pm\nThursday 8:00am - 8:00pm\nFriday 8:00am - 8:00pm\nSaturday Closed\nSunday Closed", "1", "1", "1", "0", "(831) 459-4567"},
                                                 {"12", "Oakes Cafe", "Monday 8:30am - 10:00pm\nTuesday 8:30am - 10:00pm\nWednesday 8:30am - 10:00pm\nThursday 8:30am - 10:00pm\nFriday 8:30am - 5:00pm\nSaturday Closed\nSunday Closed", "1", "1", "1", "0", "(831) 459-2640"} };

        for(int i = 0; i < eateryInfo.length; i++){
            db.insertEatery(eateryInfo[i][1], eateryInfo[i][2], Integer.parseInt(eateryInfo[i][3]), Integer.parseInt(eateryInfo[i][4]), Integer.parseInt(eateryInfo[i][5]), Integer.parseInt(eateryInfo[i][6]), eateryInfo[i][7]);
        }
    }
}

