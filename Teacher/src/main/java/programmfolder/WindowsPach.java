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
public class WindowsPach implements PachProgram{
    
    private final String folderApplication = "\\Teacher\\";

    @Override
    public String getPachDetabase() {
        String path = System.getenv("APPDATA") + folderApplication;
        File pathFile = new File(path);
        pathFile.mkdirs();
        return path;
    }
    
}
