package edu.niu.cs.z1839171.databaseandmenus;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity
{
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        databaseManager = new DatabaseManager(this);
        updateView();
    }//end onCreate

    public void updateView()
    {

    }//end updateView

    private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkId)
        {
            databaseManager.deleteByID(checkId);
            Toast.makeText(DeleteActivity.this,"candy deleted", Toast.LENGTH_SHORT).show();

            updateView();
        }
    }//end RadioButtonHandler

}//end DeleteActivity

    /*In databsemanager class
public void deleteByID(int id)
{
    //Create a string with the sql command
    String sqlDelete = "delete from " + TABLE_NAME + " where " + ID + " = " + id;

    //Get the database
    SQLiteDatabase databse = getWritableDatabase();

    //delete the candy from the database
    database.execSQL(sqlDelete);

    //close the databse
    databse.close();
}//end deleteByID
*/