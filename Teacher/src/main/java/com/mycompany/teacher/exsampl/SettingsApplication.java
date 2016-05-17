/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import com.mycompany.teacher.dao.Settings_dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import programmfolder.FillTablesDatabese;
import programmfolder.FolederProgramm;

/**
 *
 * @author firsov
 */

public class SettingsApplication {
    
    private final static String DATABSE_APPLICATION_NAME = "Teacher.db";
    
    public final static String USER_APLICATION_FOLDER;
    
    static  {
        FolederProgramm folder = new FolederProgramm();
        USER_APLICATION_FOLDER = folder.pachProgamm();
        FillTablesDatabese createTables = new FillTablesDatabese();
        createTables.checkTable();
    }
    
    private static Locale laocaleApplicatopn;
    private static int timeout;
    private static String masterValue;
    
    static {
        Settings_dao settings_dao = new Settings_dao();
        settings_dao.getSettings();
    }

    private SettingsApplication() {
    }
     
    public static void setLanuege(String lanuege) {
        SettingsApplication.laocaleApplicatopn = new Locale(lanuege);
    }

    public static void setTimeout(Integer timeout) {
        SettingsApplication.timeout = timeout;
    }

    public static void setMasterValue(String masterValue) {
        SettingsApplication.masterValue = masterValue;
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

    public static String getMasterValue() {
        return masterValue;
    }
    
    
    public static Connection getConnect() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:"+ USER_APLICATION_FOLDER +"Teacher.db");
    }
}
