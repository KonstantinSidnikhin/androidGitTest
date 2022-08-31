package com.example.todo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private FloatingActionButton floatingActionButton;
    private ArrayList<Note>notes = new ArrayList<>();
    private DataBase dataBase = DataBase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();



        showNotes();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = addNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }
    private void initViews(){
        linearLayout = findViewById(R.id.linearLayout);
        floatingActionButton = findViewById(R.id.buttonAction);
    }
    private void showNotes(){
    linearLayout.removeAllViews();
        for (Note note : dataBase.getNotes()){
            View view = getLayoutInflater().inflate(R.layout.note_item,linearLayout,false);
            TextView textViewNote = view.findViewById(R.id.textViewNoteItem);
            textViewNote.setText(note.getText());
            int colorResId;
            switch(note.getPriority()){
                case 0:
                    colorResId = android.R.color.holo_green_light;
                    break;
                case 1:
                    colorResId = android.R.color.holo_orange_light;
                    break;
                default:
                    colorResId = android.R.color.holo_red_light;
            }
            int  color = ContextCompat.getColor(this,colorResId);
            textViewNote.setBackgroundColor(color);
            linearLayout.addView(view);
        }
    }
}