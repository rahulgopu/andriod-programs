/********************************************************************
 CSCI 522 - Portfolio 4b - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section: 1
 TA: Harshith Desamsetti

 Purpose: Calculates the Calories for the selected input such as burger and cheeses

 *********************************************************************/
package edu.niu.cs.implicit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView pictureTV;

    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureTV = findViewById(R.id.pictureImageView);
    }//end onCreate

    public void doBrowser(View View)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cs.niu.edu"));

        startActivity(browserIntent);
    }//end doBrowser

    public void doPhone(View View)
    {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8155938787"));

        startActivity(phoneIntent);

    }//end doPhone

    public void doPicture(View View)
    {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (pictureIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(pictureIntent, REQUEST_CODE);
        }
    }//end doPicture

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == REQUEST_CODE && resultCode == RESULT_OK )
        {
            //retrieve the image
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap)extras.get("data");

            //put the Bitmap into ImageView
            pictureTV.setImageBitmap(imageBitmap);
        }
    }
}//end MainActivity
