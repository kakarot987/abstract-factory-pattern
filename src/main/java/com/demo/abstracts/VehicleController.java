package com.demo.abstracts;

import com.demo.abstracts.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "*")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/build/{type}")
    public ResponseEntity<?> buildVehicle(@PathVariable String type) {
        try {
            return ResponseEntity.ok(vehicleService.buildVehicle(type));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
