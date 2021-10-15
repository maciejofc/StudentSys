package pl.my.studentsys.view.tabview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import pl.my.studentsys.view.student.StudentViewController;
import pl.my.studentsys.viewmodel.ViewModelFactory;

public class TabViewController {
    @FXML
    private TabPane tabPane;

    @FXML
    private Label userName;
    @FXML
    private StudentViewController studentViewController;

    public void init(ViewModelFactory vmf) {
        studentViewController.init(vmf.getStudentViewModel());

    }
    public void displayName(String username){
        userName.setText(username);
    }
}
