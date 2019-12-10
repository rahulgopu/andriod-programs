package edu.niu.cs.z1840816.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button csci240Btn,csci241Btn,backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        csci240Btn = (Button)findViewById(R.id.csci240);
        csci241Btn = (Button)findViewById(R.id.csci241);

        csci240Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Calculator240.class));
            }
        });


        csci241Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Calculator241.class));
            }
        });
    }

    public void goBack(View view)
    {
        finish();
    }
}
