
package DTO;

import java.sql.Date;


public class UserDTO {
    
    String userID;
    String password;
    String phone;
    String userName;
    String address;
    String roleID;
    String gmail;
    Date createDate;
    String status;
    String verifyCode;

    public UserDTO(String userID, String gmail, String verifyCode) {
        this.userID = userID;
        this.gmail = gmail;
        this.verifyCode = verifyCode;
    }

    
    
    public UserDTO(String userID, String password, String phone, String userName, String address, String roleID, String gmail, Date createDate, String status) {
        this.userID = userID;
        this.password = password;
        this.phone = phone;
        this.userName = userName;
        this.address = address;
        this.roleID = roleID;
        this.gmail = gmail;
        this.createDate = createDate;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    
}
