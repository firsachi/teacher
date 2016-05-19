/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmfolder;

import com.mycompany.teacher.exsampl.ConnectSQLLite;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author firsov
 */
public class FillTablesDatabese {
    //
    //;
    public void checkTable(){
        try {
            DatabaseMetaData databaseMetaData = ConnectSQLLite.getConnection().getMetaData();
            try (ResultSet resultSet = databaseMetaData.getTables(null, null, "%", null)) {
                if (resultSet.next()){
                    return ;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FillTablesDatabese.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableSettings();
        addOneElement();
        createTableLesson();
        createTableWord();
    }
 
    private void createTableSettings(){
        String sql ="CREATE TABLE settings (language varchar(3) NOT NULL," +
                " timeout integer(2) NOT NULL," +
                " master varchar(10) NOT NULL)";
        add(sql);
    }
    
    private void addOneElement(){
        String sql = "INSERT INTO settings (language,timeout,master) VALUES ('ukr',5,'word')";
        add(sql);
    }
    
    private void createTableLesson(){
        String sql ="CREATE TABLE lessons (id varchar NOT NULL, PRIMARY KEY (id))";
        add(sql);
    }
    
    private void createTableWord(){
        String sql ="CREATE TABLE words ("
                + "id integer PRIMARY KEY NOT NULL, "
                + "lesson varchar NOT NULL, "
                + "word varchar NOT NULL, "
                + "translate varchar NOT NULL, "
                + "FOREIGN KEY (lesson) REFERENCES lessons(id))";
        add(sql);
    }
    
    private void add(String sql){
        try (Statement statement = ConnectSQLLite.getConnection().createStatement();) {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FillTablesDatabese.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
