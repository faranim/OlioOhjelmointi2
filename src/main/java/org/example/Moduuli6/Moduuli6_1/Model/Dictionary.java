package org.example.Moduuli6.Moduuli6_1.Model;


import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> dictionary = new HashMap<>();

    public Dictionary(){
        dictionary.put("hello", "a common greeting");
        dictionary.put("goodbye", "a common farewell");
    }

    public void addWord(String word, String definition){
        dictionary.put(word, definition);
    }

    public String getDefinition(String word){
        word = word.toLowerCase();
        return dictionary.get(word);
    }

}