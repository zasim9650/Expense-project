package com.example.chatapplication.Model;

public class MassageModel {
    String uId,massage;
    Long timestamp;

    public MassageModel(String uId, String massage, Long timestamp) {
        this.uId = uId;
        this.massage = massage;
        this.timestamp = timestamp;
    }

    public MassageModel(String uId, String massage) {
        this.uId = uId;
        this.massage = massage;
    }
    public MassageModel() {

    }

    public String getuId() {
        return uId;
    }

    public void setuI(String uId) {
        this.uId = uId;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
