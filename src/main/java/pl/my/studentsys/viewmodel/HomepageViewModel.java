package pl.my.studentsys.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import pl.my.studentsys.model.UserDataModel;

import java.sql.SQLException;

import static pl.my.studentsys.utils.ShowAlerts.showAlert;

public class HomepageViewModel {
    private StringProperty email;
    private StringProperty password;
    private UserDataModel model;

    public HomepageViewModel(UserDataModel model) {
        this.model = model;
        email = new SimpleStringProperty();
        password = new SimpleStringProperty();

    }

    public boolean login() throws SQLException {
        String typedEmail = email.getValue();
        String typedPass = password.getValue();

        if(typedEmail==null || typedPass==null)
        {

            showAlert(Alert.AlertType.ERROR, "Unsuccessful attempt of logging", "Please specify login or/and email and try again");
            return false;
        }

        else
        return model.loginValidation(typedEmail, typedPass);


    }


    public StringProperty emailProperty() {
        return email;
    }


    public StringProperty passwordProperty() {
        return password;
    }


}
