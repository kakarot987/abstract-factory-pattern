package com.demo.abstracts.factory;

import com.demo.abstracts.products.Engine;
import com.demo.abstracts.products.Wheels;

// Abstract Factory — defines the contract for creating a FAMILY of related products
public interface VehicleFactory {
    Engine createEngine();
    Wheels createWheels();
    String getVehicleType();
}
