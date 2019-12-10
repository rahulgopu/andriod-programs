package rahul.niu.explicitintentwithreturn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends Activity
{
    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameET = findViewById(R.id.nameEditText);
    }//end onCreate

    //method to handle the button click
    public void goBack(View view)
    {
        String nameInput;

        //get the data from the edit text
        nameInput = nameET.getText().toString();

        //Get the intent that was used to get to NameActivity
        Intent intent;
        intent = getIntent();

        //put the name from edittext into the intent object
        intent.putExtra("nameID", nameInput);

        //set a good result
        ((Activity)view.getContext()).setResult(RESULT_OK,intent);

        //go back to MainActivity
        finish();
    }//end goBack



}
