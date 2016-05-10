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
public class FolederProgramm {
    
    private PachProgram pachProgramm;
    private final String nameOs = "windows";
    
    public String pachProgamm(){
        String os = System.getProperty("os.name").split(" ")[0].toLowerCase();
        if (os.equals(nameOs)){
            pachProgramm = new WindowsPach();
            return pachProgramm.getPachDetabase();
        }else{
            pachProgramm = new LinuxPach();
            return pachProgramm.getPachDetabase();
        }
    }
    
}
