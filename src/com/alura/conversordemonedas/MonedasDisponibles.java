package com.alura.conversordemonedas;
import java.util.ArrayList;
import java.util.Arrays;

public class MonedasDisponibles {


    private String result;
    private String[][] supportedCodes;

    public MonedasDisponibles(MonedasDisponiblesApi misMonedasDisponiblesApi) {
        this.result = misMonedasDisponiblesApi.result();
        this.supportedCodes = (misMonedasDisponiblesApi.supported_codes());

    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String[][] getSupportedCodes() {
        return supportedCodes;
    }

    public void setSupportedCodes(String[][] supportedCodes) {
        this.supportedCodes = supportedCodes;
    }

    public void impMonedasDisponibles() {

        for (int i = 0; i < (supportedCodes.length)-4; i = i+5    ){
            int j = 0;
            System.out.printf("%-45S",supportedCodes[i][j] + " " + supportedCodes[i][j+1] + " ");
            System.out.printf("%-50S",supportedCodes[i+1][j] + " " + supportedCodes[i+1][j+1] + " ");
            System.out.printf("%-45S",supportedCodes[i+2][j] + " " + supportedCodes[i+2][j+1] + " ");
            System.out.printf("%-45S",supportedCodes[i+3][j] + " " + supportedCodes[i+3][j+1] + " ");
            System.out.printf("%-45S %n",supportedCodes[i+4][j] + " " + supportedCodes[i+4][j+1] + " ");
        }
    }

}


