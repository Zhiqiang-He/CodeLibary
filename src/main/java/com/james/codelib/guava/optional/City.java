package com.james.codelib.guava.optional;

/**
 * Created by james on 9/23/14.
 */
public class City {
    private Province province;

    public City(Province province) {
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
