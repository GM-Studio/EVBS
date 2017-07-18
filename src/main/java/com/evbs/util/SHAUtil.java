package com.evbs.util;

/**
 * Created by squirrel-chen on 7/18/17.
 */
import java.security.MessageDigest;

/**
 * 采用SHAA加密
 *
 */
public class SHAUtil {
    /***
     * SHA加密
     *
     */
    public static String shaEncode(String inStr) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
            byte[] byteArray = inStr.getBytes("UTF-8");
            byte[] md5Bytes = sha.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));

        }
            return hexValue.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
    }
}
