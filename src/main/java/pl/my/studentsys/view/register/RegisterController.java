package pl.my.studentsys.view.register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.my.studentsys.viewmodel.RegisterViewModel;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {


    @FXML
    private TextField fullname;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button exitButton;

    private RegisterViewModel viewModel;

    public RegisterController() {
    }

    public void init(RegisterViewModel vm) {
        viewModel = vm;
        fullname.textProperty().bindBidirectional(vm.fullnameProperty());
        email.textProperty().bindBidirectional(vm.emailProperty());
        password.textProperty().bindBidirectional(vm.passwordProperty());
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void register(ActionEvent event) throws IOException, SQLException {
        viewModel.register();
    }


}
