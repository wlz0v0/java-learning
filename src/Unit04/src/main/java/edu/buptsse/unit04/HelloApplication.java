package edu.buptsse.unit04;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button button1 = new Button();
        button1.setText("按钮1");

        Button button2 = new Button();
        button2.setText("按钮2");

        HBox hBox = new HBox();
        hBox.getChildren().add(button1);
        hBox.getChildren().add(button2);
        hBox.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setText("咏鹅\n" +
                "鹅鹅鹅，\n" +
                "曲项向天歌。\n" +
                "白毛浮绿水，\n" +
                "红掌拨清波。");

        String[][] bagua = {{"乾", "坤", "震", "巽"},
                {"坎", "离", "艮", "兑"}};
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 2; ++j) {
                TextField field = new TextField();
                field.setText(bagua[j][i]);
                gridPane.add(field, i, j);
            }
        }

        TextField topTextField = new TextField();
        topTextField.setText("56个民族图标顺序排列");

        ImageView image = new ImageView("file:C:\\MyProject\\Java\\Windows\\Java2021\\src\\Unit04\\src\\main\\resources\\edu\\buptsse\\unit04\\taiji.jpg");

        BorderPane pane = new BorderPane();
        pane.setBottom(hBox);
        pane.setTop(topTextField);
        pane.setLeft(textField);
        pane.setCenter(gridPane);
        pane.setRight(image);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        BorderPane.setAlignment(textField, Pos.CENTER);
        BorderPane.setAlignment(gridPane, Pos.CENTER);

        Scene scene = new Scene(pane, 1000, 400);
        stage.setTitle("Unit04 JavaFX learning");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}