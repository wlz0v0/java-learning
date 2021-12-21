package edu.question4;

import edu.question4.PubSub.Buffer;
import edu.question4.PubSub.Publisher;
import edu.question4.PubSub.Subscriber;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Question4 extends Application {
    public static int bufferNum = 8;
    public static int msgCnt = 20;
    public static ArrayList<TextField> textFields = new ArrayList<>();
    public static TextField pubTextField;
    public static TextField subTextField;
    volatile static boolean isLaunchFinished = false;

    @SuppressWarnings("BusyWait")
    public static void main(String[] args) {
        new Thread(Application::launch).start();
        // 实例化所需对象
        var buffer = new Buffer(bufferNum);
        var pub = new Publisher(buffer);
        var sub = new Subscriber(buffer);
        var random = new Random();

        // 创建一个线程，发送msgCnt条消息
        new Thread(() -> {
            // 等待GUI启动完毕
            while (!isLaunchFinished) {
                Thread.onSpinWait();
            }
            for (int i = 0; i < msgCnt; ++i) {
                pub.publish();
                try {
                    // 发布后睡眠不超过0.5s的随机时间
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 创建一个线程，接收msgCnt条消息
        new Thread(() -> {
            // 等待GUI启动完毕
            while (!isLaunchFinished) {
                Thread.onSpinWait();
            }
            for (int i = 0; i < msgCnt; ++i) {
                sub.subscribe();
                try {
                    // 接收后睡眠不超过0.5s的随机时间
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void start(Stage stage) {
        var gridPane = new GridPane();
        // 设置边距
        gridPane.setPadding(new Insets(50, 20, 50, 20));
        gridPane.setHgap(15);
        // 设置三个列宽为300
        gridPane.getColumnConstraints().add(new ColumnConstraints(300));
        gridPane.getColumnConstraints().add(new ColumnConstraints(300));
        gridPane.getColumnConstraints().add(new ColumnConstraints(300));
        // 设置第一行高50，第二行高250
        gridPane.getRowConstraints().add(new RowConstraints(50));
        gridPane.getRowConstraints().add(new RowConstraints(250));

        // Publisher区域
        var pubLabel = new Label("Publisher");
        pubTextField = new TextField();
        pubTextField.setAlignment(Pos.CENTER);
        gridPane.add(pubLabel, 0, 0);
        gridPane.add(pubTextField, 0, 1);

        // Buffer区域
        var bufferLabel = new Label("Buffer");
        gridPane.add(bufferLabel, 1, 0);
        var vBox = new VBox();
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(10, 0, 0, 0));
        gridPane.add(vBox, 1, 1);
        // 根据缓冲区大小创建
        for (int i = 0; i < bufferNum; ++i) {
            var txt = new TextField();
            vBox.getChildren().add(txt);
            textFields.add(txt);
        }

        // Subscriber区域
        var subLabel = new Label("Subscriber");
        gridPane.add(subLabel, 2, 0);
        subTextField = new TextField();
        gridPane.add(subTextField, 2, 1);

        var scene = new Scene(gridPane, 970, 500);
        stage.setScene(scene);
        stage.show();
        // 启动完毕
        isLaunchFinished = true;
    }
}