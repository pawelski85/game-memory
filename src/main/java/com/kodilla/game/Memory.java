package com.kodilla.game;

import com.sun.javafx.*;
import com.kodilla.game.*;
import com.sun.javafx.iio.common.ImageTools;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

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
import java.awt.geom.Rectangle2D;

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
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.ObjectInputStream;
import javax.accessibility.*;

import javafx.application.Platform;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.*;

public class Memory extends Application {

    static int counter = 0;
    static int counter2 = 0;
    static int counter3=0;
    static int lastClickNumber;
    static List<Button> buttonList = new ArrayList<>();
    int imageId;
    static List<Integer> usedButtons = new ArrayList<>();
    static int x;
    static int y;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // budowanie sceny
        FlowPane flow = new FlowPane();
        flow.setVgap(8);
        flow.setHgap(4);
        Stage window;
        Scene scene1, scene2;

        Button button1 = new Button("EASY");
        Button button2 = new Button("CHANGE LEVEL");
        Button button3 = new Button();

        Label label1 = new Label("Level");

        VBox layout1 = new VBox(20);
        VBox layout2 = new VBox(20);

        window = primaryStage;
        scene2 = new Scene(layout2, 600, 600);
        button1.setOnAction(e -> window.setScene(scene2));
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 600, 600);

        button2.setOnAction(e -> window.setScene(scene1));
        layout2.getChildren().addAll(flow, button2);

        window.setScene(scene1);
        window.setTitle("MEMORY");
        window.show();

        //generator listy i mieszanie listy
        List<Integer> imageList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            imageList.add(i);
        }
        Collections.shuffle(imageList);
        //przypisanie wartosci z listy do cyfr od 1-4
        for (int i = 0; i <= imageList.size() - 1; i++) {

            if (imageList.get(i) <= 4) {
                imageId = imageList.get(i);
            } else if (imageList.get(i) % 4 == 0) {
                imageId = 4;
            } else {
                imageId = imageList.get(i) % 4;
            }
            //stworzenie buttonu
//          List<Button> buttonList = new ArrayList<>();
            Button button = new Button("");
            buttonList.add(button);
            button.setPrefHeight(120);
            button.setPrefWidth(120);
            button.setId(String.valueOf(imageId));
//            System.out.println(buttonList.toString());
            flow.getChildren().add(button);


            //logika gry
            button.setOnAction(event -> {
                counter++;
                Button clickedButton = (Button) event.getSource();
                Image image = new Image(getClass().getResourceAsStream("/" + clickedButton.getId() + ".jpg"));
                clickedButton.setGraphic(new ImageView(image));

                if (counter % 2 == 0) {
                    //buttonList bierzemy 0       bierzemy 1     jesli rowne drugie klikniecie.getID 1
                    if (lastClickNumber == buttonList.indexOf(clickedButton)) {
                        System.out.println("dont cheat");
                        counter=1;
                    } else {
                        if (buttonList.get(lastClickNumber).getId().equals(clickedButton.getId())) {
                            //System.out.println(clickedButton.getId());
                            clickedButton.setDisable(true);
                            buttonList.get(lastClickNumber).setDisable(true);
                            usedButtons.add(lastClickNumber);
                            usedButtons.add(buttonList.indexOf(clickedButton));
                            counter2++;
                            // System.out.println(counter2);
//                            if (counter2 == 4) {
//                                System.out.println("you win");
//                                System.out.println(buttonList.size());
//                                buttonList = new ArrayList<>();
//                            }

                            if(usedButtons.size()< buttonList.size()){
                            Random generator = new Random();
                                //System.out.println("tutaj");
                            do {
                                x = generator.nextInt(buttonList.size());
                            }
                            while (usedButtons.contains(x));
                            if (!usedButtons.contains(x)) {

                                Button newClickedButton = buttonList.get(x);
                                newClickedButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/" + newClickedButton.getId() + ".jpg"))));
                                do {
                                    y = generator.nextInt(buttonList.size());
                                }
                                while (usedButtons.contains(y)||y==x);
                                if (!usedButtons.contains(y)) {

                                    Button newClickedButton2 = buttonList.get(y);
                                    newClickedButton2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/" + newClickedButton2.getId() + ".jpg"))));
                                    if (newClickedButton.getId().equals(newClickedButton2.getId())) {
                                        usedButtons.add(x);
                                        usedButtons.add(y);
                                        counter3++;
                                        //System.out.println(clickedButton.getId());
                                        newClickedButton.setDisable(true);
                                        newClickedButton2.setDisable(true);
                                        //lastClickNumber = buttonList.indexOf(y);
                                        System.out.println("komputer zgadl");
                                    } else {
                                        newClickedButton.setGraphic(null);
                                        newClickedButton2.setGraphic(null);
                                        //newClickedButton.setGraphic(null);
                                        //buttonList.get(x).setGraphic(null);
                                        //                                        lastClickNumber = buttonList.indexOf(newClickedButton2);
//                                        counter = 1;
                                        // buttonList.get(lastClickNumber).setGraphic(null);
                                        System.out.println("komputer nie zgadl");

                                    }
                                }
                            }}

                        } else {
                            buttonList.get(lastClickNumber).setGraphic(null);
                            counter = 1;
                        }
                    }
                    if(counter2+counter3==4) {
                        if(counter2>counter3) {
                            //You win
                            button3.setText("YOU WIN PLAY AGAIN");
                        }
                        else{
                            //Draw
                            button3.setText("DRAW PLAIN AGAIN");
                        }
                        layout2.getChildren().addAll(button3);
                    }

                }

                lastClickNumber = buttonList.indexOf(clickedButton);
                //System.out.println(lastClickNumber);
               // if(counter2+counter3==buttonList.size()/2){
                //}


            });

        }
    }

    public static void main(String[] args) {
        launch();
    }
}
