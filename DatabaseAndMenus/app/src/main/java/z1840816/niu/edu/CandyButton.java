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

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class CandyButton extends AppCompatButton
{
    private Candy candy;

    public CandyButton(Context context, Candy newCandy)
    {
        super(context);
        candy = newCandy;
    }//end constructor

    public double getPrice()
    {
        return candy.getPrice();
    }
}//end CandyButton
