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
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(200);
        rectangle.setWidth(500);
        FlowPane pane = new FlowPane();

        pane.getChildren().add(rectangle);
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 1000, 400);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            double clickX = mouseEvent.getX();
            double clickY = mouseEvent.getY();
            double recHeight = rectangle.getHeight();
            double recWidth = rectangle.getWidth();
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
        Thread adaptSizeThread = new Thread(() -> {
            while (true) {
                rectangle.setWidth(scene.getWidth() / 2);
                rectangle.setHeight(scene.getHeight() / 2);
            }
        });
        adaptSizeThread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}