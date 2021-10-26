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
    // 保存小时数
    private int hour;
    // 保存分钟数
    private int minute;
    // 保存秒数
    private int second;
    // 表的圆心的X坐标
    private final double CIRCLE_CENTER_X = 450.0;
    // 表的圆心的Y坐标
    private final double CIRCLE_CENTER_Y = 300.0;

    @Override
    public void start(Stage stage) {
        // 表的半径
        final var CIRCLE_RADIUS = 100.0;
        // 时针长度
        final var HOUR_HAND_LENGTH = 40.0;
        // 分针长度
        final var MINUTE_HAND_LENGTH = 60.0;
        // 秒针长度
        final var SECOND_HAND_LENGTH = 80.0;
        // π
        final var PI = 3.14159;
        // 画一个圆心在450,300 半径为100的圆作为表框
        var circle = new Circle();
        circle.setCenterX(CIRCLE_CENTER_X);
        circle.setCenterY(CIRCLE_CENTER_Y);
        circle.setRadius(CIRCLE_RADIUS);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // 展示时间文本
        var timeText = new Label();
        timeText.setLayoutX(420);
        timeText.setLayoutY(150);
        // 定义时间文本的格式
        var timeFormat = new SimpleDateFormat("HH:mm:ss");
        // 获取当前时间
        var calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        timeText.setText(timeFormat.format(calendar.getTime()));

        // 画时针，红色
        var hourLine = new Line();
        hourLine.setStartX(CIRCLE_CENTER_X);
        hourLine.setStartY(CIRCLE_CENTER_Y);
        hourLine.setEndX(calculateEndPointX(hour % 12 / 6.0 * PI, HOUR_HAND_LENGTH));
        hourLine.setEndY(calculateEndPointY(hour % 12 / 6.0 * PI, HOUR_HAND_LENGTH));
        hourLine.setStroke(Color.RED);

        // 画分针，绿色
        var minuteLine = new Line();
        minuteLine.setStartX(CIRCLE_CENTER_X);
        minuteLine.setStartY(CIRCLE_CENTER_Y);
        minuteLine.setEndX(calculateEndPointX(minute / 30.0 * PI, MINUTE_HAND_LENGTH));
        minuteLine.setEndY(calculateEndPointY(minute / 30.0 * PI, MINUTE_HAND_LENGTH));
        minuteLine.setStroke(Color.GREEN);

        // 画秒针，蓝色
        var secondLine = new Line();
        secondLine.setStartX(CIRCLE_CENTER_X);
        secondLine.setStartY(CIRCLE_CENTER_Y);
        secondLine.setEndX(calculateEndPointX(second / 30.0 * PI, SECOND_HAND_LENGTH));
        secondLine.setEndY(calculateEndPointY(second / 30.0 * PI, SECOND_HAND_LENGTH));
        secondLine.setStroke(Color.BLUE);

        // 将表框和三个针放在一个Pane里
        var clockPane = new Pane();
        clockPane.getChildren().add(circle);
        clockPane.getChildren().add(hourLine);
        clockPane.getChildren().add(minuteLine);
        clockPane.getChildren().add(secondLine);

        // 将时间文本和表放在一个大Pane里
        var fatherPane = new Pane();
        fatherPane.getChildren().add(timeText);
        fatherPane.getChildren().add(clockPane);

        // 设置动画，循环次数无限
        var timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        // 每一帧隔一秒一次，每次重新设置时间文本和绘画表针
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
        stage.setTitle("这是一块表");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 根据当前时间计算表针结束点的X坐标
     *
     * @param angle  弧度，时间 / 单位 * 2π
     * @param length 表针长度
     * @return 表针结束点X坐标
     */
    private double calculateEndPointX(double angle, double length) {
        return CIRCLE_CENTER_X + length * Math.sin(angle);
    }

    /**
     * 根据当前时间计算表针结束点的Y坐标
     *
     * @param angle  弧度，时间 / 单位 * 2π
     * @param length 表针长度
     * @return 表针结束点Y坐标
     */
    private double calculateEndPointY(double angle, double length) {
        return CIRCLE_CENTER_Y - length * Math.cos(angle);
    }

    /**
     * 更新时间
     */
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
