package org.example.Moduuli6.Moduuli6_2.Controller;

import org.example.Moduuli6.Moduuli6_2.Model.CConversion;

public class CConversionController {

    private CConversion CConverion;
    public CConversionController(CConversion cc){
        this.CConverion = cc;
    }

    public double convert(double amount, String currencyF, String currencyT){

        return CConverion.convert(amount, currencyF, currencyT);
    }
}
