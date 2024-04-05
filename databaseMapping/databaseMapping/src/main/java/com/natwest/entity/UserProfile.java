package com.natwest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mobileNo;
    private String panNumber;
    private String aadharCard;
    private LocalDate doj;


    public UserProfile() {

    }
    public UserProfile(int id, String mobileNO, String panNumber, String aadhaarCard, LocalDate doj) {
        this.id = id;
        this.mobileNo = mobileNO;
        this.panNumber = panNumber;
        this.aadharCard = aadhaarCard;
        this.doj = doj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadhaarCard() {
        return aadharCard;
    }

    public void setAadhaarCard(String aadhaarCard) {
        this.aadharCard = aadhaarCard;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
}
