package pl.my.studentsys.viewmodel.user;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.my.studentsys.model.UserDataModel;
import pl.my.studentsys.view.ViewHandler;
import pl.my.studentsys.viewmodel.ViewModelFactory;

import java.io.IOException;
import java.sql.SQLException;

public class UserViewModel {
    private StringProperty fullname;
    private StringProperty email;
    private StringProperty password;
    private UserDataModel model;



    public UserViewModel(UserDataModel model) {
        this.model = model;
        fullname = new SimpleStringProperty();
        email = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public boolean login(String login, String password) throws SQLException {
        if(model.validate(login,password))
            return true;
        else
            return false;





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
