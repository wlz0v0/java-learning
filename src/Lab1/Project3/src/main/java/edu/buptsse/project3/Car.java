package edu.buptsse.project3;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Car.java
 */
public class Car extends ImageView {
    private double speed;

    public Car() {
        this(100);
    }

    public Car(double speed) {
        super(new Image("file:.\\src\\Lab1\\Project3\\src\\main\\java\\edu\\buptsse\\project3\\car.jpg"));
        this.speed = speed;
        setFitWidth(76);
        setFitHeight(50.6);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
