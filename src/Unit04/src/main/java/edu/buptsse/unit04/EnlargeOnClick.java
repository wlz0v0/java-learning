package edu.buptsse.unit04;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EnlargeOnClick implements EventHandler<MouseEvent> {
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
