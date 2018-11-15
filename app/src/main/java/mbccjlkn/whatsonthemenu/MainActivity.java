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
        initializeEateryTable();
        initializeFoodTable();
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

    // initializeEateryTable()
    // pre: none
    // post: adds specified eateries into TABLE_EATERY
    public void initializeEateryTable(){
        String[][] eateryInfo = new String[][] { {"1", "Cruz N'Gourmet", "Monday 11:45am - 2:00pm\nTuesday 11:45am - 2:00pm\nWednesday 11:45am - 2:00pm\nThursday 11:45am - 2:00pm\nFriday 11:45am - 2:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "(831) 251-2223"},
                {"2", "Drunk Monkey", "Switches Weekly\nM/W/F/ 11:30am - 2:00pm\nAnd Then\n T/TH 11:30am - 2:00pm", "0", "0", "0", "0", "(831) 818-9523"},
                {"3", "Raymonds Catering", "Monday Closed\nTuesday 12:00pm - 2:00pm\nWednesday 12:00pm - 2:00pm\nThursday 12:00pm - 2:00pm\nFriday12:00pm - 2:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "Phone Number: none"},
                {"6", "College Eight Cafe", "Monday 8:00am - 8:00pm\nTuesday 8:00am - 8:00pm\nWednesday 8:00am - 8:00pm\nThursday 8:00am - 8:00pm\nFriday 8:00am - 8:00pm\nSaturday Closed\nSunday Closed", "1", "1", "1", "0", "(831) 459-4567"},
                {"7", "Cowell College", "Monday 8:00am - 8:00pm\nTuesday 8:00am - 8:00pm\nWednesday 8:00am - 8:00pm\nThursday 8:00am - 8:00pm\nFriday 8:00am - 8:00pm\nSaturday 12:00pm - 5:00pm\nSunday 12:00pm - 5:00pm", "0", "0", "0", "0", "Phone Number: none"},
                {"8", "Express Store", "Monday 7:30am - 6:30pm\nTuesday 7:30am - 6:30pm\nWednesday 7:30am - 6:30pm\nThursday 7:30am - 6:30pm\nFriday 7:30am - 6:30pm\nSaturday 10:00am - 4:00pm\nSunday Closed", "1", "1", "0", "0", "(831) 555-5555"},
                {"11", "Kresge Co-op", "Monday 9:00am - 6:00pm\nTuesday 9:00am - 6:00pm\nWednesday 9:00am - 6:00pm\nThursday 9:00am - 6:00pm\nFriday 9:00am - 6:00pm\nSaturday Closed\nSunday Closed", "0", "0", "0", "0", "(831) 426-1506"},
                {"12", "Oakes Cafe", "Monday 8:30am - 10:00pm\nTuesday 8:30am - 10:00pm\nWednesday 8:30am - 10:00pm\nThursday 8:30am - 10:00pm\nFriday 8:30am - 5:00pm\nSaturday Closed\nSunday Closed", "1", "1", "1", "0", "(831) 459-2640"} };

        // insert eateries into TABLE_EATERY
        for(int i = 0; i < eateryInfo.length; i++){
            db.insertEatery(eateryInfo[i][1], eateryInfo[i][2], Integer.parseInt(eateryInfo[i][3]), Integer.parseInt(eateryInfo[i][4]), Integer.parseInt(eateryInfo[i][5]), Integer.parseInt(eateryInfo[i][6]), eateryInfo[i][7]);
        }
    }

    // initializeFoodTable()
    // pre: none
    // post: adds specified menu items into TABLE_FOOD
    public void initializeFoodTable(){
        String[][] foodInfo = new String[][]  {
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
                {"101","4","Cappuccino","$4.10", ""},
                {"102","4","Latte","$4.10", ""},
                {"103","4","Matcha Latte","$4.25", ""},
                {"104","4","Vanilla Latte","$4.75", ""},
                {"105","4","Caramel Latte","$4.60", ""},
                {"106","4","Mocha","$4.85", ""},
                {"107","4","Americano","$3.05", ""},
                {"108","4","Espresso","$2.85", ""},
                {"109","4","Coffee","$2.45", ""},
                {"110","4","Tea","$2.50", ""},
                {"111","4","Chai","$4.35", ""},
                {"112","4","Hot Chocolate","$3.75", ""},
                {"113","4","Italian Soda","$2.05", ""},
                {"114","4","Single Ice Cream","$4.00", ""},
                {"115","4","Double Ice Cream","$6.50", ""},
                {"116","4","Triple Ice Cream","$8.00", ""},
                {"117","4","Affogato","$5.00", ""},
                {"118","4","Milkshake","$6.50", ""},
                {"119","4","Ice Cream Float","$5.75", ""},
                {"120","4","Fruit Smoothies","$4.95", ""},
                {"121","4","Cafe Helados","$4.99", ""},


                //Oakes Cafe
                {"122","8","Classic Grilled Chicken Sandwich","$6.95", ""},
                {"123","8","Bacon Ranch Chicken Sandwich","$7.25", ""},
                {"124","8","Pesto Chicken Sandwich","$7.25", ""},
                {"125","8","Chipotle Bacon Chicken Sandwich", "$7.75", ""},
                {"126","8","Chicken Tender Sandwich", "$5.25", ""},
                {"127","8","Oakes Club Sub", "$6.49", ""},
                {"128","8","Bacon Lettuce and Tomato", "$4.75", ""},
                {"129","8","Grilled Cheese", "$4.25", ""},
                {"130","8","Grilled Bacon and Cheese", "$7.75", ""},
                {"131","8","Rice Bowl with Choice of Protein", "$6.75", ""},
                {"132","8","Bagel", "$1.65", ""},
                {"133","8","Bear Claw", "$2.50", ""},
                {"134","8","Brownie", "$7.75", ""},
                {"135","8","1 Cookie", "$1.95", ""},
                {"136","8","2 Cookies", "$2.95", ""},
                {"137","8","Plain Croissant", "$2.75", ""},
                {"138","8","Danish", "$7.75", ""},
                {"139","8","Donut", "$7.75", ""},
                {"140","8","Muffin", "$7.75", ""},
                {"141","8","Vegan Rasp Bar", "$2.25", ""},
                {"142","8","Scone", "$2.95", ""},
                {"143","8","Turnover", "$2.45", ""},
                {"144","8","The Classic Burger", "$6.00", ""},
                {"145","8","Cheese Burger", "$6.75", ""},
                {"146","8","Bacon Cheese Burger", "$7.25", ""},
                {"147","8","Double Cheese Burger", "$8.25", ""},
                {"148","8","Guacamole Burger", "$7.25", ""},
                {"149","8","Chicken Tenders", "$4.75", ""},
                {"150","8","French Fries", "$2.95", ""},
                {"151","8","Onion Rings", "$3.50", ""},
                {"152","8","Mozzarella Sticks", "$4.75", ""},
                {"153","8","Side Salad", "$2.25", ""},
                {"154","8","Garden Salad", "$5.25", ""},
                {"155","8","Garden Salad with Chicken", "$7.25", ""},
                {"156","8","Garden Salad with Tofu", "$7.25", ""},
                {"157","8","Caesar Salad", "$5.25", ""},
                {"158","8","Caesar Salad with Chicken", "$7.25", ""},
                {"159","8","Bagel Sandwich", "$5.25", ""},
                {"160","8","Natural Bridges", "$5.75", ""},
                //Add other version after ^^^
                {"161","8","Mavericks Scramble", "$7.75", ""},
                {"162","8","Manresa Breakfast Burrito", "$6.50", ""},
                {"163","8","French Toast Sticks", "$3.60", ""},
                {"164","8","Cheese Quesadilla", "$4.25", ""},
                {"165","8","Veggie Quesadilla", "$5.25", ""},
                {"166","8","Chicken Quesadilla", "$6.25", ""},
                {"167","8","Hummus Avocado Wrap", "$6.25", ""},
                {"168","8","Sundried Tomato Chicken Wrap", "$6.25", ""},
                {"169","8","Candy", "$1.39", ""},
                {"170","8","Cliff Bar", "$2.69", ""},
                //Drinks
                {"171","8","Organic Espresso", "$2.85", ""},
                {"172","8","Americano", "$3.05", ""},
                {"173","8","Cappuccino", "$4.10", ""},
                {"174","8","Latte", "$4.10", ""},
                {"175","8","Vanilla Latte", "$4.75", ""},
                {"176","8","Caramel Latte", "$4.60", ""},
                {"177","8","Matcha Latte", "$4.25", ""},
                {"178","8","Mocha", "$4.85", ""},
                {"179","8","Iced Coffee", "$3.00", ""},
                {"180","8","Fountain Drink", "$1.85", ""},
                {"181","8","Italian Soda", "$2.05", ""},
                {"182","8","Fruit Smoothies", "$4.95", ""},
                {"183","8","Fruit and Cream Smoothies", "$4.95", ""},
                {"184","8","Frappe Latte", "$4.95", ""},
                {"185","8","Acai Bowl", "$7.25", ""},
                {"186","8","Coconut Water", "$3.99", ""},
                {"187","8","Gatorade", "$1.79", ""},
                {"188","8","Yerba Mate", "$3.59", ""},
                {"189","8","Lipton", "$1.69", ""},
                {"190","8","Nestle Kwik", "$2.69", ""},
                {"191","8","Ocean Spray", "$1.89", ""},
                {"192","8","Pure Leaf", "$2.99", ""},
                {"193","8","Rockstar", "$3.29", ""},
                {"194","8","Soy Milk", "$1.79", ""},
                {"195","8","Starbucks", "$1.79", ""},
                {"196","8","Yogurts", "$2.21", ""},
                {"197","8","Naked Juice", "$3.99", ""},
                {"198","8","Forager Vegan Yogurt", "$2.75", ""},
                {"199","8","Double Shot Protein", "$4.29", ""},
                {"200","8","Starbucks Frappe", "$4.29", ""},
                {"201","8","Refresher", "$3.29", ""} };

        // insert food items into TABLE_FOOD
        for(int i = 0; i < foodInfo.length; i++){
            db.insertFood(Integer.parseInt(foodInfo[i][1]), foodInfo[i][2], foodInfo[i][3], foodInfo[i][4]);
        }
    }
}