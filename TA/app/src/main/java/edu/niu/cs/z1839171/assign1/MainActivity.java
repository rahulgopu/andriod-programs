
package edu.niu.cs.z1839171.assign1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView messageTV;
    private boolean hello = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] message = {"Hello User", "Bye User"};

        //connect the variable to the objects on the screen
        messageTV = findViewById(R.id.MessageTextTView);
        messageTV.setText("Hello User");

        Button messageButton = (Button) findViewById(R.id.MessageButton);



        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hello){
                    //messageTV.setText("Bye User");
                    messageTV.setText(message[0]);
                    hello = false;
                } else {
                    //messageTV.setText("Hello User");
                    messageTV.setText(message[1]);
                    hello =true;
                }


            }
        });

    }
}