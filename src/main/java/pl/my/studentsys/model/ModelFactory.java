package pl.my.studentsys.model;

public class ModelFactory {
private UserDataModel userDataModel;

    public UserDataModel getUserDataModel() {
        if (userDataModel == null)
            userDataModel = new UserDataModelManager();
        return userDataModel;
    }
}
