package com.james.codelib.guava.optional;

/**
 * Created by james on 9/23/14.
 */
public class Place {
    private City city;

    public Place(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
