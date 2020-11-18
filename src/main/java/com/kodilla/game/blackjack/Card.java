package com.kodilla.game.blackjack;

import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;

public class Card {
    private Image duck=new Image("file:src/main/resources/duck.jpg");
    private FlowPane photos=new FlowPane(Orientation.HORIZONTAL);

    public Image getCardImage() {
        return duck;
    }

    public void setDuck(Image duck) {
        this.duck = duck;
    }

    public FlowPane getPhotos() {
        return photos;
    }

    public void setPhotos(FlowPane photos) {
        this.photos = photos;
    }
}
