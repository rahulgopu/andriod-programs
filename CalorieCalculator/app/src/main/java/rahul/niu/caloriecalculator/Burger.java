package rahul.niu.caloriecalculator;

public class Burger
{
    //constants
    static final int BEEF = 90,
                    TURKEY = 170,
                    VEGGIE = 150,
                    CHEDDAR = 113,
                    MOZZ = 78,
                    BACON = 86;

    //data members
    private int pattyCalories, cheeseCalories, baconCalories, sauceCalories;

    //Constructor


    public Burger()
    {
        pattyCalories = BEEF;
        cheeseCalories = 0;
        baconCalories = 0;
        sauceCalories = 0;
    }//end constructor


    //set methods


    public void setPattyCalories(int newCalories) {
        pattyCalories = newCalories;
    }

    public void setCheeseCalories(int newCalories) {
        cheeseCalories = newCalories;
    }

    public void setBaconCalories(boolean hasBacon) {
        if(hasBacon)
            baconCalories = BACON;
        else
            baconCalories=0;
    }

    public void setSauceCalories(int newCalories) {
        sauceCalories = newCalories;
    }


    //method to calculate total number of calories
    public int getTotalCalories()
    {
        return pattyCalories + cheeseCalories + baconCalories + sauceCalories;
    }//end getTotalCalories
}//end Burger Class
