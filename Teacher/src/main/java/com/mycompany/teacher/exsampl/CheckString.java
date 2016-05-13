/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author firsov
 */
public class CheckString {
    
    private final String regex = "([a-z])";
    private final Pattern pt;

    public CheckString() {
        pt = Pattern.compile(regex);
    }
    
    public boolean checkValue(String value){
        Matcher matcher = pt.matcher(value);
        return matcher.matches();
    }
}
