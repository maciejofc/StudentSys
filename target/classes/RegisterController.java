package pl.my.studentsys.view.register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.my.studentsys.viewmodel.user.UserViewModel;

import java.io.IOException;

public class RegisterController {


    @FXML
    TextField fullName;
    @FXML
    TextField email;
    @FXML
    TextField password;
    private UserViewModel viewModel;
    public RegisterController() {
    }
    public void init(UserViewModel userViewModel){
        this.viewModel= userViewModel;
    }
    @FXML
    public void backButtonAction(ActionEvent event) throws IOException {

    }


}
