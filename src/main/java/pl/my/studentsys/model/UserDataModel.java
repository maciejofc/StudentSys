package pl.my.studentsys.model;

import java.sql.SQLException;

public interface UserDataModel {
    boolean validate(String email, String password) throws SQLException;
    boolean register(String fullname, String email, String password) throws SQLException;
}
