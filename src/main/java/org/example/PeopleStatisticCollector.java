package org.example;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

class PeopleStatisticCollector implements Collector<Person, PeopleStatistics, PeopleStatistics> {

    @Override
    public Supplier<PeopleStatistics> supplier() {
        System.out.println("Supplier");
        return PeopleStatistics::new;
    }

    @Override
    public BiConsumer<PeopleStatistics, Person> accumulator() {
        System.out.println("Accumulator");
        return PeopleStatistics::accept;
    }

    @Override
    public BinaryOperator<PeopleStatistics> combiner() {
        System.out.println("Combiner");
        return (p1, p2) -> {
            //BinaryOperator is created in parallelStream
            System.out.println(" p1 " + p1);
            System.out.println(" p2 " + p2);
            return p1;
        };
    }

    @Override
    public Function<PeopleStatistics, PeopleStatistics> finisher() {
        System.out.println("Finisher");
        return Function.identity(); // p -> p
    }

    /*
    Characteristics.IDENTITY_FINISH -> Indicates that finisher is identity function (Function.identity or just a -> a) and won't call finisher function
    Characteristics.UNORDERED -> Does not preserve the order of the elements of the stream.
    Characteristics.CONCURRENT -> This means that the container that the accumulator stored the elements, support concurrent access.
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics");
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}
