package pl.my.studentsys.viewmodel;

import pl.my.studentsys.model.ModelFactory;

public class ViewModelFactory {
    private RegisterViewModel registerViewModel;
    private HomepageViewModel homepageViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        registerViewModel = new RegisterViewModel(modelFactory.getUserDataModel());
        homepageViewModel = new HomepageViewModel(modelFactory.getUserDataModel());
    }

    public RegisterViewModel getRegisterViewModel() {
        return registerViewModel;
    }

    public HomepageViewModel getHomepageViewModel() {

        return homepageViewModel;
    }
}