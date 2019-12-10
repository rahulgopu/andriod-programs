package z1840816.niu.edu;

/**************************************************************************************************
 CSCI 522 - Portfolio 14 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple database application that will act as a store of some type of product.
 The store will have the ability to add, delete, and update products.
 The application will also demonstrate the use of menus

 **************************************************************************************************/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity
{
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        databaseManager = new DatabaseManager(this);
    }//end onCreate

  //Add Button
  public void insertCandy(View view)
  {
   //Get the info from the edittext fields
      EditText candyNameET = findViewById(R.id.nameEditText),
               priceET = findViewById(R.id.priceEditText);

      String nameStr = candyNameET.getText().toString(),
             priceStr = priceET.getText().toString();

      try
      {
       double price = Double.parseDouble(priceStr);

       //create the Candy object
       Candy candy = new Candy(0, nameStr, price);

       //insert the Candy object into the database
       databaseManager.insert(candy);

       Toast.makeText(this, "Candy: " + nameStr + " added to DB", Toast.LENGTH_SHORT).show();
      }
      catch (NumberFormatException nfe)
      {
       Toast.makeText(this, "Price error", Toast.LENGTH_SHORT).show();
      }

      ArrayList<Candy> candies = databaseManager.selectAll();
      for ( Candy candy : candies )
      {
      Toast.makeText(this, "The candy is " + candy.candyToString(), Toast.LENGTH_SHORT).show();
      }

    //clear the edittext fields
    candyNameET.setText("");
      priceET.setText("");
  } //end insertCandy

  //Back button
  public void goBack( View view)
  {
   finish();
  }  //end goBack

}//end InsertActivity
