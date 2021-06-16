package com.cr.model.viewModels;

import java.security.NoSuchAlgorithmException;

import com.cr.services.security.EncryptSevice;

public class EmployeeViewModel {

    private String username;
    private String password;

    public EmployeeViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = EncryptSevice.Encrypt(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
