package org.example.Moduuli6.Moduuli6_1.View;

import org.example.Moduuli6.Moduuli6_1.Controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.Moduuli6.Moduuli6_1.Model.Dictionary;

public class DictionaryView extends Application {
    DictionaryController dc = new DictionaryController(new Dictionary());


    Label addToDictionaryTitle = new Label("Add to dictionary");
    TextField wordInput = new TextField("Enter word here");
    TextField definitionInput = new TextField("Enter definition here");
    Button add = new Button("Add");
    Label addStatus = new Label("");

    TextField user = new TextField("Enter word here to search");
    Label dictionaryTitle = new Label("Dictionary");
    Label wordV = new Label("");
    Label word = new Label("Word: ");
    Label definitionV = new Label("");
    Label definition = new Label("Definition: ");
    Button search = new Button("Search");


    @Override
    public void start(Stage window) {

        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setWord(userInput());
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addNewWord(getNewWord(), getNewDefinition());
            }
        });



        AnchorPane comp = new AnchorPane();
        GridPane addGrid = new GridPane();
        GridPane results = new GridPane();
        results.add(dictionaryTitle,0,0);       addGrid.add(addToDictionaryTitle, 4, 0);
        results.add(user, 0, 1);                addGrid.add(wordInput, 4, 1);       addGrid.add(definitionInput, 5, 1);
        results.add(search, 1, 1);              addGrid.add(add, 4, 2);


        results.add(word,0,3);                  addGrid.add(addStatus, 4, 3);
        results.add(wordV, 0, 4);
        results.add(definition,1,3);
        results.add(definitionV, 1, 4);

        comp.getChildren().addAll(results, addGrid);

        AnchorPane.setTopAnchor(results, 1.0);
        AnchorPane.setLeftAnchor(results, 1.0);

        AnchorPane.setTopAnchor(addGrid, 1.0);
        AnchorPane.setRightAnchor(addGrid, 1.0);



        Scene view = new Scene(comp, 600,200);

        window.setTitle("Dictionary");
        window.setScene(view);
        window.show();


    }

    public void setWord(String word){
        word = word.toLowerCase();
        String wordC = dc.searchWord(word);

        if (wordC.equals("Please enter a word to search.") || wordC.equals("Word not found in the dictionary.")){
            this.wordV.setText(wordC);
            setDefinitionV("");

        }else{
            this.wordV.setText(word);
            setDefinitionV(wordC);
        }

    }

    public void addNewWord(String word, String def){
        word = word.toLowerCase();
        String check = dc.addWord(word, def);

        if (check.equals("Please enter a word and its meaning.")){
            this.addStatus.setText(check);

        }else{
            this.addStatus.setText(check);
        }
    }

    public void setDefinitionV(String word){
        this.definitionV.setText(word);
    }

    public String userInput(){
        return user.getText();

    }

    public String getNewWord(){
        return wordInput.getText();
    }
    public String getNewDefinition(){
        return definitionInput.getText();
    }

}
