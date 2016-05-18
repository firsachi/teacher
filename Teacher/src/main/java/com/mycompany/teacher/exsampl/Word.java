/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author firsov
 */
public class Word {
    
    private final int id;
    private String lesson;
    private final SimpleStringProperty word = new SimpleStringProperty("");
    private final SimpleStringProperty tarnslate = new SimpleStringProperty("");

    public Word() {
        this(0);
    }

    public Word(int id) {
        this.id = id;
    }
     
    public void setTextWord(String textWord) {
        this.word.set(textWord.toLowerCase());
    }
    
    public void setTextTarnslate(String textTarnslate) {
        this.tarnslate.set(textTarnslate.toLowerCase());
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public SimpleStringProperty getWordProperty() {
        return word;
    }

    public SimpleStringProperty getTarnslateprProperty() {
        return tarnslate;
    }

    public int getId() {
        return id;
    }
    
    public String getWord(){
        return word.get();
    }
    
    public String getTranslate(){
        return tarnslate.get();
    }

    public String getLesson() {
        return lesson;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.lesson);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.lesson, other.lesson)) {
            return false;
        }
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        if (!Objects.equals(this.tarnslate, other.tarnslate)) {
            return false;
        }
        return true;
    }
    
}
