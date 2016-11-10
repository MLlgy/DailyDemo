package MVP.model;

import MVP.bean.User;

/**
 * Created by Monkey
 * on 2016/10/26.
 */

public interface IUserModel {
    void setID(int id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    int getID();
    User load (int id);
}
