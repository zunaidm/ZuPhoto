/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

/**
 *
 * @author zumac
 */
public class SecurityGenarator {

    String curentmd5;
    private String val;

    public String genarateMd5(String pass) {
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

    public String getCurrentPass() {
        return curentmd5;
    }

    public SecurityGenarator(String curentmd5) {
        this.curentmd5 = curentmd5;

    }

    public String genarateRandom() {
        // syntax we would like to generate is DIA123456-A1B34      
        val = "ZU-";

        // char (1), random A-Z
        int ranChar = 65 + (new Random()).nextInt(90 - 65);
        char ch = (char) ranChar;
        val += ch;

        // numbers (6), random 0-9
        Random r = new Random();
        int numbers = 100000 + (int) (r.nextFloat() * 899900);
        val += String.valueOf(numbers);

        // char (1), random A-Z
        ranChar = 65 + (new Random()).nextInt(90 - 65);
        ch = (char) ranChar;
        val += ch;

        val += "-";
        // char or numbers (5), random 0-9 A-Z
        for (int i = 0; i < 9;) {
            int ranAny = 48 + (new Random()).nextInt(90 - 65);

            if (!(57 < ranAny && ranAny <= 65)) {
                char c = (char) ranAny;
                val += c;
                i++;
            }

        }
        return val;
    }

    public String getRandom() {
        if (!val.equals(null)) {
            return genarateMd5(val);
        }
        return getCurrentPass();
    }
}
