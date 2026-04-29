package com.example;

import java.util.List;
import java.util.Scanner;

public class UI {

    private final Scanner scanner = new Scanner(System.in);
    private final WeatherModule weatherModule = new WeatherModule();
    private final CityInfoModule cityModule = new CityInfoModule();
    private final RecommendationModule recModule = new RecommendationModule();

    public void run() {

        System.out.println("\nWelcome to WeatherWise Explorer!");

        boolean running = true;

        while (running) {

            System.out.println("\n1. Weather\n2. City Info\n3. Recommendations\n4. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> weatherModule.displayWeather(askCity());

                case "2" -> cityModule.displayCityInfo(askCity());

                case "3" -> showRecommendations();

                case "4" -> running = false;

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private String askCity() {
        System.out.print("Enter city: ");
        return scanner.nextLine();
    }

    private void showRecommendations() {

        String city = askCity();

        List<PlaceInfo> list = recModule.recommend(city);

        System.out.println("\n🔥 Recommended Places:");

        if (list == null || list.isEmpty()) {
            System.out.println("No recommendations found.");
            return;
        }

        for (PlaceInfo p : list) {
            System.out.println(
                "• " + p.getName() +
                " (" + p.getCategory() +
                ", " + p.getPlaceType() +
                ", Popularity: " + p.getPopularity() + ")"
            );
        }
    }

    public static void main(String[] args) {
        new UI().run();
    }
}