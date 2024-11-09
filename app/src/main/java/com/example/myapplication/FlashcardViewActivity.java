package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FlashcardViewActivity extends AppCompatActivity {

    private TextView questionTextView;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard_view);

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView);
        answerTextView = findViewById(R.id.answerTextView);

        // Retrieve the flashcard data passed via Intent
        String question = getIntent().getStringExtra("question");
        String answer = getIntent().getStringExtra("answer");

        // Set the question and answer text
        questionTextView.setText(question);
        answerTextView.setText(answer);
    }
}
