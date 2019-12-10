package manojveluru.niu.spinners;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner xmlSpin, classSpin, listSpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner populated by data from strings.xml file
        xmlSpin = findViewById(R.id.xmlspinner);

        //create the array adapter with the information
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),
                                                                                    R.array.spinnerArray,
                                                                                    R.layout.spinner_view);

        xmlSpin.setAdapter(adapter1);

        xmlSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection1;

                selection1 = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),"The selection is"+selection1,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    //populate the spinner using information from a class
        classSpin = findViewById(R.id.classSpinner);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(),
                                                            R.layout.spinner_view,
                                                            SpinnerInfo.valueArray);

        classSpin.setAdapter(adapter2);
        classSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection2;
                selection2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),"The 2nd selection is "+selection2,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner populated from a List object

        List<String> listValues = new ArrayList<>();

        listValues.add("Wine");
        listValues.add("Beer");
        listValues.add("Vodka");
        listValues.add("Diet Pepsi");
        listValues.add("Water");

        listSpin = findViewById(R.id.listSpinner);
        ArrayAdapter<String> adapter3= new ArrayAdapter<>(getApplicationContext(),
                                                            R.layout.spinner_view,
                                                            listValues);

        listSpin.setAdapter(adapter3);

        listSpin.setOnItemSelectedListener(spinnerListener);
    }//end onCreate

    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
         String selection3;
         selection3 = parent.getItemAtPosition(position).toString();
         Toast.makeText(getApplicationContext(),"The 3rd selection is "+selection3,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}//end MainActivity
