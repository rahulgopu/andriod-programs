package edu.niu.scenes;

/********************************************************************
 CSCI 522 - Portfolio 9 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will demonstrate the use of scenes for an animated transition. This application
 will display a painting by revealing small portions of the painting at a time.

 *********************************************************************/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private ViewGroup paintingContainer;

    private Transition transition;

    private Scene activeScene, passiveScene1, passiveScene2, passiveScene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the ViewGroup and the RelativeLayout from activity_main.xml
        paintingContainer = findViewById(R.id.paintingLayout);

        //inflate the transition
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        //populate the scene objects
        activeScene = Scene.getSceneForLayout( paintingContainer, R.layout.scene1, this );

        passiveScene1 = Scene.getSceneForLayout( paintingContainer, R.layout.scene2, this );
        passiveScene2 = Scene.getSceneForLayout( paintingContainer, R.layout.scene3, this );
        passiveScene3 = Scene.getSceneForLayout( paintingContainer, R.layout.scene4, this );

        //Make the scene visible
        activeScene.enter();
    }//end onCreate


    public void changeScene(View view){

        Scene temp;

        temp = activeScene;
        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = temp;

        //Make the new activeScene visible
        TransitionManager.go(activeScene, transition);

    }
}//end MainActivity
