package pl.my.studentsys.model;

import javafx.scene.control.Alert;
import pl.my.studentsys.model.db.user.UserDao;
import pl.my.studentsys.model.db.user.UserDaoImpl;
import pl.my.studentsys.utils.ShowAlerts;

import java.sql.SQLException;

import static pl.my.studentsys.utils.ShowAlerts.showAlert;

public class UserDataModelManager implements UserDataModel {
    private UserDao userDao = new UserDaoImpl();
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
    public boolean loginValidation(String email, String typedPassword) throws SQLException {
        UserDataModelManager user = userDao.selectUserByLogin(email);

        if (user == null) {
            showAlert(Alert.AlertType.ERROR, "Unsuccessful attempt of logging", "This email does not exist in our system, please try again");
            return false;
        } else if (user.getPassword().equals(typedPassword)) {
            showAlert(Alert.AlertType.CONFIRMATION, "Successful attempt of logging", "Successfully logged in, welcome :)");
            return true;
        } else {
            showAlert(Alert.AlertType.ERROR, "Unsuccessful attempt of logging", "Incorecct password, please try again");
            return false;
        }
    }

    @Override
    public boolean registerValidation(String fullName, String login, String password) throws SQLException {

        if (userDao.selectUserByLogin(email) == null) {
            userDao.createUser(fullName, login, password);
            ShowAlerts.showAlert(Alert.AlertType.CONFIRMATION, "Successful attempt of registering", "Welcome");
            return true;
        } else {
            showAlert(Alert.AlertType.ERROR, "Unsuccessful attempt of register", "This e-mail is actually associated with our system");
            return false;
        }

    }

}
