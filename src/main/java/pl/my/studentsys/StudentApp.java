package pl.my.studentsys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.my.studentsys.model.ModelFactory;
import pl.my.studentsys.view.ViewHandler;
import pl.my.studentsys.viewmodel.ViewModelFactory;

public class StudentApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage,viewModelFactory);
        viewHandler.start();



    }

}
