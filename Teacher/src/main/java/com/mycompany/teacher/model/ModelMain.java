/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.model;

import com.mycompany.teacher.dao.Word_dao;
import com.mycompany.teacher.exsampl.Word;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author firsov
 */
public class ModelMain {
    
    private ArrayList<Word> arrayWord;
    private int index;
    private int counter = 0;
    
    public void fillModel(){
        counter++;
        Word_dao word_dao = new Word_dao();
        if ((counter & 1) == 0){
            arrayWord = word_dao.randomLesson();
        }else{
            arrayWord = word_dao.getLessonLast();
        }
    }
    
    public Word getElment(){
        if (1 == arrayWord.size()){
            Word word = arrayWord.get(0);
            fillModel();
            return word;
        }else if(0 < arrayWord.size()){
            Random random = new Random();
            index = random.nextInt(arrayWord.size());
            return arrayWord.get(index);
        }else {
            return  new Word();
        }
    }
    
    public void deleteItem(){
        arrayWord.remove(index);
    }
}
