package com.mycompany.teacher;

import com.mycompany.teacher.exsampl.Model;
import com.mycompany.teacher.exsampl.SettingsApplication;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/fxml/MainFrameTeacher.fxml"));
        fXMLLoader.setResources(ResourceBundle.getBundle("locales.LocaleTeacher", 
                new Locale(SettingsApplication.getIndexLanuege())));
        
        Parent root = fXMLLoader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        primaryStage.setTitle(fXMLLoader.getResources().getString("main.frame"));
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
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
        Model model = new Model(); 
        launch(args);
    }

    

}
