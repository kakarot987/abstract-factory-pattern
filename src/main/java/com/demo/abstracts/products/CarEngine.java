package com.demo.abstracts.products;

// Concrete Product A1
public class CarEngine implements Engine {

    @Override
    public String getType() { return "V8 Petrol"; }

    @Override
    public int getHorsepower() { return 450; }

    @Override
    public String getDescription() {
        return "High-performance " + getType() + " engine with " + getHorsepower() + " HP";
    }
}
