package pl.my.studentsys.model.db.user;

import pl.my.studentsys.model.UserDataModelManager;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //Create user
    void insertUser(String fullname,String email,String password) throws SQLException;

    //delete user
    void deleteUser(UserDataModelManager user) throws SQLException;

    // update user
    boolean updateUser(UserDataModelManager user) throws SQLException;

    //Select all users
    List<UserDataModelManager> selectAllUsers();

    // select user by id
    UserDataModelManager selectUser(int id);

    UserDataModelManager selectUserByLogin(String email) throws SQLException;

}
