package z1839489.niu.edu.praticeareas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Square extends Activity {

    private EditText sideET;

    private Double side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        sideET = findViewById(R.id.radius);

    }

    public void calculateArea(View view) {

        side = Double.parseDouble(sideET.getText().toString());

        double area = side*side;

        Intent intent;
        intent= getIntent();

        String covertArea = "Square is "+area;
        intent.putExtra("area",covertArea);

        ((Activity)view.getContext()).setResult(RESULT_OK,intent);

        finish();

    }
}