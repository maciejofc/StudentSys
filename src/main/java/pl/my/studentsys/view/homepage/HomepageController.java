package pl.my.studentsys.view.homepage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import pl.my.studentsys.view.ViewHandler;
import pl.my.studentsys.viewmodel.user.UserViewModel;


import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class HomepageController {

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    private UserViewModel viewModel;

    public HomepageController() {
    }
    public void init(UserViewModel userViewModel){
        this.viewModel = userViewModel;
    }
    @FXML
    public void logInButtonAction(ActionEvent actionEvent) throws SQLException, IOException {
    String typedLogin = login.getText();
    String typedPassword = password.getText();
    boolean flag = viewModel.login(typedLogin,typedPassword);



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
