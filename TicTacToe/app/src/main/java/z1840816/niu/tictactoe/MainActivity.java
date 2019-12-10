package z1840816.niu.tictactoe;

/*****************************************************************************************
 CSCI 522 - Portfolio 11 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a Tic Tac Toe game where the layout is created programmatically.

 ***************************************************************************************/

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button [][] buttons;

    private TicTacToe game;

    private TextView gameStatus;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Create the TicTacToe gsme
        game = new TicTacToe();

        buildGUI();
    }//end onCreate

    public void buildGUI()
    {
        //Get the width of the screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize( size );

        //Calculate the width of 1/3 of the screen
        int width = size.x / TicTacToe.SIDE;

        //Create a gridLayout to hold the buttons for the game
        GridLayout gridLayout = new GridLayout(this);

        //Set the number of rows and columns for the grid
        //Version 4 - Update the number of rows to add to the game
        gridLayout.setRowCount(TicTacToe.SIDE + 1);
        gridLayout.setColumnCount(TicTacToe.SIDE);


        //Create the 2-dimensional array of buttons
        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];

        //Handle the Buttons
        ButtonHandler buttonHandler = new ButtonHandler();

        //Add the buttons to the grid layout
        for(int row = 0; row < TicTacToe.SIDE; row++)
            for (int col = 0; col < TicTacToe.SIDE; col++) {
                //Generate the buttons to go into the 2-D array of buttons
                buttons[row][col] = new Button(this);

                //Set the Text Size for the information on the button
                buttons[row][col].setTextSize((int) (width * 0.2));

                //Set the background color
                //buttons[row][col].setBackgroundColor(Color.WHITE);

                //Add the handler to the button
                buttons[row][col].setOnClickListener(buttonHandler);

                //Add the button to the grid layout
                gridLayout.addView(buttons[row][col], width, width); //To get a square
            }

            //Create the TextView
            gameStatus = new TextView(this);

            //Set the size for the TextView(specifications)
            GridLayout.Spec rowSpec = GridLayout.spec(TicTacToe.SIDE, 1),
                    colSpec = GridLayout.spec(0, TicTacToe.SIDE);

            GridLayout.LayoutParams layoutParamsStatus = new GridLayout.LayoutParams(rowSpec, colSpec);

            //Attach the layout parameters to the TextView
            gameStatus.setLayoutParams(layoutParamsStatus);

            //Create the width and height for the TextView
            gameStatus.setWidth(TicTacToe.SIDE * width);
            gameStatus.setHeight(width);

            //Centre the TextView
            gameStatus.setGravity(Gravity.CENTER);

            //Set the background colour
            gameStatus.setBackgroundColor(Color.MAGENTA);

            //set the text size in the TextView
            gameStatus.setTextSize((int)(width * 0.15));

            //put the text in the TextView
            gameStatus.setText(game.result());

            //add the TextView to the gridLayout
            gridLayout.addView(gameStatus);

            //Display the view on the screen
            setContentView(gridLayout);

    }//end buildGUI

    //The Button Handler
    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //Display a message to indicate what has been clicked
            Toast.makeText(MainActivity.this, "ButtonHandler onClick, view is " + v, Toast.LENGTH_SHORT).show();

            //Determine which button was clicked and update it
            for(int row = 0; row < TicTacToe.SIDE; row++)
                for (int col = 0; col < TicTacToe.SIDE; col++)
                {
                    if(v == buttons[row][col])
                    {
                        update(row, col);
                    }
                }

        }
    }//ButtonHandler

    public void update(int row, int column)
    {

        intent = getIntent();

        //Display a message
        Toast.makeText(this, "update: " + row + ", " + column, Toast.LENGTH_SHORT).show();

        //Put a symbol on the button that was clicked
        //buttons[row][column].setText("X");

        // Find the current player
        int currentPlayer = game.play(row, column);

        //Put X or O on the board based on the player
        if (currentPlayer == 1) {
            buttons[row][column].setTextColor(intent.getIntExtra("colorOfX", 0));
            buttons[row][column].setText(intent.getStringExtra("goingToPlay"));
        }
        else if (currentPlayer == 2) {
            buttons[row][column].setTextColor(intent.getIntExtra("colorOfO", 0));
            String decide = intent.getStringExtra("goingToPlay");
            if(decide.equals("X")) {
                buttons[row][column].setText("O");
            }
            else{
                buttons[row][column].setText("X");
            }
        }
        //Check if the game is over
        if(game.isGameOver())
        {
            //change the background color of the TextView
            gameStatus.setBackgroundColor(Color.CYAN);

            //update the message in the TextView
            gameStatus.setText(game.result());
            //Disable all the buttons
            enableButtons( false );

            //get a dialog box to display
            showNewGameDialog();
        }
    }//end update

    public void enableButtons( boolean enabled )
    {
        //enable or disable all of the buttons
        for(int row = 0; row < TicTacToe.SIDE; row++)
            for (int col = 0; col < TicTacToe.SIDE; col++)
            {
                buttons[row][col].setEnabled(enabled);
            }
    }//end enableButtons

    public void showNewGameDialog()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        //set the title and the message for the dialog box
        alert.setTitle("Tic Tac Toe");
        alert.setMessage("Do you want to play again?");

        //Create the positive message
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //reset the game
                game.resetGame();

                //re-enable the buttons on the game board
                enableButtons(true);

                //clear the Xs and Os from the button
                resetButtons();

                //change the textView background back to its original color
                gameStatus.setBackgroundColor(Color.MAGENTA);

                //update the text in the textView
                gameStatus.setText(game.result());
            }
        });

        //Create the negative message button
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //close the application
                MainActivity.this.finish();

            }
        });

        //display the dialog box
        alert.show();
    }//end showNewGameDialog

    public void resetButtons()
    {
        for(int row = 0; row<TicTacToe.SIDE;row++)
            for (int col = 0; col<TicTacToe.SIDE;col++)
                buttons[row][col].setText("");
    }//end resetButtons


}//end MainActivity
