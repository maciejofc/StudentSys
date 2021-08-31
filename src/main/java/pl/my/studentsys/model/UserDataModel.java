package pl.my.studentsys.model;

import java.sql.SQLException;

public interface UserDataModel {
    boolean loginValidation(String email, String password) throws SQLException;
    boolean registerValidation(String fullname, String email, String password) throws SQLException;
}
