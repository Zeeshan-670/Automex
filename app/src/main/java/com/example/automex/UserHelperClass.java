package com.example.automex;

public class UserHelperClass {
    String fullName;
    String userName;
    String email;
    String phoneNO;
    String cnicNO;
    String licenseNO;
    String password;

    public UserHelperClass() {
    }

    public UserHelperClass(String fullName, String userName, String email, String phoneNO, String cnicNO, String licenseNO, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phoneNO = phoneNO;
        this.cnicNO = cnicNO;
        this.licenseNO = licenseNO;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getCnicNO() {
        return cnicNO;
    }

    public void setCnicNO(String cnicNO) {
        this.cnicNO = cnicNO;
    }

    public String getLicenseNO() {
        return licenseNO;
    }

    public void setLicenseNO(String licenseNO) {
        this.licenseNO = licenseNO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
