package com.example.listycity;

import java.util.Objects;

/**
 * Defines a City with a city name and a province name.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a City.
     * @param city the city name
     * @param province the province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * @return the city name
     */
    String getCityName(){ return this.city; }

    /**
     * @return the province name
     */
    String getProvinceName(){ return this.province; }

    /**
     * Natural ordering by city name (lexicographic).
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Two City objects are equal if both their names and provinces are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) &&
                Objects.equals(province, other.province);
    }

    /**
     * Hash code consistent with equals(city, province).
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
