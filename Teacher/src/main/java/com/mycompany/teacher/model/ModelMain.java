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
    private int index;
    
    public void fillModel(){
        Word_dao word_dao = new Word_dao();
        arrayWord = word_dao.getLessonLast();
    }
    
    public Word getElment(){
        if (0 < arrayWord.size()){
            Random random = new Random();
            index = random.nextInt(arrayWord.size());
        return arrayWord.get(index);
        }else{
            return  new Word();
        }
        
    }
}