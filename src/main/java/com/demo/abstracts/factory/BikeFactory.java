package com.demo.abstracts.factory;

import com.demo.abstracts.products.*;
import org.springframework.stereotype.Component;

// Concrete Factory 2 — creates the Bike family of products
@Component("BIKE")
public class BikeFactory implements VehicleFactory {

    @Override
    public Engine createEngine() {
        return new BikeEngine();
    }

    @Override
    public Wheels createWheels() {
        return new BikeWheels();
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }
}
