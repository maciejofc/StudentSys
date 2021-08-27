package pl.my.studentsys.viewmodel;

import pl.my.studentsys.model.ModelFactory;
import pl.my.studentsys.viewmodel.user.UserViewModel;

public class ViewModelFactory {
    private UserViewModel userViewModel;
    public ViewModelFactory(ModelFactory modelFactory){
        userViewModel = new UserViewModel(modelFactory.getUserDataModel());
    }

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }
}
