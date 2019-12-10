package edu.niu.cs.z1839171.databaseandmenus;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**************************************************************************************************
 CSCI 522 - Portfolio 14 - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section      : 1
 TA           : Harshith Desamsetti

 Purpose: Design a simple database application that will act as a store of some type of product.
          The store will have the ability to add, delete, and update products.
          The application will also demonstrate the use of menus.

 *************************************************************************************************/

public class Candy
{
    private int id;
    private String name;
    private double price;

    public Candy( int newId, String newName, double newPrice )
    {
        setId( newId );
        setName( newName );
        setPrice( newPrice );
    }//end constructor

    //Getters
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }


    //Setters
    public void setId( int newId )
    {
        id = newId;
    }

    public void setName( String newName )
    {
        name = newName;
    }

    public void setPrice( double newPrice )
    {
        price = 0.00;
        if( newPrice >= 0.00 )
            price = newPrice;
    }


    //Method to make displaying a Candy object easier
    public String candyToString()
    {
        return id + " " + name + " " + price;
    }
}//end of Candy class
public ArrayList<Candy> selectAll() {
    //String for getting the information from the database
    String sqlQuery = "select * from " + TABLE_NAME;

    //Get the database with the information
    SQLiteDatabase database = getWriteDatabase();

    //Create the cursor with all of the database information
    Cursor cursor = database.rawQuery(sqlQuery, null);

    //Create the arrayList that will eventually be returned from the method
    ArrayList<Candy> candies = new ArrayList<>();

    //Loop that will transfer the information from cursor to arraylist
    while (cursor.moveToNext()) {
        Candy currentCandy = new Candy(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getDouble(2));

        //Put the candy object into the arraylist
        candies.add(currentCandy);
    }

    //close the database
    database.close();

    //return the array list
    return candies;

}//end selectAll