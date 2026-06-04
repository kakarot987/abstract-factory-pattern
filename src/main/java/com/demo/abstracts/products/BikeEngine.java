package com.demo.abstracts.products;

// Concrete Product A2
public class BikeEngine implements Engine {

    @Override
    public String getType() { return "Single-Cylinder 2-Stroke"; }

    @Override
    public int getHorsepower() { return 45; }

    @Override
    public String getDescription() {
        return "Lightweight " + getType() + " engine with " + getHorsepower() + " HP";
    }
}
