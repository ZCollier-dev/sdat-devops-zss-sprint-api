package org.example.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class ApiClient {
    private final String BASE_URL = "http://localhost:8080/query";

    private void sendGetRequest(String endpoint) {
        try {
            URI uri = URI.create(BASE_URL + endpoint);
            HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getAirportsInCity(long cityId) {
        sendGetRequest("/cities/" + cityId + "/airports");
    }

    public void getAircraftByPassenger(long passengerId) {
        sendGetRequest("/passengers/" + passengerId + "/aircraft");
    }

    public void getAirportsByAircraft(long aircraftId) {
        sendGetRequest("/aircraft/" + aircraftId + "/airports");
    }

    public void getAirportsUsedByPassenger(long passengerId) {
        sendGetRequest("/passengers/" + passengerId + "/airports");
    }
}
