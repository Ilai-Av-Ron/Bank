package front;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LandingPage extends Application {

    public void start(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome to My Bank");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 20px;");

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        Button exitButton = new Button("Exit");

        String buttonStyle = "-fx-background-color: #3b5998; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;";
        loginButton.setStyle(buttonStyle);
        registerButton.setStyle(buttonStyle);
        exitButton.setStyle(buttonStyle);
        exitButton.setOnAction(e -> primaryStage.close());

        VBox layout = new VBox(15);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #f4f4f4;");
        layout.getChildren().addAll(welcomeLabel, loginButton, registerButton, exitButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("My Bank - Landing Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
