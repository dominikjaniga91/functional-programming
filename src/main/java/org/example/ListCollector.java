package org.example;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

class ListCollector implements Collector<Person, ArrayList<Person>, ArrayList<Person>> {

    @Override
    public Supplier<ArrayList<Person>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<Person>, Person> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<Person>> combiner() {
        return (a1,a2) -> {
            a1.addAll(a2);
            return a1;
        };
    }

    @Override
    public Function<ArrayList<Person>, ArrayList<Person>> finisher() {
        System.out.println("Finisher");
        return a -> a;
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics");
        return Set.of(Characteristics.UNORDERED);
    }
}
