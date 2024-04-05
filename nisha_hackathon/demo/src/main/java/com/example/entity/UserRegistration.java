package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

    @Entity
    public class UserRegistration {
        @Id
        String email_id;
        @Column(nullable = false)
        String name;
        String address;
        String accountNo;
        String mobileNo;
        @Column(nullable = false)
        String password;

        public UserRegistration(String email_id, String name, String address, String accountNo, String mobileNo, String password) {
            this.email_id = email_id;
            this.name = name;
            this.address = address;
            this.accountNo = accountNo;
            this.mobileNo = mobileNo;
            this.password = password;
        }

        public String getEmail_id() {
            return email_id;
        }

        public void setEmail_id(String email_id) {
            this.email_id = email_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "UserRegistration{" +
                    "email_id='" + email_id + '\'' +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", accountNo='" + accountNo + '\'' +
                    ", mobileNo='" + mobileNo + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

}
