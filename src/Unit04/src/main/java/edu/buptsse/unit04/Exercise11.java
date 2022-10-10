package edu.buptsse.unit04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise11 extends Application {

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

        var timeLine = new Timeline();
        timeLine.setCycleCount(Timeline.INDEFINITE);
        var keyFrame = new KeyFrame(Duration.millis(100), actionEvent -> imageView.setX((imageView.getX() + 20) % scene.getWidth()));
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();

        stage.setTitle("五星红旗迎风飘扬");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
