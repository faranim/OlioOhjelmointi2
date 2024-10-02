package org.example.Moduuli7.Moduuli7_2.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.Moduuli7.Moduuli7_2.Model.CConversion;
import org.example.Moduuli7.Moduuli7_2.sql.dao.CurrencyDao;
import java.util.ArrayList;

public class CConversionController2 {
    CurrencyDao dao = new CurrencyDao();
    CConversion cc = new CConversion();


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
        try{ dao.connectionToString();
            if(dao.connectionToString().equals("Null")) {
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

    public void setCurrencies() {
        try {
            fromBox.getItems().addAll(getCurrencyCodes());
            toBox.getItems().addAll(getCurrencyCodes());

        }catch (Exception e) {
            errorText.setText("No connection to database");
        }

    }


}
