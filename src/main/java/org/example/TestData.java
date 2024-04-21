package org.example;

import java.util.List;
class TestData {

    static List<Person> create() {
        return List.of(
                new Person("Dominik", 33, "Mountains", 19_000.50),
                new Person("Karolina", 29, "Movies", 10_000.00),
                new Person("Ewelina", 30, "Cooking", 10_000.00),
                new Person("Mateusz", 30, "Games", 10_000.00),
                new Person("Daniel", 27, "Building", 8_000.00)
        );
    }
}
