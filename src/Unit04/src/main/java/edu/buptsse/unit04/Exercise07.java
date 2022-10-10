package edu.buptsse.unit04;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise07 extends Application {
    public static class EnlargeOnClick implements EventHandler<MouseEvent> {
        ImageView imageView;

        public EnlargeOnClick(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            imageView.setFitHeight(400);
            imageView.setFitWidth(600);
        }
    }

    public static class ShrinkOnClick implements EventHandler<MouseEvent> {
        ImageView imageView;

        public ShrinkOnClick(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            imageView.setFitWidth(300);
            imageView.setFitHeight(200);
        }
    }

    @Override
    public void start(Stage stage) {
//        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));
        var chinaFlagImage = new Image("file:./src/main/resources/edu/buptsse/unit04/flag4096.png");
        var imageView = new ImageView();
        imageView.setImage(chinaFlagImage);
        imageView.setFitHeight(200);
        imageView.setFitWidth(300);

        var enlargeButton = new Button();
        enlargeButton.setText("国旗变大");
        enlargeButton.setOnMouseClicked(new EnlargeOnClick(imageView));

        var shrinkButton = new Button();
        shrinkButton.setText("国旗变小");
        shrinkButton.setOnMouseClicked(new ShrinkOnClick(imageView));

        var hBox = new HBox();
        hBox.getChildren().add(enlargeButton);
        hBox.getChildren().add(shrinkButton);
        hBox.setAlignment(Pos.CENTER);


        var root = new Pane();
        root.getChildren().add(imageView);
        root.getChildren().add(hBox);
        var scene = new Scene(root);


        stage.setTitle("五星红旗迎风飘扬");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
