package pl.my.studentsys.model;

import javafx.scene.control.Alert;
import pl.my.studentsys.model.db.user.UserDao;
import pl.my.studentsys.model.db.user.UserDaoImpl;

import java.sql.SQLException;

public class UserDataModelManager implements UserDataModel {
    private UserDao userDao= new UserDaoImpl();
    private int id;
    private String fullName;
    private String email;
    private String password;

    public UserDataModelManager() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDataModelManager{" +
                "userDao=" + userDao +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserDataModelManager(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean validate(String email, String typedPassword) throws SQLException {

        UserDataModelManager user = userDao.selectUserByLogin(email);
        if(user==null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Info about loging");
            a.setContentText("BAD LOGIN(EMAIL)");
            a.show();
            return false;
        }
        String userPassword = user.getPassword();
        if(userPassword.equals(typedPassword))
        {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Info about loging");
            a.setContentText("Sucessfully logged in");
            a.show();
        return true;
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Info about loging");
            a.setContentText("BAD PASSWORD");
            a.show();
            return false;
        }


    }

    @Override
    public boolean register(String fullName, String login, String password) throws SQLException {

        return false;
    }

}
