package com.demo.abstracts.products;

// Concrete Product B1
public class CarWheels implements Wheels {

    @Override
    public String getMaterial() { return "Alloy"; }

    @Override
    public int getSize() { return 18; }

    @Override
    public String getDescription() {
        return getSize() + "-inch " + getMaterial() + " wheels with wide-profile tyres";
    }
}
