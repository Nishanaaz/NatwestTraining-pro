package org.example.task;

public class ConnectionDb {
    String userName;
    String password;
    String dbName;

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

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String toString() {
        return "connectionDb{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dbName='" + dbName + '\'' +
                '}';
    }
}
