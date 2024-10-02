package org.example.Moduuli6.Moduuli6_4.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.Moduuli6.Moduuli6_4.Model.Note;
import org.example.Moduuli6.Moduuli6_4.Model.Notebook;

public class NoteController {
    Notebook nb = new Notebook();

    @FXML
    private Button add;

    @FXML
    private TextField title;

    @FXML
    private TextArea content;

    @FXML
    private ListView<Label> items;

    public void addItem() {
        System.out.println("Add note");

        System.out.println(title.getText()+ content.getText());

        nb.addNote(title.getText(), content.getText());
        itemsList();
        title.clear();
        content.clear();
    }

    public void itemsList(){
        System.out.println("Show notes");
        System.out.println(nb.toString());
        ObservableList<Label> notes = FXCollections.observableArrayList();
        for (Note note : Notebook.getNotes()){

            Label l = new Label(note.toString());

            l.autosize();
            notes.add(l);
            items.setItems(notes);
        }

    }


}


