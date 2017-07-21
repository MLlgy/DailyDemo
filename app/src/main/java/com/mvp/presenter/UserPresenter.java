package com.mvp.presenter;

import com.mvp.bean.User;
import com.mvp.model.IUserModel;
import com.mvp.model.UserModelImpl;
import com.mvp.view.IUserView;

/**
 * Created by Monkey
 * on 2016/10/26.
 * Presenter 通过IUserModel和IUserModel来操作view和model
 */

public class UserPresenter {
    private static final String TAG = "UserPresenter";
//    View
    private IUserView mUserView;
//    Model
    private IUserModel mUserModel;
//此处的参数为传递的activity的实例，同样涉及向下的数据转型
    public UserPresenter(IUserView view){
        mUserView = view;
        mUserModel = new UserModelImpl();//进行了向下转型,向model添加数据
    }
//    此方法用于将交互结果传递至数据--model层
    public void saveUser(int id, String firstName, String lastName){
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }
//此方法用于将数据从model层取出，传递至view层中去更新ui
    public void loadUser(int id){
        User user = mUserModel.load(id);
        mUserView.setFirstName(user.getmFirstName());
        mUserView.setLastName(user.getmLastName());
    }
}
