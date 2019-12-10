package saran.niu.intentsandwidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView titleTV, receipeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent;
        intent = getIntent();
        String returnedTitle;

        returnedTitle =intent.getStringExtra("nameID");
        int index = intent.getIntExtra("position",0);

        titleTV = findViewById(R.id.titleText);
        receipeTV = findViewById(R.id.scrollId);

        titleTV.setText(returnedTitle);
        String arr[] = getResources().getStringArray(R.array.receipeText);
        String i = arr[index];
        receipeTV.setText(i);
    }

    //method to handle the button click
    public void goBack(View view)
    {
        //go back to the MainActivity
        finish();
    }//end goBack


}
