package com.example.whatsapp.model;

public class users {
    String profilepic,userName,password,email,userId,lastMassage;

    public users(String profilepic, String userName, String password, String email, String userId, String lastMassage) {
        this.profilepic = profilepic;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userId = userId;
        this.lastMassage = lastMassage;
    }

    public users(){}

    //signUp constructor>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public users( String userName, String password, String email) {

        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getLastMassage() {
        return lastMassage;
    }

    public void setLastMassage(String lastMassage) {
        this.lastMassage = lastMassage;
    }


    public void getUserId(String key) {
    }
}
