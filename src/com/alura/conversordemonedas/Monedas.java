package com.alura.conversordemonedas;

public class Monedas {

    private String conversionRate;
    private double conversionResult;

    public Monedas(MonedasConvertidas misMonedasConvertidas) {
        this.conversionRate = misMonedasConvertidas.conversion_rate();
        this.conversionResult = Double.parseDouble(misMonedasConvertidas.conversion_result());
/*
        if (MonedasConvertidas.conversion_result().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la diviza," +
                    "porque contiene un N/A");
*/
    }
    public String getConversionRate() {return conversionRate; }
    public void setConversionRate (String conversionRate) {
        this.conversionRate = conversionRate;
    }
    public double getConversionResult() {return conversionResult;}
    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }
        @Override
        public String toString () {
            return  "Resultado de la conversion=" + conversionResult+
                    ", Ratio de Conversion="+conversionRate;
        }
}
