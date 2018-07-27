package com.example.cm.cmuserinfo.DataUtility;

public class UserInfo {
    int ID;
    String UserName;
    String MobileNo;
    String EmailID;

    public UserInfo() {

    }

    public UserInfo(String userName, String mobileNo, String emailID) {
        UserName = userName;
        MobileNo = mobileNo;
        EmailID = emailID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }
}
