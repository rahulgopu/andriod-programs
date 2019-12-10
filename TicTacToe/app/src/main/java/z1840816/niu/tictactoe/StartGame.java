package z1840816.niu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class StartGame extends AppCompatActivity {
    ConstraintLayout mLayout;
    int mDefaultColor;
    int colorX, colorO;
    TextView fP;
    String gtp;
    Button btnX, btnO, colX, colO, playerO, playerX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mLayout = (ConstraintLayout) findViewById(R.id.layout);
        //mDefaultColor = ContextCompat.getColor(StartGame.this, R.color.colorPrimary);
        btnX = (Button) findViewById(R.id.buttonX);
        btnO = (Button) findViewById(R.id.buttonO);
        colX = (Button) findViewById(R.id.clrX);
        colO = (Button) findViewById(R.id.clrO);
        playerO = (Button) findViewById(R.id.firstO);
        playerX = (Button) findViewById(R.id.firstX);
        fP = (TextView) findViewById(R.id.firstPlayerAns);

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPickerX();

            }
        });

        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPickerO();
            }
        });

        playerO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gtp = "O";
                playerO.setEnabled(false);
                playerX.setEnabled(false);
                fP.setText("O");
            }
        });
        playerX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gtp = "X";
                playerO.setEnabled(false);
                playerX.setEnabled(false);
                fP.setText("X");
            }
        });
    }

    public void openColorPickerO() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                colorO = color;
                colO.setBackgroundColor(color);
            }
        });
        colorPicker.show();
    }

    public void openColorPickerX() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                colorX = color;
                colX.setBackgroundColor(color);
            }
        });
        colorPicker.show();
    }

    public void playGame(View view)
    {

        //create the intent to call NameActivity
        Intent game = new Intent(StartGame.this, MainActivity.class);
        game.putExtra("colorOfX", colorX);
        game.putExtra("colorOfO", colorO);
        game.putExtra("goingToPlay", gtp);
        //startActivity();
        startActivity(game);
    }
}
