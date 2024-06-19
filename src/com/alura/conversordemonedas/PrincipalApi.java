package com.alura.conversordemonedas;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class PrincipalApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
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
        System.out.println(json);
        Gson gson = new Gson();
        MonedasConvertidas misMonedasConvertidas = gson.fromJson(json, MonedasConvertidas.class) ;
        System.out.println(misMonedasConvertidas);
        Monedas misMonedas = new Monedas(misMonedasConvertidas);
        System.out.println("El resulTado de la conversion entre: " + moneda+ " y " + moneda2+ " es:  "+ misMonedas.getConversionResult());
    }
}
