package com.MVP.bean;

/**
 * Created by Monkey
 * on 2016/10/26.
 * 实体类信息
 */

public class User {
    private String mFirstName;
    private String mLastName;
    public User(String mFirstName, String mLastName){
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                '}';
    }
}
