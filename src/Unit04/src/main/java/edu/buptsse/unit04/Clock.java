package edu.buptsse.unit04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/20
 *     desc   :
 *     version:
 * </pre>
 */
public class Clock extends Application {
    private int hour;
    private int minute;
    private int second;

    @Override
    public void start(Stage stage) {
        final int CIRCLE_CENTER_X = 450;
        final int CIRCLE_CENTER_Y = 300;
        final int HOUR_HAND_LENGTH = 40;
        final int MINUTE_HAND_LENGTH = 60;
        final int SECOND_HAND_LENGTH = 80;
        final double PI = 3.14159;
        var circle = new Circle();
        circle.setCenterX(CIRCLE_CENTER_X);
        circle.setCenterY(CIRCLE_CENTER_Y);
        circle.setRadius(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        var timeText = new Label();
        timeText.setLayoutX(420);
        timeText.setLayoutY(150);
        var timeFormat = new SimpleDateFormat("HH:mm:ss");
        var calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        timeText.setText(timeFormat.format(calendar.getTime()));

        var hourLine = new Line();
        hourLine.setStartX(CIRCLE_CENTER_X);
        hourLine.setStartY(CIRCLE_CENTER_Y);
        hourLine.setEndX(calculateEndPointX(hour % 12 / 6.0 * PI, HOUR_HAND_LENGTH));
        hourLine.setEndY(calculateEndPointY(hour % 12 / 6.0 * PI, HOUR_HAND_LENGTH));
        hourLine.setStroke(Color.RED);

        var minuteLine = new Line();
        minuteLine.setStartX(CIRCLE_CENTER_X);
        minuteLine.setStartY(CIRCLE_CENTER_Y);
        minuteLine.setEndX(calculateEndPointX(minute / 30.0 * PI, MINUTE_HAND_LENGTH));
        minuteLine.setEndY(calculateEndPointY(minute / 30.0 * PI, MINUTE_HAND_LENGTH));
        minuteLine.setStroke(Color.GREEN);

        var secondLine = new Line();
        secondLine.setStartX(CIRCLE_CENTER_X);
        secondLine.setStartY(CIRCLE_CENTER_Y);
        secondLine.setEndX(calculateEndPointX(second / 30.0 * PI, SECOND_HAND_LENGTH));
        secondLine.setEndY(calculateEndPointY(second / 30.0 * PI, SECOND_HAND_LENGTH));
        secondLine.setStroke(Color.BLUE);

        var clockPane = new Pane();
        clockPane.getChildren().add(circle);
        clockPane.getChildren().add(hourLine);
        clockPane.getChildren().add(minuteLine);
        clockPane.getChildren().add(secondLine);

        var fatherPane = new Pane();
        fatherPane.getChildren().add(timeText);
        fatherPane.getChildren().add(clockPane);

        var timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        var keyFrame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            updateTime();
            timeText.setText(String.format("%02d:%02d:%02d", hour, minute, second));
            hourLine.setEndX(calculateEndPointX(hour % 12 / 6.0 * PI, HOUR_HAND_LENGTH));
            hourLine.setEndY(calculateEndPointY(hour % 12 / 6.0 * PI, HOUR_HAND_LENGTH));
            minuteLine.setEndX(calculateEndPointX(minute / 30.0 * PI, MINUTE_HAND_LENGTH));
            minuteLine.setEndY(calculateEndPointY(minute / 30.0 * PI, MINUTE_HAND_LENGTH));
            secondLine.setEndX(calculateEndPointX(second / 30.0 * PI, SECOND_HAND_LENGTH));
            secondLine.setEndY(calculateEndPointY(second / 30.0 * PI, SECOND_HAND_LENGTH));
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        var scene = new Scene(fatherPane, 900, 600);
        stage.setScene(scene);
        stage.setTitle("这是一块表");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private double calculateEndPointX(double angle, double length) {
        return 450.0 + length * Math.sin(angle);
    }

    private double calculateEndPointY(double angle, double length) {
        return 300.0 - length * Math.cos(angle);
    }

    private void updateTime() {
        ++second;
        if (second == 60) {
            second = 0;
            ++minute;
            if (minute == 60) {
                minute = 0;
                ++hour;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }
}
