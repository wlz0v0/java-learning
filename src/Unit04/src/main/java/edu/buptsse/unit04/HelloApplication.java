package edu.buptsse.unit04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        var chinaFlagImage = new Image("file:C:\\MyProject\\Java\\Windows\\Java2021\\src\\Unit04\\src\\main\\resources\\edu\\buptsse\\unit04\\flag4096.png");
        var imageView = new ImageView();
        imageView.setImage(chinaFlagImage);
        imageView.setFitHeight(200);
        imageView.setFitWidth(300);

        var enlargeButton = new Button();
        enlargeButton.setText("国旗变大");
        enlargeButton.setOnMouseClicked(actionEvent -> {
            imageView.setFitHeight(400);
            imageView.setFitWidth(600);
        });
        var shrinkButton = new Button();
        shrinkButton.setText("国旗变小");
        shrinkButton.setOnMouseClicked(actionEvent -> {
            imageView.setFitWidth(300);
            imageView.setFitHeight(200);
        });
        var hBox = new HBox();
        hBox.getChildren().add(enlargeButton);
        hBox.getChildren().add(shrinkButton);
        hBox.setAlignment(Pos.CENTER);
        var vBox = new VBox();
        vBox.getChildren().add(imageView);
        vBox.getChildren().add(hBox);
        var scene = new Scene(vBox, 900, 600);

        imageView.fitHeightProperty().addListener(observable ->
                imageView.setFitHeight(scene.heightProperty().divide(2).doubleValue())
        );
        imageView.fitWidthProperty().bind(scene.widthProperty().divide(2));
        imageView.setOnMouseDragged(mouseEvent -> {
            imageView.setX(mouseEvent.getX());
            imageView.setY(mouseEvent.getY());
        });
        var timeLine = new Timeline();
        timeLine.setCycleCount(Timeline.INDEFINITE);
        var keyFrame = new KeyFrame(Duration.millis(100),
                actionEvent -> vBox.setLayoutX((vBox.getLayoutX() + 20) % scene.getWidth()));
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