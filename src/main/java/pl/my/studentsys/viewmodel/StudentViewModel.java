package pl.my.studentsys.viewmodel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.my.studentsys.model.StudentDataModel;

//MANAGING STUDENTS
public class StudentViewModel {

    private StudentDataModel studentDataModel;
    public StudentViewModel(StudentDataModel studentDataModel) {
        this.studentDataModel = studentDataModel;
    }


}
