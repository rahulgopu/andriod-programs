package edu.niu.transitions;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end onCreate

    public void showAnswers(View view)
    {
        Intent answerIntent = new Intent(MainActivity.this, AnswerActivity.class);
        startActivity(answerIntent);
        overridePendingTransition(R.anim.answer_on, R.anim.question_off);
    }//end showAnswer

}//end MainActivity

