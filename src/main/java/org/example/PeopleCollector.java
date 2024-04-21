package org.example;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

class PeopleCollector implements Collector<Person, People, People> {

    @Override
    public Supplier<People> supplier() {
        return People::new;
    }

    @Override
    public BiConsumer<People, Person> accumulator() {
        return People::add;
    }

    @Override
    public BinaryOperator<People> combiner() {
        return People::addAll;
    }

    @Override
    public Function<People, People> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics");
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}
