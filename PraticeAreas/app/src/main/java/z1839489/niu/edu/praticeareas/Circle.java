package z1839489.niu.edu.praticeareas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Circle extends Activity {

    private EditText radiusET;
    private Double radius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        radiusET = findViewById(R.id.radius);

    }

    public void calculateArea(View view) {

        radius = Double.parseDouble(radiusET.getText().toString());
        double area = 3.14* radius*radius;

        Intent intent;
        intent= getIntent();

        String covertArea = "Circle is "+area;
        intent.putExtra("area",covertArea);

        ((Activity)view.getContext()).setResult(RESULT_OK,intent);

        finish();

    }
}
