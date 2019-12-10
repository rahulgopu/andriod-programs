package z1839489.niu.edu.praticeareas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private RadioGroup shapesGroup;

    private TextView calculateTV;

    static final int REQUEST_CODE = 13;

    String type ="NoSelection";


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapesGroup = findViewById(R.id.ButtonGroup);
        calculateTV = findViewById(R.id.AreaOf);

        shapesGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.SquareRButton: type= "square";
                                                break;
                    case R.id.RectangleRButton: type= "rectangle";
                                                break;
                    case R.id.CircleRButton:  type= "circle";
                                                 break;
                    case R.id.TriangleRButton: type= "triangle";
                                                break;

                }
            }
        });


    }//end onCreate

public void getArea(View view){

    Intent areaIntent;

    if(type.equals("square")){
        areaIntent = new Intent(MainActivity.this, Square.class);
        startActivityForResult(areaIntent,REQUEST_CODE);
    }else if(type.equals("rectangle")){
        areaIntent = new Intent(MainActivity.this, Rectangle.class);
        startActivityForResult(areaIntent,REQUEST_CODE);
    }else if(type.equals("circle")){
        areaIntent = new Intent(MainActivity.this, Circle.class);
        startActivityForResult(areaIntent,REQUEST_CODE);
    }else if(type.equals("triangle")){
        areaIntent = new Intent(MainActivity.this, Triangle.class);
        startActivityForResult(areaIntent,REQUEST_CODE);
    }else if(type.endsWith("NoSelection"))
    {
        Toast.makeText(view.getContext(),"Choose a option first",Toast.LENGTH_LONG).show();
    }

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        String returnedArea;

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            returnedArea = data.getStringExtra("area");

            calculateTV.setText("Area of "+ returnedArea);
        }
        }
}
