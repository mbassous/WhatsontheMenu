package mbccjlkn.whatsonthemenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this, "WOTM_DB",null, 1);
        //initializeEateryTable();
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

        String[][] foodInfo = new String[][]  {

                // Sample Template
                // {"",""," ","$", ""},
                //Cruz N Gourmet
                {"1", "1", "Soft Drinks", "$1.00", ""},
                {"2", "1", "Sparkling Water", "$1.00", ""},
                {"3", "1", "Water", "$1.00", ""},
                {"4", "1", "Pellegrino", "$2.00", ""},
                {"5", "1", "Kern's Nectar", "$2.00", ""},
                {"6", "1", "Coconut Water", "$2.00", ""},
                {"7", "1", "AZ Tea", "$1.50", ""},
                {"8", "1", "Red Bull", "$3.00", ""},
                {"9", "1", "Panang Chicken Curry Rice Bowl", "$7.00", ""},
                {"10", "1", "Panang Chicken Curry Wrap", "$8.00", ""},
                {"11", "1", "Sweet Indonesian Pulled Pork Bowl", "$8.00", ""},
                {"12", "1", "Sweet Indonesian Pulled Pork Wrap", "$8.00", ""},
                {"13", "1", "Sweet Indonesian Pulled Pork Taco", "$3.00", ""},
                {"14", "1", "Southwest Grilled Chicken Burrito", "$7.00", ""},
                {"15", "1", "Southwest Grilled Chicken Bowl", "$7.00", ""},
                {"16", "1", "Southwest Grilled Chicken Taco", "$3.00", ""},
                {"17", "1", "Cowboy Taco", "$3.00", ""},
                {"18", "1", "Cowboy Wrap", "$7.00", ""},
                {"19", "1", "Cowboy Bowl", "$7.00", ""},
                {"20", "1", "Gourmet Turkey Burger", "$7.00", ""},
                {"21", "1", "Lousiana Hot Link", "$6.00", ""},
                {"22", "1", "Garden Burger", "$7.00", ""},
                {"23", "1", "Paneer Butter Masala Rice Bowl", "$7.00", ""},
                {"24", "1", "Paneer Butter Masala Wrap", "$8.00", ""},

                //Drunk Monkey
                {"25", "2", "Soy Braised Chicken Rice Bowl", "$11.00", ""},
                {"26", "2", "Red Ginger Beef Chicken Rice Bowl", "$11.00", ""},
                {"27", "2", "Sweet Pulled Pork Chicken Rice Bowl", "$11.00", ""},
                {"28", "2", "Yellow Curry Tofu Chicken Rice Bowl", "$11.00", ""},
                {"29", "2", "Soy Braised Chicken Sandwich", "$7.00", ""},
                {"30", "2", "Shredded Beef Sandwich", "$8.00", ""},
                {"31", "2", "Sweet Pulled Pork Sandwich", "$8.00", ""},
                {"32", "2", "Burger", "$7.00", ""},
                {"33", "2", "Baby Back Ribs", "$12.00", ""},
                {"34", "2", "Grilled NY Steak", "$12.00", ""},
                {"35", "2", "Soft Drinks", "$1.00", ""},
                {"36", "2", "Water", "$1.00", ""},
                {"37", "2", "Pelligrino", "$1.00", ""},
                {"38", "2", "Monster", "$3.00", ""},
                {"39", "2", "Kona Ice Coffee", "$3.00", ""},
                {"40", "2", "Soft Drinks", "$1.00", ""},
                {"41", "2", "Kona Ice Coffee", "$3.00", ""},
                {"42", "2", "Coconut Water", "$3.00", ""},
                {"43", "2", "La Croix", "$2.00", ""},

                //Raymond's Catering
                // Didn't add specific meats
                {"44", "3", "Basic Brekkie", "$5.00", ""},
                {"45", "3", "5-Speed", "$6.00", ""},
                {"46", "3", "Machaca", "$6.00", ""},
                {"47", "3", "Country", "$6.00", ""},
                {"48", "3", "Chorizo", "$6.00", ""},
                {"49", "3", "Ray's Special", "$5.50", ""},
                {"50", "3", "Chorizo and Egg", "$5.50", ""},
                {"51", "3", "Lousiana Hot Link", "$6.00", ""},
                {"52", "3", "Breakfast Taco", "$3.50", ""},
                {"53", "3", "Tacos", "$3.00", ""},
                {"54", "3", "Regular Burrito", "$5.50", ""},
                {"55", "3", "Burrito Supreme", "$6.50", ""},
                {"56", "3", "Bean and Cheese or Rice and Cheese Burrito", "$4.00", ""},
                {"57", "3", "Veggie Quesadilla", "$5.50", ""},
                {"58", "3", "Quesadilla ", "$6.50", ""},
                {"59", "3", "Torta", "$6.50", ""},
                {"60", "3", "Mexican Plat", "$7.00", ""},
                {"61", "3", "Combo Plate", "$7.00", ""},
                {"62", "3", "Rice and Beans", "$3.00", ""},
                {"63", "3", "Small Nachos", "$2.75", ""},
                {"64", "3", "Medium Nachos", "$3.75", ""},
                {"65", "3", "Large Nachos", "$4.75", ""},
                {"66", "3", "Small Nachos with Meat", "$4.25", ""},
                {"67", "3", "Medium Nachos with Meat", "$5.25", ""},
                {"68", "3", "Large Nachos with Meat", "$6.25", ""},
                {"69", "3", "Pork or Veggie Tamales Plate", "$6.00", ""},
                {"70", "3", "Chorizo", "$6.00", ""},
                {"71","3","CheeseBurger","$4.25", ""},
                {"72","3","Texas","$6.50", ""},
                {"73","3","California","$5.50", ""},
                {"74","3","Ortega","$5.00", ""},
                {"75","3","Hawaiian","$5.50", ""},
                {"76","3","LongHorn","$6.00", ""},
                {"77","3","Patty Melt","$6.00", ""},
                {"78","3","San Francisco","$6.00", ""},
                {"79","3","Turkey Burger","$5.50", ""},
                {"80","3","Garden Burger","$5.50", ""},
                {"81","3","Salmon Burger","$5.50", ""},
                {"82","3","Tuna Melt","$5.50", ""},
                {"83","3","Grilled Cheese","$4.00", ""},
                {"84","3","Hot Pastrami","$6.00", ""},
                {"85","3","Lousiana Hot Link Sandwich","$5.50", ""},
                {"86","3","Hot Dog","$3.50", ""},
                {"87","3","Steak Sandwich","$5.50", ""},
                {"88","3","Wild Bird Sandwich","$6.00", ""},
                {"89","3","Tuna Salad Sandwich","$5.50", ""},
                {"90","3","BLT","$5.50", ""},
                {"91","3","Veggie Sandwich","$5.00", ""},
                {"92","3","Peanut Butter and Jelly","$4.00", ""},
                {"93","3","Pastrami and Cheese or Ham and Cheese","$5.50", ""},
                {"94","3","Chicken Club","$6.50", ""},
                {"95","3","Salmon Burger","$5.50", ""},
                {"96","3","Hot Pastrami with cheese and onions","$6.50", ""},
                {"97","3","Steak Hoagie with cheese and onions","$6.50", ""},
                {"98","3","Lousiana Hot Link with cheese and onions","$5.50", ""},
                {"99","3","Friggin Beautiful Meatball Sub","$5.50", ""},
                {"100","3","Tamales Plate with rice and beans","$6.50", ""},

                //College 8 cafe
                //Note: did medium price for items
                {"101","6","Cappuccino","$4.10", ""},
                {"102","6","Latte","$4.10", ""},
                {"103","6","Matcha Latte","$4.25", ""},
                {"104","6","Vanilla Latte","$4.75", ""},
                {"105","6","Caramel Latte","$4.60", ""},
                {"106","6","Mocha","$4.85", ""},
                {"107","6","Americano","$3.05", ""},
                {"108","6","Espresso","$2.85", ""},
                {"109","6","Coffee","$2.45", ""},
                {"110","6","Tea","$2.50", ""},
                {"111","6","Chai","$4.35", ""},
                {"112","6","Hot Chocolate","$3.75", ""},
                {"113","6","Italian Soda","$2.05", ""},
                {"114","6","Single Ice Cream","$4.00", ""},
                {"115","6","Double Ice Cream","$6.50", ""},
                {"116","6","Triple Ice Cream","$8.00", ""},
                {"117","6","Affogato","$5.00", ""},
                {"118","6","Milkshake","$6.50", ""},
                {"119","6","Ice Cream Float","$5.75", ""},
                {"120","6","Fruit Smoothies","$4.95", ""},
                {"121","6","Cafe Helados","$4.99", ""},


                //Oakes Cafe
                {"122","12","Classic Grilled Chicken Sandwich","$6.95", ""},
                {"123","12","Bacon Ranch Chicken Sandwich","$7.25", ""},
                {"124","12","Pesto Chicken Sandwich","$7.25", ""},
                {"125","12","Chipotle Bacon Chicken Sandwich", "$7.75", ""},
                {"126","12","Chicken Tender Sandwich", "$5.25", ""},
                {"127","12","Oakes Club Sub", "$6.49", ""},
                {"128","12","Bacon Lettuce and Tomato", "$4.75", ""},
                {"129","12","Grilled Cheese", "$4.25", ""},
                {"130","12","Grilled Bacon and Cheese", "$7.75", ""},
                {"131","12","Rice Bowl with Choice of Protein", "$6.75", ""},
                {"132","12","Bagel", "$1.65", ""},
                {"133","12","Bear Claw", "$2.50", ""},
                {"134","12","Brownie", "$7.75", ""},
                {"135","12","1 Cookie", "$1.95", ""},
                {"136","12","2 Cookies", "$2.95", ""},
                {"137","12","Plain Croissant", "$2.75", ""},
                {"138","12","Danish", "$7.75", ""},
                {"139","12","Donut", "$7.75", ""},
                {"140","12","Muffin", "$7.75", ""},
                {"141","12","Vegan Rasp Bar", "$2.25", ""},
                {"142","12","Scone", "$2.95", ""},
                {"143","12","Turnover", "$2.45", ""},
                {"144","12","The Classic Burger", "$6.00", ""},
                {"145","12","Cheese Burger", "$6.75", ""},
                {"146","12","Bacon Cheese Burger", "$7.25", ""},
                {"147","12","Double Cheese Burger", "$8.25", ""},
                {"148","12","Guacamole Burger", "$7.25", ""},
                {"149","12","Chicken Tenders", "$4.75", ""},
                {"150","12","French Fries", "$2.95", ""},
                {"151","12","Onion Rings", "$3.50", ""},
                {"152","12","Mozzarella Sticks", "$4.75", ""},
                {"153","12","Side Salad", "$2.25", ""},
                {"154","12","Garden Salad", "$5.25", ""},
                {"155","12","Garden Salad with Chicken", "$7.25", ""},
                {"156","12","Garden Salad with Tofu", "$7.25", ""},
                {"157","12","Caesar Salad", "$5.25", ""},
                {"158","12","Caesar Salad with Chicken", "$7.25", ""},
                {"159","12","Bagel Sandwich", "$5.25", ""},
                {"160","12","Natural Bridges", "$5.75", ""},
                //Add other version after ^^^
                {"161","12","Mavericks Scramble", "$7.75", ""},
                {"162","12","Manresa Breakfast Burrito", "$6.50", ""},
                {"163","12","French Toast Sticks", "$3.60", ""},
                {"164","12","Cheese Quesadilla", "$4.25", ""},
                {"165","12","Veggie Quesadilla", "$5.25", ""},
                {"166","12","Chicken Quesadilla", "$6.25", ""},
                {"167","12","Hummus Avocado Wrap", "$6.25", ""},
                {"168","12","Sundried Tomato Chicken Wrap", "$6.25", ""},
                {"169","12","Candy", "$1.39", ""},
                {"170","12","Cliff Bar", "$2.69", ""},
                //Drinks
                {"171","12","Organic Espresso", "$2.85", ""},
                {"172","12","Americano", "$3.05", ""},
                {"173","12","Cappuccino", "$4.10", ""},
                {"174","12","Latte", "$4.10", ""},
                {"175","12","Vanilla Latte", "$4.75", ""},
                {"176","12","Caramel Latte", "$4.60", ""},
                {"177","12","Matcha Latte", "$4.25", ""},
                {"178","12","Mocha", "$4.85", ""},
                {"179","12","Iced Coffee", "$3.00", ""},
                {"180","12","Fountain Drink", "$1.85", ""},
                {"181","12","Italian Soda", "$2.05", ""},
                {"182","12","Fruit Smoothies", "$4.95", ""},
                {"183","12","Fruit and Cream Smoothies", "$4.95", ""},
                {"184","12","Frappe Latte", "$4.95", ""},
                {"185","12","Acai Bowl", "$7.25", ""},
                {"186","12","Coconut Water", "$3.99", ""},
                {"187","12","Gatorade", "$1.79", ""},
                {"188","12","Yerba Mate", "$3.59", ""},
                {"189","12","Lipton", "$1.69", ""},
                {"190","12","Nestle Kwik", "$2.69", ""},
                {"191","12","Ocean Spray", "$1.89", ""},
                {"192","12","Pure Leaf", "$2.99", ""},
                {"193","12","Rockstar", "$3.29", ""},
                {"194","12","Soy Milk", "$1.79", ""},
                {"195","12","Starbucks", "$1.79", ""},
                {"196","12","Yogurts", "$2.21", ""},
                {"197","12","Naked Juice", "$3.99", ""},
                {"198","12","Forager Vegan Yogurt", "$2.75", ""},
                {"199","12","Double Shot Protein", "$4.29", ""},
                {"200","12","Starbucks Frappe", "$4.29", ""},
                {"201","12","Refresher", "$3.29", ""},
        };


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

        //insert food items
        for(int i = 0; i < foodInfo.length; i++){
            db.insertFood(Integer.parseInt(foodInfo[i][1]), foodInfo[i][2], foodInfo[i][3], foodInfo[i][4]);
        }
    }
}
