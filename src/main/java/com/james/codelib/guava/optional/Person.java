package com.james.codelib.guava.optional;

/**
 * Created by james on 9/23/14.
 */
public class Person {
    private Place placeOfBirth;

    public Person(Place placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Place getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Place placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
