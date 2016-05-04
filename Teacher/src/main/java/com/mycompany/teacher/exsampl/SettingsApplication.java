/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import com.mycompany.teacher.dao.Settings_dao;
import java.util.Locale;
import programmfolder.FolederProgramm;

/**
 *
 * @author firsov
 */
public class SettingsApplication {
    private static String userApplicationFolder;
    private static Locale laocaleApplicatopn;
    private static int timeout;
    
    static {
        userApplicationFolder = FolederProgramm.pachProgamm();
        System.out.println(userApplicationFolder);
        Settings_dao settings_dao = new Settings_dao();
        settings_dao.getSettings();
    }
     
    public static void setLanuege(String lanuege) {
        SettingsApplication.laocaleApplicatopn = new Locale(lanuege);
    }

    public static void setTimeout(Integer timeout) {
        SettingsApplication.timeout = timeout;
    }

    public static String getApplicationFolder() {
        return userApplicationFolder;
    }
    
    public static int getTimeout() {
        return timeout;
    }

    public static String getLanuege() {
        return laocaleApplicatopn.getLanguage();
    }
    
    public  static Locale getLocale(){
        return laocaleApplicatopn;
    }
}
