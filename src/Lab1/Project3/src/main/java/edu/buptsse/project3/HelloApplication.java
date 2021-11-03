package edu.buptsse.project3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var car1 = new Car();
        var pane1 = new Pane();
        pane1.getChildren().add(car1);

        var speed1 = new TextField();
        speed1.setMaxWidth(40);
        speed1.setText("1");
        var hBox = new HBox();
        hBox.getChildren().add(speed1);
        var borderPane = new Pane();
        borderPane.getChildren().add(speed1);
        borderPane.getChildren().add(pane1);
        var scene = new Scene(borderPane, 500, 200);
        var timeLine = new Timeline();
        timeLine.setCycleCount(Animation.INDEFINITE);
        var keyFrame = new KeyFrame(Duration.seconds(0.05), actionEvent -> {
            String s = speed1.getText();
            if (s.equals("")) {
                s += '1';
            }
            car1.setSpeed(Math.log(Double.parseDouble(s)) + 1);
            pane1.setLayoutX(pane1.getLayoutX() - 0.2 * 100 / car1.getSpeed());
            if (pane1.getLayoutX() < 0) {
                pane1.setLayoutX(scene.getWidth());
            }
        });
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();

        scene.setFill(Color.color(0.498, 0.62, 0.804));
        pane1.setLayoutX(scene.getWidth());
        stage.setScene(scene);
        stage.show();
    }
}