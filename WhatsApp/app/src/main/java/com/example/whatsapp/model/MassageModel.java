package com.example.whatsapp.model;

public class MassageModel {
    String Uid,massage,massageId;
    Long timestamp;

    public MassageModel(String uid, String massage, String massageId, Long timestamp) {
        Uid = uid;
        this.massage = massage;
        this.massageId = massageId;
        this.timestamp = timestamp;
    }

    public MassageModel(String uid, String massage, Long timestamp) {
        Uid = uid;
        this.massage = massage;
        this.timestamp = timestamp;
    }

    public MassageModel(String uid, String massage) {
        Uid = uid;
        this.massage = massage;
    }
    public MassageModel(){}

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
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

    public String getMassageId() {
        return massageId;
    }

    public void setMassageId(String massageId) {
        this.massageId = massageId;
    }
}
