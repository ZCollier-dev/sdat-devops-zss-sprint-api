package org.example.cli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient client = new ApiClient();

        System.out.println("Choose a query:");
        System.out.println("1. List airports in a city");
        System.out.println("2. List aircraft a passenger has flown on");
        System.out.println("3. List airports an aircraft uses");
        System.out.println("4. List airports a passenger has used");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter City ID: ");
                long cityId = scanner.nextLong();
                client.getAirportsInCity(cityId);
            }
            case 2 -> {
                System.out.print("Enter Passenger ID: ");
                long passengerId = scanner.nextLong();
                client.getAircraftByPassenger(passengerId);
            }
            case 3 -> {
                System.out.print("Enter Aircraft ID: ");
                long aircraftId = scanner.nextLong();
                client.getAirportsByAircraft(aircraftId);
            }
            case 4 -> {
                System.out.print("Enter Passenger ID: ");
                long passengerId = scanner.nextLong();
                client.getAirportsUsedByPassenger(passengerId);
            }
            default -> System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
