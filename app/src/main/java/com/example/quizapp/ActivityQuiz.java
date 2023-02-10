package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class ActivityQuiz extends AppCompatActivity {
    private long backPressedTime;
    private static final long Countdown_in_millis = 30000;
    Button answer1, answer2, answer3, answer4;
    TextView Score, Questions, QuestionNumber, textViewCountdown;

    private Questions_portion myQuestions = new Questions_portion();
    private String mAnswer;
    private int mScore = 0;
    private int questionnumber = 1;
    private long timeleftinmillis = 180000;
    private CountDownTimer countDownTimer = new CountDownTimer(timeleftinmillis, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            timeleftinmillis = millisUntilFinished;
            updateCountDownText();
        }

        @Override
        public void onFinish() {
            timeleftinmillis = 0;
            QuizEnd();
            updateCountDownText();
        }
    }.start();

    Random r = new Random();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        answer1 = findViewById(R.id.button1);
        answer2 = findViewById(R.id.button2);
        answer3 = findViewById(R.id.button3);
        answer4 = findViewById(R.id.button4);
        QuestionNumber = findViewById(R.id.QuestionNumber);
        Score = findViewById(R.id.Score);
        Questions = findViewById(R.id.Question);
        Questions.setTextColor(Color.BLACK);
        textViewCountdown = findViewById(R.id.Timer);
        QuestionNumber.setText("Question: " + questionnumber);
        Score.setText("Score: " + mScore);

        UpdateQuestion(r.nextInt(myQuestions.myQuestions.length));
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                } else {
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText() == mAnswer) {
                    mScore++;
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                } else {
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText() == mAnswer) {
                    mScore++;
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                } else {
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText() == mAnswer) {
                    mScore++;
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                } else {
                    Score.setText("Score: " + mScore);
                    checkAnswer();
                }
            }
        });
    }

    private void UpdateQuestion(int num) {
        Questions.setText(myQuestions.Getquestion(num));
        answer1.setText(myQuestions.Getchoice1(num));
        answer2.setText(myQuestions.Getchoice2(num));
        answer3.setText(myQuestions.Getchoice3(num));
        answer4.setText(myQuestions.Getchoice4(num));

        mAnswer = myQuestions.GetCorrectAnswer(num);
        myQuestions.deleteChoice(num);
    }

    @SuppressLint(value = "SetTextI18n")
    private void checkAnswer() {

        if (questionnumber < 8) {
            UpdateQuestion(r.nextInt(myQuestions.myQuestions.length));
            ++questionnumber;
            QuestionNumber.setText("Question: " + questionnumber);
            timeleftinmillis = Countdown_in_millis;
        } else {
            QuizEnd();
        }
    }

    private void updateCountDownText() {
        int minutes = (int) (timeleftinmillis / 1000) / 60;
        int seconds = (int) (timeleftinmillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountdown.setText(timeFormatted);
        if (timeleftinmillis < 10000) {
            textViewCountdown.setTextColor(Color.RED);
        } else {
            textViewCountdown.setTextColor(Color.BLACK);
        }
    }

    private void QuizEnd() {
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(ActivityQuiz.this);
        builder.setMessage("Quiz Ended! Your Score is " + mScore + " points.");
        builder.setCancelable(false);
        builder
                .setNegativeButton(
                        "Exit",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                finish();
                            }
                        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        myQuestions.reset();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", mScore);
        setResult(RESULT_OK, resultIntent);

    }


    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            QuizEnd();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}


