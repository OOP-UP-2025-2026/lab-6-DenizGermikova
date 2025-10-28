package org.example;

class Smartphone implements GPS, Cellular {
    private String model;

    public Smartphone(String model) {
        this.model = model;
    }

    public double[] getCoordinates() {
        return new double[]{46.4825, 30.7233}; // наприклад, Одеса
    }

    public void makeCall() {
        System.out.println(model + " здійснює дзвінок...");
    }

    public void receiveCall() {
        System.out.println(model + " приймає дзвінок...");
    }
}
