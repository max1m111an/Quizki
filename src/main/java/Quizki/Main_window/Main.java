package Quizki.Main_window;

import Quizki.About_as.About_as;
import Quizki.Account.Account;
import Quizki.Create.Create;
import Quizki.Materials.Materials;
import Quizki.Repository.Repository;
import Quizki.Settings.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static public Stage temp;
    static public Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        temp = stage;
        Button b_about_as = new Button("About us");
        b_about_as.setOnAction(new About_as.changeScene());

        Button b_materials = new Button("Materials");
        b_materials.setOnAction(new Materials.changeScene());

        Button b_create = new Button("Create");
        b_create.setOnAction(new Create.changeScene());

        Button b_repository = new Button("Repository");
        b_repository.setOnAction(new Repository.changeScene());

        Button b_account = new Button("Account");
        b_account.setOnAction(new Account.changeScene());

        Button b_settings = new Button("Settings");
        b_settings.setOnAction(new Settings.changeScene());

        HBox p = new HBox(b_about_as, b_materials, b_create, b_repository, b_account, b_settings);
        scene = new Scene(p, 500, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}