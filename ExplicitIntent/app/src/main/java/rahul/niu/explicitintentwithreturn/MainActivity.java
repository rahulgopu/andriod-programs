package rahul.niu.explicitintentwithreturn;
/********************************************************************
 CSCI 522 - Portfolio 5 - Semester (Spring) Year - 2019

 Programmer(s): Manoj Veluru
 Section: 1
 TA: Harshith Desamsetti
 Date Due: 02/27/2019

 Purpose: An Explicit Intent to dail a number , open a browser, take a picture

 *********************************************************************/
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private TextView nameTV;

    static final int REQUEST_CODE = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTV = findViewById(R.id.nameTextView);
    }//end onCreate

    //handle button click
    public void getName(View view)
    {
        //create the intent to call NameActivity
        Intent nameIntent = new Intent(MainActivity.this, NameActivity.class);
        //startActivity();
        startActivityForResult(nameIntent, REQUEST_CODE);
    }//end getName

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String returnedName;

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            //retrieve the name from the intent
            returnedName = data.getStringExtra("nameID");

            //put the name in the textview
            nameTV.setText("Your name is "+ returnedName);
        }
    }//end onActivityResult
}//end MainActivity
