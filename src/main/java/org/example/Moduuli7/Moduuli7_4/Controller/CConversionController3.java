package org.example.Moduuli7.Moduuli7_4.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Moduuli7.Moduuli7_4.Model.CConversion;
import org.example.Moduuli7.Moduuli7_4.sql.dao.CurrencyDao;
import org.example.Moduuli7.Moduuli7_4.View.CcView;
import org.example.Moduuli7.Moduuli7_4.sql.dao.TransactionDao;

import java.util.ArrayList;

public class CConversionController3 {
    CurrencyDao dao = new CurrencyDao();
    CConversion cc = new CConversion();
    CcView view = new CcView();


    @FXML
    private Button convertButton;

    @FXML
    private TextField fromText;

    @FXML
    private TextField toText;

    @FXML
    private ChoiceBox<String> fromBox;

    @FXML
    private ChoiceBox<String> toBox;

    @FXML
    private Label errorText;

    @FXML
    private TextField newCRate;

    @FXML
    private TextField newCName;

    @FXML
    private TextField newCAbb;

    @FXML
    private Label errorTextADC;



    public double convert(double amount, String currencyF, String currencyT) {
        double result = 0;

        //Getting the rate of the currency from the database.
        double fromRate = dao.getCurrency(currencyF).getRate();
        double toRate = dao.getCurrency(currencyT).getRate();

        return cc.convert(amount, currencyF, fromRate, currencyT, toRate);
    }

    public ArrayList<String> getCurrencyCodes() {
        return dao.getCurrencyCodes();
    }

    public void convertt() {
        try{
            if(!dao.connectionToString()) {
                errorText.setText("No connection to database");

            }
            else {
                try {
                    double amount = Double.parseDouble(fromText.getText());
                    String currencyF = fromBox.getValue();
                    String currencyT = toBox.getValue();
                    double result = convert(amount, currencyF, currencyT);
                    toText.setText(String.valueOf(result));
                    errorText.setText("");
                } catch (Exception e) {
                    errorText.setText("Invalid input");
                }
            }
        }catch (Exception e) {e.printStackTrace();}

    }

    public void setMainApp() {
        setCurrencies();
        fromBox.setValue("USD");
        toBox.setValue("EUR");

        fromText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*([\\.]\\d*)?")) {
                    fromText.setText(oldValue);
                }
            }
        });



    }

    public void setSecondApp(){


        newCRate.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*([\\.]\\d*)?")) {
                    newCRate.setText(oldValue);
                }
            }
        });

        newCAbb.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                newValue = newValue.toUpperCase();
                if (!newValue.matches("[A-Z]*")) {
                    newCAbb.setText(oldValue);
                } else {
                    newCAbb.setText(newValue);
                }
            }
        });

        newCName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[a-z A-Z]*")) {
                    newCName.setText(oldValue);
                }
            }
        });
    }

    public void setCurrencies() {
        try {
            fromBox.getItems().clear();
            toBox.getItems().clear();
            fromBox.getItems().addAll(getCurrencyCodes());
            toBox.getItems().addAll(getCurrencyCodes());

        }catch (Exception e) {
            errorText.setText("No connection to database");
        }

    }

    public void openAddWindow() {
        view.addMoneyWindow();

    }


    public void AddNewCurrency(ActionEvent actionEvent) {
        if (newCName.getText().isEmpty() || newCAbb.getText().isEmpty() || newCRate.getText().isEmpty()) {
            errorTextADC.setText("Fill all the fields");
            errorTextADC.setStyle("-fx-text-fill: red");
        } else {
            try {
                dao.addCurrency(newCName.getText(), newCAbb.getText(), Double.parseDouble(newCRate.getText()));
                errorTextADC.setText("Currency added");
                errorTextADC.setStyle("-fx-text-fill: green");

            } catch (Exception e) {
                errorTextADC.setText("Invalid input");
                errorTextADC.setStyle("-fx-text-fill: red");
            }
        }

    }
}