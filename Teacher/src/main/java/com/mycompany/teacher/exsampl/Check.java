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
public class Check {
    
    public boolean checkEmpty(String value){
        String valueCheck = value.trim();
        if (0 != valueCheck.length() ){
            return true;
        }else {
            return false;
        }
    }
}
