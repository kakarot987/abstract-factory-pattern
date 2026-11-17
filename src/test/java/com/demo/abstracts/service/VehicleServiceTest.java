package com.demo.abstracts.service;

import com.demo.abstracts.factory.BikeFactory;
import com.demo.abstracts.factory.CarFactory;
import com.demo.abstracts.factory.VehicleFactory;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {

    private final VehicleService service = new VehicleService(Map.of(
            "CAR", new CarFactory(), "BIKE", new BikeFactory()
    ));

    @Test
    void carFactoryCreatesConsistentProductFamily() {
        var car = service.buildVehicle("car");
        assertEquals("Car", car.vehicleType());
        assertEquals("V8 Petrol", car.engineType());
        assertEquals(450, car.horsepower());
        assertEquals("Alloy", car.wheelMaterial());
        assertEquals(18, car.wheelSize());
    }

    @Test
    void bikeFactoryCreatesConsistentProductFamily() {
        var bike = service.buildVehicle("BIKE");
        assertEquals("Bike", bike.vehicleType());
        assertEquals("Single-Cylinder 2-Stroke", bike.engineType());
        assertEquals(45, bike.horsepower());
        assertEquals("Spoke Steel", bike.wheelMaterial());
        assertEquals(17, bike.wheelSize());
    }

    @Test
    void failsWithClearErrorForMissingOrUnknownTypes() {
        assertThrows(IllegalArgumentException.class, () -> service.buildVehicle("truck"));
        assertThrows(IllegalArgumentException.class, () -> service.buildVehicle(null));
    }
}
