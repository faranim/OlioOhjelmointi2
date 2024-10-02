package org.example.Moduuli6.Moduuli6_3.View;

import org.example.Moduuli6.Moduuli6_3.Controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.Moduuli6.Moduuli6_3.Model.Pet;

public class PetView extends Application {
    PetController cc = new PetController(new Pet());


    Image pet = new Image("https://preview.redd.it/dqp8sol5pvu51.png?auto=webp&s=6443b22ebe5c4eea26b4b43c0ccccd5e21543413", 50, 100, false, false);



    Canvas canvas = new Canvas(800, 600);

    boolean mouseExists = false;

    double x = 50;
    double y = 50;
    ImageView imageView = new ImageView(pet);


    @Override
    public void start(Stage stage) throws Exception {


        AnchorPane stack = new AnchorPane(canvas);
        stack.getChildren().add(imageView);


        canvas.setOnMouseMoved(e -> {
            setLocation(e.getX(), e.getY());

        });


        canvas.setOnMouseEntered(e -> {
            mouseExists = true;
            new Thread(() -> {
                while (mouseExists) {
                    try {
                        System.out.println("x: " + x + " y: " + y);
                        updateLocation();
                        imageView.setLayoutX(x);
                        imageView.setLayoutY(y);

                        Thread.sleep(5);

                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }).start();
        });

        canvas.setOnMouseExited(e -> {
            mouseExists = false;

        });







        Scene scene = new Scene(stack, 700, 500);


        stage.setTitle("pet");
        stage.setScene(scene);
        stage.show();



    }

    public void setLocation(double x, double y){
        try {
            cc.updateTargetLocation(x, y);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void updateLocation(){
        try {
            cc.updateLocation();
            x = cc.getLocationX();
            y = cc.getLocationY();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
