package com.mvp.view;

/**
 * Created by Monkey
 * on 2016/10/26.
 */
//View接口
public interface IUserView {

    int getID();

    String getFirstName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);
}
