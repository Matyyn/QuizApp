package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextViewResult;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.Highscore);

        Button buttonStartingQuiz = findViewById(R.id.button);
        buttonStartingQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

        Button Instructions = findViewById(R.id.Instructions);
        Instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Instructions();
            }
        });
        Button Quit = findViewById(R.id.Exit);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void Instructions() {
        Intent intent = new Intent(MainActivity.this, Instructions.class);
        startActivity(intent);
    }

    private void startQuiz() {
        Intent intent = new Intent(MainActivity.this, ActivityQuiz.class);
        startActivityForResult(intent,1);
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                mTextViewResult.setText("Last Score: " + result);
            }
            if (resultCode == RESULT_CANCELED) {
                mTextViewResult.setText("Last Score: "+ 0);
            }
        }
    }
}