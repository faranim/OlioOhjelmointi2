package org.example.Moduuli6.Moduuli6_2.View;

import org.example.Moduuli6.Moduuli6_2.Controller.CConversionController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.Moduuli6.Moduuli6_2.Model.CConversion;

import java.text.DecimalFormat;

public class CConversionView extends Application {
    CConversionController cc = new CConversionController(new CConversion());

    VBox main = new VBox();

    GridPane gridF = new GridPane();

    GridPane gridT = new GridPane();

    Label fromText = new Label("From: ");
    Label toText = new Label("To: ");

    TextField from = new TextField();
    TextField to = new TextField();

    ChoiceBox<String> fromBox = new ChoiceBox<>();

    ChoiceBox<String> toBox = new ChoiceBox<>();
    Label error = new Label();



    Button convert = new Button("Convert");

    @Override
    public void start(Stage stage) throws Exception {



        fromBox.getItems().addAll("USD", "EUR", "GBP", "JPY", "CNY", "RUB", "INR", "AUD", "CAD", "SGD", "CHF", "MYR", "THB", "IDR", "KRW", "TRY", "MXN", "BRL", "ZAR", "HKD", "NZD", "SEK", "NOK", "DKK", "PLN", "HUF");
        fromBox.setValue("USD");
        toBox.getItems().addAll("USD", "EUR", "GBP", "JPY", "CNY", "RUB", "INR", "AUD", "CAD", "SGD", "CHF", "MYR", "THB", "IDR", "KRW", "TRY", "MXN", "BRL", "ZAR", "HKD", "NZD", "SEK", "NOK", "DKK", "PLN", "HUF");
        toBox.setValue("EUR");
        from.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*([\\.]\\d*)?")) {
                    from.setText(oldValue);
                }
            }
        });

        convert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isValid();
            }
        });

        gridF.add(fromText, 0, 0);
        fromText.setPadding(new Insets(0, 10, 0, 10));
        gridF.add(from, 1, 0);
        gridF.add(fromBox, 2, 0);

        gridT.add(toText, 0, 0);
        toText.setPadding(new Insets(0, 24, 0, 10));
        gridT.add(to, 1, 0);
        gridT.add(toBox, 2, 0);

        gridF.setPadding(new Insets(10, 10, 10, 10));
        gridF.setAlignment(Pos.CENTER);

        gridT.setPadding(new Insets(10, 10, 10, 10));
        gridT.setAlignment(Pos.CENTER);

        GridPane convertGrid = new GridPane();
        convertGrid.add(convert, 0, 0);
        convert.setPadding(new Insets(5, 100,5 , 100));
        convertGrid.setPadding(new Insets(10, 10, 10, 10));
        convertGrid.setAlignment(Pos.CENTER);





        main.getChildren().add(gridF);
        main.getChildren().add(gridT);
        main.getChildren().add(convertGrid);

        main.getChildren().add(error);

        Scene scene = new Scene(main, 300, 150);

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();



    }

    public String getFromCurrency(){
        return fromBox.getValue();
    }

    public String getToCurrency(){
        return toBox.getValue();
    }

    public double getFromAmount(){
        String formattedInput = from.getText().replace(",", ".");
        return Double.parseDouble(formattedInput);
    }

    public void isValid(){
        try {
            //fromat , to .

            String formattedInput = from.getText().replace(",", ".");
            Double result = cc.convert(Double.parseDouble(formattedInput), fromBox.getValue(), toBox.getValue());
            System.out.println(result);
            this.to.setText(new DecimalFormat("#.##").format(result));


        } catch (NumberFormatException e) {
            error.setText("Error: Invalid input. Please enter a number");

        }
    }

}

