package org.example.Moduuli6.Moduuli6_1.Controller;


import org.example.Moduuli6.Moduuli6_1.Model.Dictionary;

public class DictionaryController {

    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String searchWord(String word) {
        if (word.isEmpty()) {
            return ("Please enter a word to search.");

        }
        String meaning = dictionary.getDefinition(word);
        if (meaning == null) {
            return ("Word not found in the dictionary.");
        }
        else{
            return meaning;
        }

    }

    public String addWord(String word, String meaning) {
        if (word.isEmpty() || meaning.isEmpty()) {
            return ("Please enter a word and its meaning.");
        }
        else {
            dictionary.addWord(word, meaning);
            return ("Word added to the dictionary.");
        }
    }
}