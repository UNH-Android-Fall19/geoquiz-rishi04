package edu.newhaven.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class QuizzActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        mScoreView = findViewById(R.id.points);
        mImageView = findViewById(R.id.imageView);
        mQuestion = findViewById(R.id.question);
        mTrueButton = findViewById(R.id.trueButton);
        mFalseButton = findViewById(R.id.falseButton);

        updateQuestion();

        //Logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == Geoquizz.questions.length) {
                        Intent i = new Intent(QuizzActivity.this, EndResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizzActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionNumber == Geoquizz.questions.length) {
                        Intent i = new Intent(QuizzActivity.this, EndResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizzActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });


        //Logic for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mAnswer) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == Geoquizz.questions.length) {
                        Intent i = new Intent(QuizzActivity.this, EndResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizzActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (mQuestionNumber == Geoquizz.questions.length) {
                        Intent i = new Intent(QuizzActivity.this, EndResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizzActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

    }

    private void updateQuestion() {

        mImageView.setImageResource(Geoquizz.images[mQuestionNumber]);
        mQuestion.setText(Geoquizz.questions[mQuestionNumber]);
        mAnswer = Geoquizz.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}