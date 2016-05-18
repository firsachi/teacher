/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.dao;

import com.mycompany.teacher.exsampl.ConnectSQLLite;
import com.mycompany.teacher.exsampl.SettingsApplication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author firsov
 */
public class SettingsDao {
    
    public void getSettings(){
        String sql = "SELECT * FROM settings";
        try (PreparedStatement preparedStatement = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                SettingsApplication.setLanuege(resultSet.getString(1));
                SettingsApplication.setTimeout(resultSet.getInt(2));
                SettingsApplication.setMasterValue(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSettings(String language, int timeout, String masterValue){
        String sql="UPDATE settings SET language=?, timeout=?, master=? WHERE language=?";
        try (PreparedStatement pr = ConnectSQLLite.getConnection().prepareStatement(sql);) {
            pr.setString(1, language);
            pr.setInt(2, timeout);
            pr.setString(3, masterValue);
            pr.setString(4, SettingsApplication.getLanuege());
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SettingsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
