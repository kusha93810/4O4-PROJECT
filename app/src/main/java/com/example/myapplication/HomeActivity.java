package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView flashcardRecyclerView;
    private FlashcardAdapter flashcardAdapter;
    private List<Flashcard> flashcardList;
    private FloatingActionButton addFlashcardFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize RecyclerView and FloatingActionButton
        flashcardRecyclerView = findViewById(R.id.flashcardRecyclerView);
        addFlashcardFab = findViewById(R.id.addFlashcardFab);

        // Load flashcards (for now, this is sample data)
        flashcardList = loadFlashcards();

        // Set up RecyclerView with adapter and layout manager
        flashcardAdapter = new FlashcardAdapter(flashcardList, this, new FlashcardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Flashcard flashcard) {
                // Handle click on flashcard
                Intent intent = new Intent(HomeActivity.this, FlashcardViewActivity.class);
                intent.putExtra("question", flashcard.getQuestion());
                intent.putExtra("answer", flashcard.getAnswer());
                startActivity(intent);
            }
        });
        flashcardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        flashcardRecyclerView.setAdapter(flashcardAdapter);

        // Set up the FloatingActionButton to navigate to CreateFlashcardActivity
        addFlashcardFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CreateFlashcardActivity to add a new flashcard
                startActivity(new Intent(HomeActivity.this, CreateFlashcardActivity.class));
            }
        });
    }

    // Load flashcards (for now, this is sample data)
    private List<Flashcard> loadFlashcards() {
        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("What is Android?", "A mobile operating system developed by Google."));
        flashcards.add(new Flashcard("What is Java?", "A high-level programming language."));
        // Add more flashcards or fetch from Firebase here
        return flashcards;
    }
}
