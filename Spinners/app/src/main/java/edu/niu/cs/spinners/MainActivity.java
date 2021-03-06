package edu.niu.cs.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner xmlSpin, classSpin, listSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner populated by data from strings.xml file
        xmlSpin = findViewById(R.id.xmlSpinner);

        //Create the array adapter with the Information
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),
                                                                            R.array.SpinnerArray,
                                                                            R.layout.spinner_view);

        xmlSpin.setAdapter(adapter1);

        xmlSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection1;

                selection1 = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), "The selection is " + selection1, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Populate the spinner using information from a class
        classSpin = findViewById(R.id.classSpinner);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(),
                                                            R.layout.spinner_view,
                                                            SpinnerInfo.ValueArray);

        classSpin.setAdapter(adapter2);
        classSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection2;
                selection2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), "The second selection is " + selection2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner populated from a List object
        List<String> listValues = new ArrayList<>();

        listValues.add("Beer");
        listValues.add("Whisky");
        listValues.add("Wine");
        listValues.add("Vodka");
        listValues.add("Coca Cola");
        listValues.add("Thumps Up");
        listValues.add("Water");

        listSpin.findViewById(R.id.listSpinner);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getApplicationContext(),
                                                            R.layout.spinner_view,
                                                            listValues);

        listSpin.setAdapter(adapter3);

        listSpin.setOnItemSelectedListener(spinnerListener);
    }//end onCreate
    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selection3;
            selection3 = parent.getItemAtPosition(position).toString();

            Toast.makeText(getApplicationContext(), "The third selection is " + selection3, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}//end MainActivity
