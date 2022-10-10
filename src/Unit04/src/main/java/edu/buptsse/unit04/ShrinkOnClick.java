package edu.buptsse.unit04;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ShrinkOnClick implements EventHandler<MouseEvent> {
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
