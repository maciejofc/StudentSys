package pl.my.studentsys.viewmodel;

import pl.my.studentsys.model.ModelFactory;

public class ViewModelFactory {
    private RegisterViewModel registerViewModel;
    private HomepageViewModel homepageViewModel;
    private StudentViewModel studentViewModel;
//    private GradeViewModel gradeViewModel;
//    private AttendanceViewModel attendanceViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        registerViewModel = new RegisterViewModel(modelFactory.getUserDataModel());
        homepageViewModel = new HomepageViewModel(modelFactory.getUserDataModel());
        studentViewModel = new StudentViewModel(modelFactory.getStudentDataModel());
    }

    public RegisterViewModel getRegisterViewModel() {
        return registerViewModel;
    }

    public HomepageViewModel getHomepageViewModel() {

        return homepageViewModel;
    }

    public StudentViewModel getStudentViewModel() {

        return studentViewModel;
    }
}