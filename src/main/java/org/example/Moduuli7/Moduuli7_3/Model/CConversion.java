package org.example.Moduuli7.Moduuli7_3.Model;

public class CConversion {

    public CConversion(){

    }
    //money conversion in multiple currencies
    public double convertToUSD(double amount, double rate) {

        return amount/rate;
    }

    //conversion from USD to other currencies
    public double convertFromUSD(double amount, double rate) {
        return amount*rate;
    }

    public double convert(double amount, String fromCurrency, double fromRate, String toCurrency, double toRate) {
        double result = 0;

        if (fromCurrency.equals(toCurrency)) {
            result = amount;
        } else if (fromCurrency.equals("USD")) {
            result = convertFromUSD(amount, toRate);
        } else if (toCurrency.equals("USD")){
            result = convertToUSD(amount, fromRate);

        } else {
            result = convertToUSD(amount, fromRate);
            result = convertFromUSD(result, toRate);
        }
        //return (Double.parseDouble(new DecimalFormat("#.##").format(result)));
        return result;
    }


}
