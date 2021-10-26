package edu.buptsse.question2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        var rectangle = new Rectangle();
        rectangle.setHeight(200);
        rectangle.setWidth(500);
        var pane = new FlowPane();

        pane.getChildren().add(rectangle);
        pane.setAlignment(Pos.CENTER);
        var scene = new Scene(pane, 1000, 400);
        rectangle.heightProperty()
                .bind(scene.heightProperty().divide(2));
        rectangle.widthProperty()
                .bind(scene.widthProperty().divide(2));
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->
        {
            var clickX = mouseEvent.getX();
            var clickY = mouseEvent.getY();
            var recHeight = rectangle.getHeight();
            var recWidth = rectangle.getWidth();
            if (clickX >= recWidth / 2
                    && clickX <= recWidth / 2 * 3
                    && clickY >= recHeight / 2
                    && clickY <= recHeight / 2 * 3) {
                System.out.println("in");
            } else {
                System.out.println("out");
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}