package com.demo.abstracts.factory;

import com.demo.abstracts.products.*;
import org.springframework.stereotype.Component;

// Concrete Factory 1 — creates the Car family of products
@Component("CAR")
public class CarFactory implements VehicleFactory {

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Wheels createWheels() {
        return new CarWheels();
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}
