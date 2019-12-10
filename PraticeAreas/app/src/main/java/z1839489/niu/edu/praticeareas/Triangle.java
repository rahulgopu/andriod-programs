package z1839489.niu.edu.praticeareas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Triangle extends AppCompatActivity {
    private EditText baseET;
    private EditText heightET;
    private Double base,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        baseET = findViewById(R.id.baseEditText);
        heightET = findViewById((R.id.HeightEditText));
    }

    public void calculateArea(View view) {
        base = Double.parseDouble(baseET.getText().toString());
        height = Double.parseDouble(heightET.getText().toString());
        double area = 0.5*height*base;
        Intent intent;
        intent= getIntent();
        String covertArea = "triangle is "+area;
        intent.putExtra("area",covertArea);
        ((Activity)view.getContext()).setResult(RESULT_OK,intent);
        finish();

    }
}
