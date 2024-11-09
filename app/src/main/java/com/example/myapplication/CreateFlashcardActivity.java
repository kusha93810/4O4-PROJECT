package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateFlashcardActivity extends AppCompatActivity {

    private EditText questionEditText;
    private EditText answerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flashcard);

        // Initialize UI elements
        questionEditText = findViewById(R.id.questionEditText);
        answerEditText = findViewById(R.id.answerEditText);

        // Handle save button click
        findViewById(R.id.saveFlashcardButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = questionEditText.getText().toString();
                String answer = answerEditText.getText().toString();

                if (!question.isEmpty() && !answer.isEmpty()) {
                    // Save the flashcard (this would typically involve saving to Firebase or local storage)
                    Toast.makeText(CreateFlashcardActivity.this, "Flashcard saved!", Toast.LENGTH_SHORT).show();
                    finish();  // Close this activity and return to HomeActivity
                } else {
                    Toast.makeText(CreateFlashcardActivity.this, "Please fill both fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
