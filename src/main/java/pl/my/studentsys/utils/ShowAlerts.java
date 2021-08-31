package pl.my.studentsys.utils;

import javafx.scene.control.Alert;

public class ShowAlerts {

    public static void showAlert(Alert.AlertType alertType, String title, String contentText) {
        Alert a = new Alert(alertType);
        a.setTitle(title);
        a.setContentText(contentText);
        a.show();
    }
}
