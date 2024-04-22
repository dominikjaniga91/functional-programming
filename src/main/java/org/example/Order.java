package org.example;

import java.util.List;
import java.util.stream.Stream;

public record Order(List<Product> products) {

    Stream<Product> productStream() {
        return products.stream();
    }
}
