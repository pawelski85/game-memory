//package com.kodilla.game;
//
//import com.sun.javafx.*;
//import com.kodilla.game.*;
//import com.sun.javafx.iio.common.ImageTools;
//import javafx.application.*;
//import javafx.geometry.Insets;
//import javafx.geometry.Orientation;
//import javafx.geometry.Pos;
//import javafx.scene.Cursor;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.image.Image;
//import javafx.stage.Stage;
//import javafx.stage.Window;
//
//import java.awt.font.ImageGraphicAttribute;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.nio.file.*;
//import java.awt.*;
//import java.io.FileInputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.*;
//import java.util.List;
//import java.awt.geom.Rectangle2D;
//
//import javafx.scene.image.Image;
//import javafx.scene.*;
//import javafx.scene.Parent.*;
//import com.sun.javafx.cursor.*;
//import com.sun.javafx.cursor.CursorType;
//import com.sun.javafx.cursor.StandardCursorFrame;
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.FlowPane;
//import javafx.stage.Stage;
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.scene.layout.VBox;
//import javafx.scene.Parent;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import javax.accessibility.*;
//
//import javafx.application.Platform;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javafx.event.*;
//
//
//public class Game extends Application {
//
//    Druga druga = new Druga();
//
//    static int counter = 0;
//    static int counter2 = 0;
//    static int lastClickNumber;
//    static List<Button> buttonList = new ArrayList<>();
//    int imageId;
//    static FlowPane flow = new FlowPane();
//
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        //nazwa gry i wielkosc odstepow miedzy kolumnami
//        primaryStage.setTitle("Zgadywanka");
//        flow.setVgap(8);
//        flow.setHgap(4);
//        //generator listy i mieszanie listy
//        List<Integer> imageList = new ArrayList<>();
//        for (int i = 1; i <= 8; i++) {
//            imageList.add(i);
//        }
//        Collections.shuffle(imageList);
//        //przypisanie wartosci z listy do cyfr od 1-4
//        for (int i = 0; i <= imageList.size() - 1; i++) {
//
//            if (imageList.get(i) <= 4) {
//                imageId = imageList.get(i);
//            } else if (imageList.get(i) % 4 == 0) {
//                imageId = 4;
//            } else {
//                imageId = imageList.get(i) % 4;
//            }
//            //stworzenie buttonu
////            List<Button> buttonList = new ArrayList<>();
//            Button button = new Button("");
//            buttonList.add(button);
//            button.setPrefHeight(120);
//            button.setPrefWidth(120);
//            button.setId(String.valueOf(imageId));
////            System.out.println(buttonList.toString());
//            flow.getChildren().add(button);
//
//            //logika gry
//            button.setOnAction(event -> {
//                counter++;
//
//                Button clickedButton = (Button) event.getSource();
//                Image image = new Image(getClass().getResourceAsStream("/" + clickedButton.getId() + ".jpg"));
//                clickedButton.setGraphic(new ImageView(image));
//
//                if (counter % 2 == 0) {
//                    //buttonList bierzemy 0       bierzemy 1     jesli rowne drugie klikniecie.getID 1
//                    if (buttonList.get(lastClickNumber).getId().equals(clickedButton.getId())) {
//                        //System.out.println(clickedButton.getId());
//                        clickedButton.setDisable(true);
//                        buttonList.get(lastClickNumber).setDisable(true);
//                        counter2++;
//                        System.out.println(counter2);
//
//                        if (counter2 == 4) {
//                            System.out.println("you win");
//                            System.out.println(buttonList.size());
//                            buttonList=new ArrayList<>();
//
//                        }
//                    } else {
//                        buttonList.get(lastClickNumber).setGraphic(null);
//                        counter = 1;
//                    }
//                }
//                lastClickNumber = buttonList.indexOf(clickedButton);
//                System.out.println(lastClickNumber);
//            });
//        }
//
//        druga.start(primaryStage);
//
//    }
//
//    public static void main(String[] args) {
//
//        launch(args);
//    }
//
//    @Override
//    public void stop() throws Exception {
//        super.stop();
//        buttonList.clear();
//
//    }
//}
//
//class Druga extends Application {
//    Stage window;
//    Scene scene1, scene2, scene3;
//    Button button1 = new Button("HARD");
//    Button button2 = new Button("PLAY AGAIN");
//    Button button3 = new Button("restart");
//    Label label1 = new Label("Level");
//    VBox layout1 = new VBox(20);
//    VBox layout2 = new VBox(20);
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//
//        button1.setOnAction(e -> window.setScene(scene2));
//        layout1.getChildren().addAll(label1, button1);
//        scene1 = new Scene(layout1, 600, 600);
//
//        button2.setOnAction(e -> window.setScene(scene1));
//        layout2.getChildren().addAll(Game.flow, button2, button3);
//        scene2 = new Scene(layout2, 600, 600);
//
//        button3.setOnAction(e ->
//        {
//            Game game = new Game();
//            window.setScene(scene1);
//            try {
//                game.start(window);
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        });
//
//        window.setScene(scene1);
//        window.setTitle("MEMORY");
//        window.show();
//    }
//    public void winner() {
//        Label label3 = new Label("you won");
//        VBox layout3 = new VBox(20);
//        layout3.getChildren().addAll(Game.flow,label3,button2);
//        scene3 = new Scene(layout3, 600, 600);
//        window.setScene(scene3);
//    }
//}
