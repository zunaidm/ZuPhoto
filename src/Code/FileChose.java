/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Zunaid
 */
public class FileChose {

    private JFileChooser chooser = new JFileChooser();
    private File f;
    private String filePath, dirPath;

    public void selectFile() {
        chooser.showOpenDialog(null);
        f = chooser.getCurrentDirectory();
        dirPath = f.getAbsolutePath();
        f = chooser.getSelectedFile();
        filePath = f.getAbsolutePath();

    }

    public String getFilePath() {

        return filePath;
    }

    public String getDirectoryPath() {

        return dirPath;
    }
    
//This method return All fiel list , by giving Extention in paramitter
    
    public List getAllFileName(String extnsn) {
        List fileNamesList = new ArrayList();
        try {
            Files.newDirectoryStream(Paths.get(getDirectoryPath()),
                    path -> path.toString().endsWith(extnsn)).forEach(filePath -> fileNamesList.add(filePath.toString()));
        } catch (IOException ex) {
            Logger.getLogger(FileChose.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileNamesList;
    }
}
