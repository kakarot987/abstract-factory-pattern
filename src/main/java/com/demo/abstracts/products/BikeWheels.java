package com.demo.abstracts.products;

// Concrete Product B2
public class BikeWheels implements Wheels {

    @Override
    public String getMaterial() { return "Spoke Steel"; }

    @Override
    public int getSize() { return 17; }

    @Override
    public String getDescription() {
        return getSize() + "-inch " + getMaterial() + " wheels with narrow-profile tyres";
    }
}
