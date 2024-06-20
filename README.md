# Project Title

Conversor de Monedas. AluraxOracle Java Bootcamp

## Description

This project help us to make converison between different currencies. in this project we used an API from https://www.exchangerate-api.com/.

## Getting Started

### Dependencies

Windows 10 or above
Librarys as Gson and java.util.scanner;


### Installing

you can found this program on www.Github.com/cledgo

### Executing program

//TO CALL ALL THE AVAILABLE CURRENCIS:
HttpClient client1 = HttpClient.newHttpClient();

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/3a117b967a3322801a9a501b/codes"))
                .build();

        HttpResponse<String> response1 = client1
                .send(request1, HttpResponse.BodyHandlers.ofString());


//TO MAKE THE CONVERSION
 HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

//ALL OF THE REST ARE SOUT, SCANNERS AND INFORMATION CONVERSION WITH GSON

Gson gson = new Gson();

## Help

Any advise for common problems or issues.
produccionescledgo@gmail.com

## Authors

Contributors names and contact info

Claudio Gonzalez
Linkedin.com/in/cledgo

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the [Claudio Gonzalez] License - see the LICENSE.md file for details
