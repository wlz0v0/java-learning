package edu.buptsse.unit04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise10 extends Application {

    @Override
    public void start(Stage stage) {
//        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));
        var chinaFlagImage = new Image("file:./src/main/resources/edu/buptsse/unit04/flag4096.png");
        var imageView = new ImageView();
        imageView.setImage(chinaFlagImage);
        imageView.setFitHeight(200);
        imageView.setFitWidth(300);

        var root = new Pane();
        root.getChildren().add(imageView);

        var scene = new Scene(root, 500, 500);

        imageView.setOnMouseDragged(mouseEvent -> {
            imageView.setX(mouseEvent.getX());
            imageView.setY(mouseEvent.getY());
        });

        imageView.fitWidthProperty().addListener(observable -> imageView.setFitHeight(imageView.getFitWidth() / 3 * 2));
        imageView.fitWidthProperty().bind(scene.widthProperty().divide(2));

        stage.setTitle("五星红旗迎风飘扬");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
