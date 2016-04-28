/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teacher.exsampl;

import com.mycompany.teacher.dao.Settings_dao;

/**
 *
 * @author firsov
 */
public class Model {
    
    private Settings_dao settings_dao;
    
    public Model() {
        settings_dao = new Settings_dao();
        settings_dao.getSettings();
    }
    
    
}
