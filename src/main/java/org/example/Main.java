package org.example;

public class Main {
    public static void main(String[] args) throws InvalidRainChanceException {

        UmbrellaAcademy academy = new UmbrellaAcademy();
        INationalWeatherService weatherService = new NWS();
        IPublicServiceAnnouncementUtility publicServiceAnnouncementUtility = new PSA();

        academy.setService(weatherService);
        academy.setPsau(publicServiceAnnouncementUtility);

        academy.shouldICarryAnUmbrella("Charlotte");
        academy.shouldICarryAnUmbrella("London");
        academy.shouldICarryAnUmbrella("Las Vegas");
        academy.shouldICarryAnUmbrella("Cleveland");
    }
}