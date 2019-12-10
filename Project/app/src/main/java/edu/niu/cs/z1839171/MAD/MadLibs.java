package edu.niu.cs.z1839171.MAD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MadLibs extends AppCompatActivity {


    Button story1, story2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_libs);

        story1 = (Button)findViewById(R.id.story1);
        story2 = (Button)findViewById(R.id.story2);


        story1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MadLibs.this,story1.class));

            }
        });


        story2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MadLibs.this,story2.class));
            }
        });

        /*story3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MadLibs.this,story3.class));
            }
        });

        story4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MadLibs.this,story4.class));
            }
        });

        story5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MadLibs.this,story5.class));
            }
        });*/
    }
}
