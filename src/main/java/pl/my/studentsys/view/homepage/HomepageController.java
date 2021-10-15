package pl.my.studentsys.view.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.my.studentsys.viewmodel.HomepageViewModel;

import java.io.IOException;
import java.sql.SQLException;

import static pl.my.studentsys.view.ViewHandler.openView;

public class HomepageController {

    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    private HomepageViewModel viewModel;

    public HomepageController() {
    }

    public void init(HomepageViewModel vm) {
        viewModel = vm;
        email.textProperty().bindBidirectional(vm.emailProperty());
        password.textProperty().bindBidirectional(vm.passwordProperty());
    }

    @FXML
    public void logInButtonAction(ActionEvent actionEvent) throws SQLException, IOException {

        String username = email.getText();

        if (viewModel.login()) {
            System.out.println("LOGGED IN");
            openView("TabView",username);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    public void openRegistration(ActionEvent actionEvent) throws IOException {
        openView("Register");
    }


}
