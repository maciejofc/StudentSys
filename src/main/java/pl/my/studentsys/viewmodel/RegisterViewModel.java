package pl.my.studentsys.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import pl.my.studentsys.model.UserDataModel;
import pl.my.studentsys.utils.ShowAlerts;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterViewModel {
    private StringProperty fullname;
    private StringProperty email;
    private StringProperty password;
    private UserDataModel model;


    public RegisterViewModel(UserDataModel model) {
        this.model = model;
        fullname = new SimpleStringProperty();
        email = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    private boolean isValidEmailAdress(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    public void register() throws SQLException {
        String typedFullName = fullname.getValue();
        String typedEmail = email.getValue();
        String typedPass = password.getValue();


        boolean isAllFilled = true;
        if (typedFullName == null) {
            isAllFilled = false;

        } else if (typedEmail == null) {

            isAllFilled = false;
        } else if (typedPass == null) {

            isAllFilled = false;
        }

        if (isAllFilled) {
            if (isValidEmailAdress(typedEmail)) {
                if (model.registerValidation(typedFullName, typedEmail, typedPass)) {
                    fullname.setValue("");
                    email.setValue("");
                    password.setValue("");


                } else {
                    email.setValue("");

                }


            } else {
                email.setValue("");
                ShowAlerts.showAlert(Alert.AlertType.ERROR, "Unssuccesful attempt of registering", "This is not email");

            }
        } else {
            ShowAlerts.showAlert(Alert.AlertType.ERROR, "Unssuccesful attempt of registering", "Fill all details");
        }

    }


    public StringProperty fullnameProperty() {
        return fullname;
    }


    public StringProperty emailProperty() {
        return email;
    }


    public StringProperty passwordProperty() {
        return password;
    }


}
