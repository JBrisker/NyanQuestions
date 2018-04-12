package com.example.android.nyanquestions;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int correctAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // method called when quiz is submitted to calculate
    public void submitScore(View view) {
        // get user name
        EditText nameField = findViewById(R.id.name_Field);
        String name = nameField.getText().toString();
        if (name.isEmpty() || name.length() == 0 || name.equals("") || name == null) {
            name = "Player 1";
        }

        // radio buttons set 1 check
        RadioButton answer1A = findViewById(R.id.q_OneA);// correct answer

        if (answer1A.isChecked()) {
            correctAnswers += 1;
        }
        //radio buttons for set 2
                RadioButton answer2B = findViewById(R.id.q_TwoB);// correct

        if (answer2B.isChecked()) {
            correctAnswers += 1;
        }
        // radio buttons set 3
        RadioButton answer3C = findViewById(R.id.q_ThreeC);// correct
        if (answer3C.isChecked()) {
            correctAnswers += 1;
        }
        // check boxes for set 4
        CheckBox answer4A = findViewById(R.id.q_FourA);//correct
        CheckBox answer4B = findViewById(R.id.q_FourB);
        CheckBox answer4C = findViewById(R.id.q_FourC);
        CheckBox answer4D = findViewById(R.id.q_FourD);//correct
        if ((answer4A.isChecked() && answer4D.isChecked()) && (!answer4B.isChecked() && !answer4C.isChecked())) {
            correctAnswers += 1;
        }
        // question 5 answer
        EditText answer5Field = findViewById(R.id.q_Five);
        String answer5 = answer5Field.getText().toString();
        if (answer5.equals("Felis Catus")) {
            correctAnswers += 1;
        }
        // check boxes for set 6
        CheckBox answer6A = findViewById(R.id.q_SixA);
        CheckBox answer6B = findViewById(R.id.q_SixB);
        CheckBox answer6C = findViewById(R.id.q_SixC);
        CheckBox answer6D = findViewById(R.id.q_SixD);
        if ((answer6A.isChecked() && answer6C.isChecked() && (answer6D.isChecked())) && (!answer6B.isChecked())) {
            correctAnswers += 1;
        }
        Toast.makeText(this, quizResult(name, correctAnswers), Toast.LENGTH_LONG).show();
        Button submit = findViewById(R.id.sub_But);
        submit.setEnabled(false);
    }

    private String quizResult(String name, int correctAnswers) {
        String results;
        if (correctAnswers == 6) {
            results = "Puuuurfection! " + name + " you answered " + correctAnswers + " out of 6 correct";
        } else if (correctAnswers > 4) {
            results = "Meowzah! Feline Job " + name + " you answered " + correctAnswers + " out of 6 correct";
        } else {
            results = "You must be kitten me " + name + ",  you answered " + correctAnswers + " out of 6 correct";
        }
        return results;
    }

}





