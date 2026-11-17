package com.demo.abstracts.service;

import com.demo.abstracts.factory.VehicleFactory;
import com.demo.abstracts.products.Engine;
import com.demo.abstracts.products.Wheels;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VehicleService {

    // Spring injects all VehicleFactory beans keyed by their @Component name
    private final Map<String, VehicleFactory> factories;

    public VehicleService(Map<String, VehicleFactory> factories) {
        this.factories = factories;
    }

    public VehicleResponse buildVehicle(String type) {
        VehicleFactory factory = type == null ? null : factories.get(type.trim().toUpperCase(java.util.Locale.ROOT));
        if (factory == null) {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }

        // Client code works ONLY with abstractions — no concrete class references here
        Engine engine = factory.createEngine();
        Wheels wheels = factory.createWheels();

        return new VehicleResponse(
            factory.getVehicleType(),
            engine.getType(),
            engine.getHorsepower(),
            engine.getDescription(),
            wheels.getMaterial(),
            wheels.getSize(),
            wheels.getDescription()
        );
    }

    public record VehicleResponse(
        String vehicleType,
        String engineType,
        int horsepower,
        String engineDescription,
        String wheelMaterial,
        int wheelSize,
        String wheelsDescription
    ) {}
}
