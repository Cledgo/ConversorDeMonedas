package com.alura.conversordemonedas;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalApi {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        HttpClient client1 = HttpClient.newHttpClient();

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/3a117b967a3322801a9a501b/codes"))
                .build();

        HttpResponse<String> response1 = client1
                .send(request1, HttpResponse.BodyHandlers.ofString());
        String json1 = response1.body();
        Gson gson = new Gson();
        // System.out.println(json1);
        MonedasDisponiblesApi misMonedasDisponiblesApi = gson.fromJson(json1, MonedasDisponiblesApi.class);
        MonedasDisponibles misMonedasDisponibles = new MonedasDisponibles(misMonedasDisponiblesApi);

        int s = 0;
        while(s == 0){
         System.out.println("Hola! Este programa te ayudara a convertir 161 monedas diferentes entre ellas");
         System.out.println("Nuestro programa utiliza la notación ISO 4217 PARA BUSCAR TUS DENOMINACIONES ");
         System.out.println("Las denominaciones y codigos mas comunes son las siguientes:");
         System.out.println("Dólar americano - USD"+"   "+" Euro - EUR"+"   "+"Libra esterlina - GBP"+"   "+"Franco Suizo - CHF"+"   "+"Yen jappones - JPY"+"   "+"Dolar hongkones - HKD");
         System.out.println("Dolar canadiense CAD"+"   "+"Yuan chino CNY"+"   "+"Dolar australiano - AUD"+"   "+"Real Brasileño - BRL"+"   "+"Rublo ruso -RUB"+"   "+"Peso Mexicano - MXN");
         System.out.println("Si usted no ve la moneda que desea utilizar y desea desplegar una lista detallada de las monedas que ofrecemos y sus codigos por favor presione el numero 1, si no lo desea favor de presionar cualquier numero.");

         String m;
         m = lectura.nextLine();

         if (Integer.parseInt(m) == 1) {
             misMonedasDisponibles.impMonedasDisponibles();
         }
        System.out.println("Elija la moneda que quiere convertir");
        var moneda = lectura.nextLine();
        System.out.println("Elija la CANTIDAD que quiere convertir");
        var amount = lectura.nextLine();
        System.out.println("Elija la moneda en la que quiere convertir su eleccion");
        var moneda2 = lectura.nextLine();
        var conversion = moneda + "/" + moneda2+ "/"+ amount;
        String direccion = "https://v6.exchangerate-api.com/v6/3a117b967a3322801a9a501b/pair/"+conversion.toUpperCase();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

//        System.out.println(json);
        MonedasConvertidas misMonedasConvertidas = gson.fromJson(json, MonedasConvertidas.class) ;
//        System.out.println(misMonedasConvertidas);
        Monedas misMonedas = new Monedas(misMonedasConvertidas);
            System.out.println(" ");
            System.out.println("*************************************************************************************************************");
            System.out.println(" ");
            System.out.println("El resultado de la conversion entre: " + moneda+ " y " + moneda2+ " es:  "+ misMonedas.getConversionResult());
            System.out.println(" ");
            System.out.println("*************************************************************************************************************");
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("*************************************************************************************************************");
            System.out.println("*************************************************************************************************************");
            System.out.println(" ");
            System.out.println("¿Gusta realizar alguna ota conversión?"+ "   "+ "presione 0 para continuar o cualquier otro numero para salir");
            System.out.println(" ");
            System.out.println("*************************************************************************************************************");
            System.out.println("*************************************************************************************************************");
            s= Integer.parseInt(lectura.nextLine());
        }
        System.out.println("*************************************************************************************************************");
        System.out.println("*************************************************************************************************************");
        System.out.println(" ");
        System.out.println("GRACIAS POR UTILIZAR NUESTRO SISTEMA DE CONVERISON DE MONEDAS");
        System.out.println(" ");
        System.out.println("*************************************************************************************************************");
        System.out.println("*************************************************************************************************************");
    }
}
