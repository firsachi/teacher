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
public class Settings {
    private static String indexLanuege;
    private static int timeout;

    public static void setIndexLanuege(String indexLanuege) {
        Settings.indexLanuege = indexLanuege;
    }

    public static void setTimeout(Integer timeout) {
        Settings.timeout = timeout;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static String getIndexLanuege() {
        return indexLanuege;
    }
    
}
