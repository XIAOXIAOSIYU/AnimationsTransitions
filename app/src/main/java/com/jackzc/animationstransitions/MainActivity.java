package com.jackzc.animationstransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {

    ViewGroup mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (ViewGroup) findViewById(R.id.main_layout);
        mainLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButtons();
                        return true;
                    }
                }
        );
    }

    private void moveButtons() {

        View button = findViewById(R.id.button);
        ViewGroup group = (ViewGroup)findViewById(R.id.main_layout);
        TransitionManager.beginDelayedTransition(group);

        // 1. Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        button.setLayoutParams(positionRules);

        // 2. Change the size of the button
        ViewGroup.LayoutParams sizeRules = button.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        button.setLayoutParams(sizeRules);
    }
}
