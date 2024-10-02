package org.example.Moduuli6.Moduuli6_4.Model;


public class Note {
    private String Tite;
    private String Content;

    public Note (String title, String content) {
        this.Tite = title;
        this.Content = content;
    }

    public String getTitle() {
        return this.Tite;
    }

    public String getContent() {
        return this.Content;
    }

    public void setTitle(String title) {
        this.Tite = title;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String toString() {
        return this.Tite + "\n" + this.Content + "\n";
    }
}
