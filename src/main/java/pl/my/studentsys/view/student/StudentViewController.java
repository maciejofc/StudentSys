package pl.my.studentsys.view.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.my.studentsys.viewmodel.StudentViewModel;

public class StudentViewController {

    private StudentViewModel viewmodel;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSurname;

    @FXML
    private TextField tfField;


    public StudentViewController() {
    }

    public void init(StudentViewModel studentViewModel) {
        viewmodel = studentViewModel;

    }
    @FXML
    public void addStudent(ActionEvent actionEvent){
        System.out.println("ADDED STUDENT");
    }
}
