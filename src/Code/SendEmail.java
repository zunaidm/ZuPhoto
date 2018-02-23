/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Zunaid
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

   public static void main(String [] args) {    
     ParcentCalc pc = new ParcentCalc();
     pc.setPerCent(10);
       System.out.println(pc.getPerCent(10));
   }
}