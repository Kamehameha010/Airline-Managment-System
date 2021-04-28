package com.cr.services.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptSevice {
    public static String Encrypt(String word) throws NoSuchAlgorithmException {

        var md = MessageDigest.getInstance("SHA-256");

        byte[] data = md.digest(word.getBytes());

        var sb = new StringBuilder();

        for (var str : data) {
            sb.append(str);
        }
        return sb.toString();
    }

}
