/***************************************************************************
 * Instructor Name : Amy Byrnes
 *
 * ASSIGNMENT : 1 (Hello World !)
 *
 * Assignment Team Members : 1) Rahul Reddy Gopu (Z1839171)
 *                           2) Saran Kumar Reddy Padala (Z1840816)
 *
 * Assignment Due Date : Friday, February 8 on Blackboard by 11:59 PM
***************************************************************************/
package edu.niu.rahul.assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Assignment_1 extends Activity {

    private TextView messageTv;
    private Button switchBtn;

    private boolean isHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_1);

        //connect the objects on the screen with the variables in the java code
        messageTv = findViewById(R.id.messageBox);

        switchBtn = findViewById(R.id.switchButton);

        //Initialize the boolean variable
        isHello = true;

        //Handle the button click
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHello) {

                    //Chaneg the message to Good Bye
                    messageTv.setText(R.string.bye_str);

                    //Change the boolean variable
                    isHello = false;
                } else {

                    messageTv.setText(R.string.hello_str);
                    isHello = true;
                }
            }
        });



    }
}
     /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assignment_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/