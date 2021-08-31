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



        if (viewModel.login()) {
            openView("MainView");
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    public void openRegistration(ActionEvent actionEvent) throws IOException {
        openView("Register");
    }


//    public  ObservableMap<String,String> getAllUsers(){
//        Map<String,String> map = new HashMap<String,String>();
//
//        ObservableMap<String,String> observableMap = FXCollections.observableMap(map);
//        Connection conn = getConnection();
//        String query = "SELECT * FROM users";
//        Statement st;
//        ResultSet rs;
//        try{
//            st= conn.createStatement();
//            rs = st.executeQuery(query);
//            Users users;
//            while (rs.next()){
//                users = new Users(rs.getInt("id"),rs.getString("fullName"),rs.getString("email"),rs.getString("password"));
//                observableMap.put(users.getEmail(),users.getPassword());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return observableMap;
//    }
//    private checkFields(String login, String password){
//
//    }

}
