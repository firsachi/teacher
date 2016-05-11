/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmfolder;

import java.io.File;

/**
 *
 * @author firsov
 */
public class LinuxPach implements PachProgram{
    
    private final String APPLICATION_FOLDER = "/.Teacher/";

    @Override
    public String getPachDetabase() {
        String path = System.getProperty("user.home") + APPLICATION_FOLDER;
        File pathFile = new File(path);
        pathFile.mkdirs();
        return path;
    }
    
}
