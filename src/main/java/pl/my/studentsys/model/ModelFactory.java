package pl.my.studentsys.model;

public class ModelFactory {
private UserDataModel userDataModel;
private StudentDataModel studentDataModel;
    public UserDataModel getUserDataModel() {
        if (userDataModel == null)
            userDataModel = new UserDataModelManager();
        return userDataModel;
    }

    public StudentDataModel getStudentDataModel() {
        if(studentDataModel==null)
            studentDataModel = new StudentDataModelManager();
        return studentDataModel;
    }
}
