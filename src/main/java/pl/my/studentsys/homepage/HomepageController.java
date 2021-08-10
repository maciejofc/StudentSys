package pl.my.studentsys.homepage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class HomepageController {

    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;

    @FXML
    public void logInButtonAction(ActionEvent actionEvent) {
        String typedLogin = login.getText();
        String typedPassword = password.getText();
        System.out.println(typedLogin);
        System.out.println(typedPassword);
        Map<String,String> mapOfUsers = getAllUsers();
        for (var entry : mapOfUsers.entrySet()) {
            System.out.println(entry.getKey() + "="+typedLogin +","+ entry.getValue()+"="+typedPassword);
            if(entry.getKey().equals(typedLogin)){
                System.out.println("good login ");
                if(entry.getValue().equals(typedPassword)); {
                    System.out.println("good password too");
                }
            }

        }

    }
    private Connection getConnection()  {
        Connection conn;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsys?useSSL=false", "root", "mysqlpassword");
            return conn;
        }
        catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }

    }
    private void executeQuery(String query){
        Connection conn = getConnection();
        Statement st;
        try{
            st=conn.createStatement();
            st.execute(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private ObservableMap<String,String> getAllUsers(){
        Map<String,String> map = new HashMap<String,String>();

        ObservableMap<String,String> observableMap = FXCollections.observableMap(map);
        Connection conn = getConnection();
        String query = "SELECT * FROM users";
        Statement st;
        ResultSet rs;
        try{
            st= conn.createStatement();
            rs = st.executeQuery(query);
            Users users;
            while (rs.next()){
                users = new Users(rs.getInt("id"),rs.getString("fullName"),rs.getString("email"),rs.getString("password"));
                observableMap.put(users.getEmail(),users.getPassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return observableMap;
    }
//    private checkFields(String login, String password){
//
//    }

}
