package MVP.model;

import MVP.bean.User;

/**
 * Created by Monkey
 * on 2016/10/26.
 */

public class UserModelImpl implements IUserModel{


    @Override
    public void setID(int id) {
        // 存储firstName
    }

    @Override
    public void setFirstName(String firstName) {
        // 存储firstName
    }

    @Override
    public void setLastName(String lastName) {
        // 存储lastName
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public User load(int id) {
//        查询数据库或者通过网络获得数据--User
        return new User("11","22");
    }
}
