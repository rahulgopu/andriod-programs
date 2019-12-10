package manojveluru.niu.shippingcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }//end onCreate

    //method to handle the button click
    public void goBack(View view)
    {
        //go back to the MainActivity
        finish();
    }//end goBack
}
