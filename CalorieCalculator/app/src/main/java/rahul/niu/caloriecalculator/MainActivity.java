package rahul.niu.caloriecalculator;

/********************************************************************
 CSCI 522 - Portfolio 3 - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section: 1
 TA: Harshith Desamsetti

 Purpose: Calculates the Calories for the selected input such as burger and cheeses

 *********************************************************************/
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup pattyRG, cheeseRG;
    private CheckBox baconCB;
    private SeekBar sauceSB;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variable to the objects on the screen
        pattyRG = findViewById(R.id.pattyRadioGroup);
        cheeseRG = findViewById(R.id.cheeseRadioGroup);

        baconCB = findViewById(R.id.baconCheckBox);

        sauceSB = findViewById(R.id.sauceSeekBar);

        caloriesTV = findViewById(R.id.calorieText);

        //create the burger
        burger = new Burger();

        displayCalories();

        //set up the named listener for the patty selection
        pattyRG.setOnCheckedChangeListener(pattyListener);

        //set up the anon. listener for the cheese selection
        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.noCheeseRadioButton:      burger.setCheeseCalories(0);
                                                        break;
                    case R.id.cheddaqrRadioButton:      burger.setCheeseCalories(Burger.CHEDDAR);
                                                        break;
                    case R.id.mozzarellaRadioButton:    burger.setCheeseCalories(Burger.MOZZ);
                                                        break;
                }
                displayCalories();
            }
        });

        //set up the named listener for the bacon checkbox
        baconCB.setOnClickListener(baconListener);

        //set up the named listener for the sauce seekbar
        sauceSB.setOnSeekBarChangeListener(sauceListener);

    }//end onCreate

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    };


    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
          if(((CheckBox) v).isChecked())
            {
              burger.setBaconCalories(true);
            }
          else
              {
                  burger.setBaconCalories(false);
              }

          displayCalories();
        }
    };


    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            switch (checkedId)
            {
                case R.id.beefRadioButton:      burger.setPattyCalories(Burger.BEEF);
                                                break;
                case R.id.turkeyRadioButton:    burger.setPattyCalories(Burger.TURKEY);
                                                break;
                case R.id.veggieRadioButton:    burger.setPattyCalories(Burger.VEGGIE);
                                                break;
            }
            displayCalories();

        }
    };
    private void displayCalories()
    {
        //build the string to be displayed
        String caloriesText = "Calories: " + burger.getTotalCalories();

        //display the string in the textview
        caloriesTV.setText(caloriesText);
    }//end displayCalories
}//end MainActivity
