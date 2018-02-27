/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author zumac
 */
public class Md5Genarator {

    public String getMd5(String pass) {
        String hash = "";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes(), 0, pass.length());
            hash = new BigInteger(1, m.digest()).toString(16);
        } catch (Exception e) {
            System.out.println(e);
        }
        return hash;
    }
}
