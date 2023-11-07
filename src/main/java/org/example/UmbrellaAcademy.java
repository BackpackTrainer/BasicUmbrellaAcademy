package org.example;

public class UmbrellaAcademy {
    INationalWeatherService service;
    IPublicServiceAnnouncementUtility psau;

    public boolean shouldICarryAnUmbrella(String location) throws InvalidRainChanceException {
        boolean shouldICarry = false;

        int chanceOfRain = service.getChanceOfRain(location);

        if(chanceOfRain <0 || chanceOfRain > 100) {
            throw new InvalidRainChanceException(chanceOfRain + " is not a valid chance of rain");
        }
        if(chanceOfRain >= 50) {
            shouldICarry = true;
        }

        if(chanceOfRain >+ 75) {
            psau.setAnnouncement("Carry an umbrella in " + location);
        }
        return shouldICarry;
    }

    public void setService(INationalWeatherService service) {
        this.service = service;
    }

    public void setPsau(IPublicServiceAnnouncementUtility psau) {
        this.psau = psau;
    }
}
