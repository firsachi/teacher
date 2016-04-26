package com.mycompany.teacher;

import com.mycompany.teacher.exsampl.Settings;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/fxml/MainFrameTeacher.fxml"));
        fXMLLoader.setResources(ResourceBundle.getBundle("locales.LocaleTeacher", new Locale("eng")));
        
        Parent root = fXMLLoader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle(fXMLLoader.getResources().getString("main.frame"));
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Settings.setTimeout(3);
        Settings.setIndexLanuege("eng");
        launch(args);
    }

}
