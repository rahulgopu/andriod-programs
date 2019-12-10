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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper
    {
    private static final String DATABASE_NAME = "candyDB";
        private static final String TABLE_NAME = "candyTable";
        private static final String ID = "id";
        private static final String PRICE = "price";
        private static final String NAME = "name";

        private static final int DATABASE_VERSION = 1;

        public DatabaseManager(@Nullable Context context)
        {
            super(context, DATABASE_NAME,null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            //String that contains the SQL statement to create the database
            String sqlCreate = "create table " + TABLE_NAME
                    + "( " + ID + " integer primary key autoincrement, "
                    + NAME + " text, "
                    + PRICE + " real )";

            //Create the database
            db.execSQL(sqlCreate);
        }//end onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
        //String that drops the old table if it exists
        String sqlDrop = "drop table if exists " + TABLE_NAME;

        //Drop the old table
        db.execSQL(sqlDrop);

        //Re-create the table
        onCreate(db);
        }//end onUpgrade

     public void insert( Candy candy)
     {
     //Get the database
     SQLiteDatabase database = getWritableDatabase();

     //String to insert data into the database
     String sqlInsert = "insert into " + TABLE_NAME
                       + " values( null, '" + candy.getName() + "', "
                       + "'" + candy.getPrice() + "' )";

     //Insert the data into the database
         database.execSQL(sqlInsert);

         //Close the database
         database.close();
     }//end of insert

    public ArrayList<Candy> selectAll()
    {
     //Stirng for getting the information from the database
     String sqlQuery = "select * from " + TABLE_NAME;

     //Get the database with the information
     SQLiteDatabase database = getWritableDatabase();

     //Create the cursor with all the database information
        Cursor cursor = database.rawQuery(sqlQuery, null);

     //Create the arraylist that will be eventually returned from the method
     ArrayList<Candy> candies = new ArrayList<>();

     //loop that willtransferthe information from cursor to arraylist
        while (cursor.moveToNext())
        {
         Candy currentCandy = new Candy( Integer.parseInt(cursor.getString(0)),
                                                          cursor.getString(1),
                                                          cursor.getDouble(2));

         //put the candy object into the arraylist
            candies.add(currentCandy);
        }

    //close the database
        database.close();

        //return the arraylist
        return candies;
    } //end selectAll


    public void deleteByID(int id)
    {
     //String with the sql command
     String sqlDelete = "delete from " + TABLE_NAME + " where " + ID + " = " + id;

     //Get the database
        SQLiteDatabase database = getWritableDatabase();

        //delete the candy from the database
        database.execSQL(sqlDelete);

        //close the database
        database.close();
    }//end deleteByID

    public void updateById(int currentId, String newName, double newPrice)
    {
        //Get the database
        SQLiteDatabase database = getWritableDatabase();

        //String with the sql command
        String sqlUpdate = "update " + TABLE_NAME + " set " +
                                       NAME + " = '" + newName + "', " +
                                       PRICE + " = '" + newPrice + "'" +
                                        " where " + ID + " = " + currentId;

        //Update the database
        database.execSQL(sqlUpdate);

        //close the database
        database.close();
    }//end updateById

    public Candy selectById(int currentId)
    {
        //Get the database
        SQLiteDatabase database = getWritableDatabase();

        //String with sql commamnd
        String sqlQuery = " select * from " + TABLE_NAME
                          + " where " + ID + " = " + currentId;

        //Create a cursor to hold the retrieved information
        Cursor cursor = database.rawQuery(sqlQuery, null);

        //Create the candy object with the info
        Candy candy = null;
        if (cursor.moveToFirst())
        {
            candy = new Candy( Integer.parseInt(cursor.getString(0)),
                              cursor.getString(1),
                              cursor.getDouble(2));
        }

        return candy;
    }//end selectById

    }//end DatabaseManager
