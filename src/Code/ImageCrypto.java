/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author Zunaid
 */
public class ImageCrypto {
    
    public void enCrypet(String file_path) {
        try {
            FileInputStream file = new FileInputStream(file_path);
            FileOutputStream outStream = new FileOutputStream("tmp.jpg");
            
            byte k[] = "Cool5556kdskdsa0".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();

            //Removoing the temp file and replace the encrypted file
            copyToMainFolder(file_path);
            System.out.println("The file encrypted Successfully");
            //JOptionPane.showMessageDialog(null, "The file encrypted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void deCrypet(String file_path) {
        try {
            FileInputStream file = new FileInputStream(file_path);
            FileOutputStream outStream = new FileOutputStream("tmp.jpg");
            byte k[] = "Cool5556kdskdsa0".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            
            //Removoing the temp file and replace the encrypted file
            copyToMainFolder(file_path);
            
            System.out.println("The image was decrypted successfully");
            //JOptionPane.showMessageDialog(null, "The image was decrypted successfully");
            //Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + file_path);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void copyToMainFolder(String file_path) throws IOException{
        File fl = new File(file_path);
            fl.delete();
            
            FileInputStream in = new FileInputStream("tmp.jpg");
            FileOutputStream ou = new FileOutputStream(file_path);
            
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bou = new BufferedOutputStream(ou);
            
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
            
            fl = new File("tmp.jpg");
            fl.delete();
    }
}
