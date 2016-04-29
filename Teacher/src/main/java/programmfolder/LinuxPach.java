/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmfolder;

/**
 *
 * @author firsov
 */
public class LinuxPach implements PachProgram{

    @Override
    public String getPachDetabase() {
        return System.getProperty("user.home") + "/.Teacher/";
    }
    
}
