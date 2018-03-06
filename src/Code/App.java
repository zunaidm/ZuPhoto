/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author zumac
 */
public class App {
    public static void main(String[] args) {
        //SecurityGenarator secure = new SecurityGenarator("e10adc3949ba59abbe56e057f20f883e");
        //System.out.println(secure.genarateRandom());
        SendMail sm = new SendMail();
            SecurityGenarator secure = new SecurityGenarator("e10adc3949ba59abbe56e057f20f883e");

        try {
            sm.emailMe(secure.genarateRandom());
        } catch (MessagingException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
