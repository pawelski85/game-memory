package com.kodilla.game;

import com.sun.javafx.*;
import com.kodilla.game.*;
import com.sun.javafx.iio.common.ImageTools;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.font.ImageGraphicAttribute;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.*;
import java.awt.*;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.*;
import javafx.scene.Parent.*;
import com.sun.javafx.cursor.*;
import com.sun.javafx.cursor.CursorType;
import com.sun.javafx.cursor.StandardCursorFrame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Game extends Application {
    static int counter = 0;
    List<Button> buttonList = new ArrayList<>();
    static int lastClickNumber;
    static int imageId;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //nazwa gry i wielkosc odstepow miedzy kolumnami
        primaryStage.setTitle("Zgadywanka");
        FlowPane flow = new FlowPane();
        flow.setVgap(8);
        flow.setHgap(4);
        //generator listy i mieszanie listy
        List<Integer> imageList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            imageList.add(i);
        } Collections.shuffle(imageList);
        //przypisanie wartosci z listy do cyfr od 1-4
        for (int i = 0; i <= imageList.size()-1; i++) {

            if (imageList.get(i) <= 4) {
                imageId = imageList.get(i);
            }
            else if(imageList.get(i)%4 ==0){
                imageId = 4;
            }
            else {
                imageId = imageList.get(i)%4;
            }
            //stworzenie buttonu
            Button button = new Button("");
            buttonList.add(button);
            button.setPrefHeight(120);
            button.setPrefWidth(120);
            button.setId(String.valueOf(imageId));
            //System.out.println(buttonList.toString());
            flow.getChildren().add(button);
            //logika gry
            button.setOnAction(event -> {
                counter++;

                Button clickedButton = (Button) event.getSource();
                Image image = new Image(getClass().getResourceAsStream("/" + clickedButton.getId() + ".jpg"));
                clickedButton.setGraphic(new ImageView(image));

                if (counter % 2 == 0) {
                    //buttonList bierzemy 0       bierzemy 1     jesli rowne drugie klikniecie.getID 1
                    if (buttonList.get(lastClickNumber).getId().equals(clickedButton.getId())) {
                        System.out.println(clickedButton.getId());
                        clickedButton.setDisable(true);
                        buttonList.get(lastClickNumber).setDisable(true);
                    } else {
                        buttonList.get(lastClickNumber).setGraphic(null);
                        counter = 1;
                    }

                }
                lastClickNumber = buttonList.indexOf(clickedButton);
                //System.out.println(lastClickNumber);
            });

        }
        primaryStage.setScene(new Scene(flow, 500, 300));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
