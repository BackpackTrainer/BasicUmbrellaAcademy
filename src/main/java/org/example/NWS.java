package org.example;

public class NWS implements INationalWeatherService {

    private String slogan;
    @Override
    public int getChanceOfRain(String location) {
        int chanceOfRain;
        switch (location) {
            case "Charlotte": {
                chanceOfRain = 51;
                break;
            }
            case ("London"): {
                chanceOfRain = 90;
                break;
            }
            case ("Las Vegas"): {
                chanceOfRain = 10;
                break;
            }
            default: {
                chanceOfRain = 49;
            }
        }
        return chanceOfRain;
    }

    @Override
    public void printSlogan() {
        System.out.println(slogan);
    }

}
