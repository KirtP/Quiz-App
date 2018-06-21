package com.example.android.androidquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Instance variables
    final int[] earnPoint = new int[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Submit button is clicked
    public void submitQuiz(View view) {
        int score = calculateScore();
        toastGrade(score);

    }




    // Calculate score
    public int calculateScore() {
        // Score 0 for incorrect or 1 for correct for each question
        int score = 0;


        // Question 1
        RadioButton q1CorrectAnswer = (RadioButton) findViewById(R.id.radio_q1_optC);
        if (q1CorrectAnswer.isChecked()) {
            earnPoint[0] = 1;
            score++;

        }

        // Question 2
        RadioButton q2CorrectAnswer = (RadioButton) findViewById(R.id.radio_q2_optA);
        if (q1CorrectAnswer.isChecked()) {
            earnPoint[1] = 1;
            score++;
        }

        // Question 3
        RadioButton q3CorrectAnswer = (RadioButton) findViewById(R.id.radio_q3_optB);
        if (q1CorrectAnswer.isChecked()) {
            earnPoint[2] = 1;
            score++;

        }

        // Question 4
        CheckBox q4CorrectAnswer1 = (CheckBox) findViewById(R.id.checkbox_q4_opt1);
        CheckBox q4IncorrectAnswer2 = (CheckBox) findViewById(R.id.checkbox_q4_opt2);
        CheckBox q4IncorrectAnswer3 = (CheckBox) findViewById(R.id.checkbox_q4_opt3);
        CheckBox q4CorrectAnswer4 = (CheckBox) findViewById(R.id.checkbox_q4_opt4);
        if (q4CorrectAnswer1.isChecked() && q4CorrectAnswer4.isChecked() && !q4IncorrectAnswer2.isChecked() && !q4IncorrectAnswer3.isChecked()) {
            earnPoint[3] = 1;
            score++;
        }

        // Question 5
        EditText responseQ5 = (EditText) findViewById(R.id.text_input_q5);
        String response = responseQ5.getText().toString().trim();
        if (response.equalsIgnoreCase("Kotlin")) {
            earnPoint[4] = 1;
            score++;
        }
        return score;


    }


    // Displays a toast with the the score total
    private void toastGrade(Integer score) {
        Toast.makeText(this, "You scored " + score + " out of 5 points!", Toast.LENGTH_SHORT).show();


    }
}

