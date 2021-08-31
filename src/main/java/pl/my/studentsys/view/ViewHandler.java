package pl.my.studentsys.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.my.studentsys.view.homepage.HomepageController;

import pl.my.studentsys.view.register.RegisterController;
import pl.my.studentsys.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {
    private static Stage stage;
    private static ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        //openView("Register");
        openView("Homepage");


    }

    public static void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        Stage localStage = new Stage();


        if ("Homepage".equals(viewToOpen)) {
            loader.setLocation(ViewHandler.class.getResource("/Homepage.fxml"));
            root = loader.load();
            HomepageController view = loader.getController();
            root.getStylesheets().add("home_style.css");
            view.init(viewModelFactory.getHomepageViewModel());
            stage.setTitle("LOGIN");

        }
         if ("Register".equals(viewToOpen)) {
            loader.setLocation(ViewHandler.class.getResource("/Register.fxml"));
            root = loader.load();
            RegisterController view = loader.getController();
            view.init(viewModelFactory.getRegisterViewModel());
            stage.setTitle("REGISTER");

        }
        else if ("MainView".equals(viewToOpen)) {
            loader.setLocation(ViewHandler.class.getResource("/MainView.fxml"));
            root = loader.load();
            //RegisterController view = loader.getController();
            //view.init(viewModelFactory.getUserViewModel());
            stage.setTitle("StudentSystem");

        }
        scene = new Scene(root);

        localStage.setScene(scene);
        localStage.show();

    }
}
