package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testHasCityTrueFalse() {
        CityList list = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");

        list.add(edmonton);

        assertTrue(list.hasCity(new City("Edmonton", "Alberta"))); // equals/hashCode check
        assertFalse(list.hasCity(calgary));
    }

    @Test
    void testDeleteRemovesCity() {
        CityList list = new CityList();
        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);

        assertTrue(list.hasCity(new City("Regina", "Saskatchewan")));
        list.delete(new City("Regina", "Saskatchewan"));
        assertFalse(list.hasCity(new City("Regina", "Saskatchewan")));
        assertEquals(0, list.countCities());
    }

    @Test
    void testDeleteThrowsWhenAbsent() {
        CityList list = new CityList();
        City yellowknife = new City("Yellowknife", "Northwest Territories");

        assertThrows(IllegalArgumentException.class, () -> list.delete(yellowknife));
    }

    @Test
    void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());
    }
}
