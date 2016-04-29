/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.SettingsApplication;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author firsov
 */
public class Settings_dao {
    
    public void getSettings(){
        String sql = "SELECT * FROM settings";
        try (PreparedStatement preparedStatement = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\firsov\\AppData\\Roaming\\teacher\\Teacher.db").prepareStatement(sql);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            SettingsApplication.setIndexLanuege(resultSet.getString(1));
            SettingsApplication.setTimeout(resultSet.getInt(2));
            System.out.println(SettingsApplication.getIndexLanuege());
        } catch (SQLException ex) {
            Logger.getLogger(Settings_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSettings(String language, int timeout){
        String sql="UPDATE settings SET language=?, timeout=? WHERE language=?";
        try (PreparedStatement pr = DriverManager.getConnection("jdbc:sqlite:"+ SettingsApplication.getApplicationFolder() +"Teacher.db").prepareStatement(sql);) {
            pr.setString(1, language);
            pr.setInt(2, timeout);
            pr.setString(3, SettingsApplication.getIndexLanuege());
            System.out.println(pr.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(Settings_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
