/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.model;

import com.mycompany.teacher.dao.Word_dao;
import com.mycompany.teacher.exsampl.Word;
import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author firsov
 */
public class ModelMain {
    
    private ArrayList<Word> arrayWord;
    
    public void fillModel(){
        Word_dao word_dao = new Word_dao();
        arrayWord = word_dao.getLessonLast();
    }
    
    public Word getElment(){
        Random random = new Random();
        return arrayWord.get(random.nextInt(arrayWord.size()));
    }
}
