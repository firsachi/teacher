/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import static com.mycompany.teacher.exsampl.SettingsApplication.USER_APLICATION_FOLDER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author firsov
 */
public final class ConnectSQLLite {
    
    private static Connection connection;
    private static ConnectSQLLite connectSQLLite;

    private ConnectSQLLite() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+ USER_APLICATION_FOLDER +"c");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQLLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        if (null == connectSQLLite){
            connectSQLLite = new ConnectSQLLite();
        }
        return connection;
    }
    
}
