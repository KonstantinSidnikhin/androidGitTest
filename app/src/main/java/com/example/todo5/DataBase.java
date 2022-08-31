package com.example.todo5;

import java.util.ArrayList;
import java.util.Random;

public class DataBase {
private static DataBase instance = null;
public static DataBase getInstance(){
    if(instance == null){
        instance =new DataBase();
    }
    return instance;
}
    private ArrayList<Note> notes = new ArrayList<>();
    public DataBase() {

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Note note = new Note(i, "note :" + i, random.nextInt(3));
            notes.add(note);
        }

    }
    public void addNote(Note note){
        notes.add(note);
    }
    public void removeNote(int id){
        for (Note note : notes){
            if (note.getId()==id){
                notes.remove(note);
            }
        }
    }
    public ArrayList<Note>getNotes(){
        return new ArrayList<>(notes);
    }
}

