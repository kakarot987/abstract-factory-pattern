# Abstract Factory — Vehicle Families

This Java 17/Spring Boot example uses `VehicleFactory` to create a
**family of related products**: an `Engine` and `Wheels`.

- `CarFactory` creates `CarEngine` + `CarWheels`
- `BikeFactory` creates `BikeEngine` + `BikeWheels`
- `VehicleService` consumes `VehicleFactory`, `Engine`, and `Wheels`
  abstractions without depending on concrete product classes.

Spring injects the factory beans as a `Map<String, VehicleFactory>`,
using the component names `CAR` and `BIKE` as keys.

## Run

From the repository root (Java 17, Maven):

```bash
mvn spring-boot:run
mvn test
```

The UI lives at `src/main/resources/static/index.html` and is served at
[http://localhost:8080](http://localhost:8080).

```bash
curl http://localhost:8080/api/vehicle/build/CAR
curl http://localhost:8080/api/vehicle/build/BIKE
```

Unsupported types return HTTP 400. Tests verify that each factory produces a
consistent family of product properties.

## Versus Factory Method

Factory Method lets concrete creator subclasses choose **one product**
to instantiate (e.g. an EMAIL notification). Abstract Factory exposes
multiple creation operations for **a related family** (engine and wheels).
The distinction concerns the responsibilities of the creation interface;
neither pattern requires a particular framework.

![Demo screenshot](img.png)
