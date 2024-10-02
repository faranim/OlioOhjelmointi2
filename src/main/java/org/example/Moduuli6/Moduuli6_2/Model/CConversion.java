package org.example.Moduuli6.Moduuli6_2.Model;

import java.text.DecimalFormat;

public class CConversion {

    public CConversion(){

    }
    //money conversion in multiple currencies
    public double convertToUSD(double amount, String currency) {
        double result = 0;
        switch (currency) {
            case "EUR":
                result = amount * 1.18;
                break;
            case "GBP":
                result = amount * 1.38;
                break;
            case "JPY":
                result = amount * 0.0091;
                break;
            case "CNY":
                result = amount * 0.16;
                break;
            case "RUB":
                result = amount * 0.013;
                break;
            case "INR":
                result = amount * 0.014;
                break;
            case "AUD":
                result = amount * 0.74;
                break;
            case "CAD":
                result = amount * 0.79;
                break;
            case "SGD":
                result = amount * 0.74;
                break;
            case "CHF":
                result = amount * 1.08;
                break;
            case "MYR":
                result = amount * 0.24;
                break;
            case "THB":
                result = amount * 0.032;
                break;
            case "IDR":
                result = amount * 0.000071;
                break;
            case "KRW":
                result = amount * 0.00089;
                break;
            case "TRY":
                result = amount * 0.12;
                break;
            case "MXN":
                result = amount * 0.050;
                break;
            case "BRL":
                result = amount * 0.18;
                break;
            case "ZAR":
                result = amount * 0.067;
                break;
            case "HKD":
                result = amount * 0.13;
                break;
            case "NZD":
                result = amount * 0.70;
                break;
            case "SEK":
                result = amount * 0.12;
                break;
            case "NOK":
                result = amount * 0.12;
                break;
            case "DKK":
                result = amount * 0.16;
                break;
            case "PLN":
                result = amount * 0.27;
                break;
            case "HUF":
                result = amount * 0.0033;
        }
        return result;
    }

    //conversion from USD to other currencies
    public double convertFromUSD(double amount, String currency) {
        double result = 0;
        switch (currency) {
            case "EUR":
                result = amount * 0.85;
                break;
            case "GBP":
                result = amount * 0.72;
                break;
            case "JPY":
                result = amount * 110.19;
                break;
            case "CNY":
                result = amount * 6.43;
                break;
            case "RUB":
                result = amount * 74.89;
                break;
            case "INR":
                result = amount * 73.51;
                break;
            case "AUD":
                result = amount * 1.35;
                break;
            case "CAD":
                result = amount * 1.27;
                break;
            case "SGD":
                result = amount * 1.35;
                break;
            case "CHF":
                result = amount * 0.93;
                break;
            case "MYR":
                result = amount * 4.13;
                break;
            case "THB":
                result = amount * 31.25;
                break;
            case "IDR":
                result = amount * 14000;
                break;
            case "KRW":
                result = amount * 1120;
                break;
            case "TRY":
                result = amount * 8.43;
                break;
            case "MXN":
                result = amount * 19.95;
                break;
            case "BRL":
                result = amount * 5.31;
                break;
            case "ZAR":
                result = amount * 14.89;
                break;
            case "HKD":
                result = amount * 7.77;
                break;
            case "NZD":
                result = amount * 1.42;
                break;
            case "SEK":
                result = amount * 8.48;
                break;
            case "NOK":
                result = amount * 8.48;
                break;
            case "DKK":
                result = amount * 6.48;
                break;
            case "PLN":
                result = amount * 3.71;
                break;
            case "HUF":
                result = amount * 300.25;
        }
        return result;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double result = 0;

        if (fromCurrency.equals(toCurrency)) {
            result = amount;
        } else if (fromCurrency.equals("USD")) {
            result = convertFromUSD(amount, toCurrency);
        } else if (toCurrency.equals("USD")){
            result = convertToUSD(amount, fromCurrency);

        } else {
            result = convertToUSD(amount, fromCurrency);
            result = convertFromUSD(result, toCurrency);
        }
        //return (Double.parseDouble(new DecimalFormat("#.##").format(result)));
        return result;
    }


}
