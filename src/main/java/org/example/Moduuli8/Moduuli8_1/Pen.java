package org.example.Moduuli8.Moduuli8_1;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color color;
    private boolean cap;

    public Pen(Color color){
        this.color = color;
        this.cap = true; // The pen starts with the cap on
    }

    public Pen(){
        this.color = Color.RED; // Default color is red
        this.cap = true; // The pen starts with the cap on
    }

    public String draw(){
        if (!cap) {
            return "Drawing " + color;
        } else {
            return "";
        }
    }

    public void capOff(){
        this.cap = false;
    }

    public void capOn(){
        this.cap = true;
    }

    public void changeColor(Color color){
        this.color = color;
    }
}
