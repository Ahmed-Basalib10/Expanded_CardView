package com.e.expandedcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private CardView cardView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout=(ConstraintLayout) findViewById(R.id.expandableView);
        cardView=(CardView) findViewById(R.id.cardview);
        button=(Button) findViewById(R.id.arrowBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(constraintLayout.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    constraintLayout.setVisibility(View.VISIBLE);
                    button.setBackgroundResource(R.drawable.ic_expand_less_24);
                }else{
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    constraintLayout.setVisibility(View.GONE);
                    button.setBackgroundResource(R.drawable.ic_expand_more_24);
                }
            }
        });
    }
}