package org.example;

import java.util.List;
class TestData {

    static List<Person> createPeople() {
        return List.of(
                new Person("Dominik", 32, "Mountains", 19_000.50),
                new Person("Karolina", 29, "Movies", 10_000.00),
                new Person("Ewelina", 30, "Cooking", 10_000.00),
                new Person("Mateusz", 30, "Games", 10_000.00),
                new Person("Daniel", 27, "Building", 8_000.00),
                new Person("Dominik", 33, "Mountains", 20_000.00)
        );
    }

    static List<Order> createOrders() {
        return List.of(
                new Order(List.of(new Product("Milk", 3), new Product("Chocolate", 5))),
                new Order(List.of(new Product("Water", 1), new Product("Meat", 10))),
                new Order(List.of(new Product("Bread", 4), new Product("Broccoli", 3))),
                new Order(List.of(new Product("Chocolate", 5), new Product("Milk", 3))),
                new Order(List.of(new Product("Meat", 10), new Product("Water", 1))),
                new Order(List.of(new Product("Broccoli", 3), new Product("Bread", 4)))
        );
    }
}
