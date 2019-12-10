package z1839489.niu.edu.praticeareas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Rectangle extends Activity {
    private EditText lengthET;
    private EditText breadthET;
    private Double length,breadth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        lengthET = findViewById(R.id.lengthEditText);
        breadthET = findViewById((R.id.breadthEditText));
    }

    public void calculateArea(View view) {

        if(lengthET.getText().toString().matches("")||breadthET.getText().toString().matches("")){
            Toast.makeText(view.getContext(),"Enter Values",Toast.LENGTH_LONG).show();
            return;
        }

        length = Double.parseDouble(lengthET.getText().toString());
        breadth = Double.parseDouble(breadthET.getText().toString());

        double area = length*breadth;

        Intent intent;
        intent= getIntent();

        String covertArea = "rectangle is "+area;
        intent.putExtra("area",covertArea);

        ((Activity)view.getContext()).setResult(RESULT_OK,intent);
        finish();

    }
}
