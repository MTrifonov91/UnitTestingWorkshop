package edu.studying.mockito.presentation.b.definingmethodcalls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// test class to test City.class methods
class CityTest {

    // defining the classes under test instances
    Country country;
    City city;

    // initialising the declared instances
    @BeforeEach
    public void setup() {
        country = new Country("Moldova");
        city = new City(country, "Chisinau", 800000L);
    }

    // stub the getCountry().getName() method declaring with "when()"
    @Test
    public void definingMethodsWithWhenFail() {
        when(city.getCountry().getName()).thenReturn("USA");
        // fail miserably
        System.out.println(city.getCountry().getName());
    }

    // stub the getCountry().getName() method declaring with "when()"
    // using mocks
    @Test
    public void definingMethodsWithWhen() {
        City cityMock = mock(RETURNS_DEEP_STUBS);
        when(cityMock.getCountry().getName()).thenReturn("USA");

        System.out.println(cityMock.getCountry().getName());
    }


    // stub the getCountry().getName() method declaring with "given()"
    @Test
    public void definingMethodsWithGivenFail() {
        given(city.getCountry().getName()).willReturn("China");
        // fail miserably
        System.out.println(city.getCountry().getName());
    }

    // stub the getCountry().getName() method declaring with "given()"
    // using mocks
    @Test
    public void definingMethodsWithGiven() {
        City cityMock = mock(RETURNS_DEEP_STUBS);
        given(cityMock.getCountry().getName()).willReturn("China");

        System.out.println(cityMock.getCountry().getName());
    }

    // stub the getName() method declaring with "when()"
    // using spy()
    @Test
    public void definingMethodsWithWhenCityName() {
        City citySpy = spy(city);
        when(citySpy.getName()).thenReturn("Washington");

        System.out.println(citySpy.getName());
    }

    // stub the getName() method declaring with "given()"
    // using spy()
    @Test
    public void definingMethodsWithGivenCityName() {
        City citySpy = spy(city);
        given(citySpy.getName()).willReturn("Beijing");

        System.out.println(citySpy.getName());
    }

}