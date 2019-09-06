package edu.newhaven.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndResult extends AppCompatActivity {

        TextView mGrade, mFinalScore;
        Button mRetryButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_end_result);

            mGrade = findViewById(R.id.grade);
            mFinalScore =findViewById(R.id.outOf);
            mRetryButton =findViewById(R.id.retry);


            Bundle bundle = getIntent().getExtras();
            int score = bundle.getInt("finalScore");

            mFinalScore.setText("You scored " + score + " out of " + Geoquizz.questions.length);

            if (score == 4){
                mGrade.setText("Outstanding");
            }else if (score == 3){
                mGrade.setText("Good Work");
            }else {
                mGrade.setText("Try Again");
            }

            mRetryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(EndResult.this, QuizzActivity.class));
                    EndResult.this.finish();
                }
            });

        }
    }