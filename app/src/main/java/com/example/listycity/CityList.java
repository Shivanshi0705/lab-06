package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Keeps a list of City objects and provides basic list operations.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist (by equals()).
     * @param city candidate city to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns the list of cities sorted by city name.
     * @return sorted list (ascending by name)
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a given city is present in the list.
     * @param city the city to search for
     * @return true if present; false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list if present.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list.
     * @return count of cities
     */
    public int countCities() {
        return cities.size();
    }
}
