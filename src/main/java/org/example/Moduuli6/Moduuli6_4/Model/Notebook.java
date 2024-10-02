package org.example.Moduuli6.Moduuli6_4.Model;

import java.util.ArrayList;

public class Notebook {

    private static ArrayList<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote (String title, String content) {
        this.notes.add(new Note (title, content));
    }

    public void removeNote (int index) {
        this.notes.remove(index);
    }

    public String getNote (int index) {
        return this.notes.get(index).toString();
    }

    public int getNoteCount() {
        return this.notes.size();
    }

    public void editNote (int index, String title, String content) {
        this.notes.get(index).setTitle(title);
        this.notes.get(index).setContent(content);
    }

    public static ArrayList<Note> getNotes() {
        return notes;
    }

    public String toString() {
        String result = "";
        for (Note note : notes) {
            result += note.toString() + "\n";
        }
        return result;
    }

}