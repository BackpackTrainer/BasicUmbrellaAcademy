
import org.example.IPublicServiceAnnouncementUtility;
import org.example.INationalWeatherService;
import org.example.InvalidRainChanceException;
import org.example.UmbrellaAcademy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UmbrellaAcademyTests {

    UmbrellaAcademy uut;
    INationalWeatherService service;
    IPublicServiceAnnouncementUtility psau;

    @BeforeEach
    public void setUp()  {
        psau = mock(IPublicServiceAnnouncementUtility.class);
        service = mock(INationalWeatherService.class);
        uut = new UmbrellaAcademy();
        uut.setPsau(psau);
        uut.setService(service);
    }

    @ParameterizedTest
    @CsvSource({"49, Cleveland, false", "50, Columbia, true", "51, Charlotte, true"})
    public void testWithValidRainChanceAndNoPSA(int rainChance, String location, boolean expectedResult ) throws InvalidRainChanceException {
        when(service.getChanceOfRain(location)).thenReturn(rainChance);

        boolean actualResult = uut.shouldICarryAnUmbrella(location);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"-1", "101"})
    public void testInvalidChanceOfRain(int rainChance) throws InvalidRainChanceException {
        when(service.getChanceOfRain(anyString())).thenReturn(rainChance);

       assertThrows(InvalidRainChanceException.class,
               () ->{uut.shouldICarryAnUmbrella(anyString());
       });
    }
}
