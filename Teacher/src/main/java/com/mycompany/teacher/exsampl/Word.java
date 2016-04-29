/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

/**
 *
 * @author firsov
 */
public class Word implements Words{
    
    private String textWord;
    private String textTarnslate;

    
    public void setTextWord(String textWord) {
        this.textWord = textWord;
    }
    
    public void setTextTarnslate(String textTarnslate) {
        this.textTarnslate = textTarnslate;
    }

    @Override
    public String getWord() {
        return textWord;
    }

    @Override
    public String getTranslate() {
        return textTarnslate;
    }
    
}
