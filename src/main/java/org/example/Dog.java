package org.example;

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    String makeSound() {
        return "Woof! Woof!";
    }
}
