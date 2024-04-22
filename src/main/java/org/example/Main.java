package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        //Custom collectors
        List<Person> people = TestData.createPeople();

        PeopleStatistics peopleStatistics = people.stream().collect(new PeopleStatisticCollector());
        People peopleCollect = people.stream().collect(new PeopleCollector());
        List<Person> listOfPeople = people.stream().collect(new ListCollector());

        System.out.println(peopleStatistics);
        System.out.println(peopleCollect);
        System.out.println(listOfPeople);

        //partitioningBy
        Map<Boolean, List<Person>> collect = people.stream().collect(partitioningBy(p -> p.age() > 30));


        //Example of Collectors.teeing
        Long averageAge = people.stream()
                .collect(teeing(
                                counting(),
                                summingInt(Person::age),
                                (n, a) -> a / n
                        )
                );

        //grouping by
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(groupingBy(Person::age));
        System.out.println(peopleByAge);

        // groupingBy + mapping
        Map<String, List<Integer>> nameToListOfAge = people.stream()
                .collect(
                        groupingBy(
                                Person::name,
                                mapping(
                                        Person::age,
                                        toList()
                                )
                        )
                );
        System.out.println(nameToListOfAge);

        //groupingBy + averingInt
        Map<String, Double> nameToAverageAge = people.stream()
                .collect(
                        groupingBy(
                                Person::name,
                                averagingInt(Person::age)
                        )
                );
        System.out.println(nameToAverageAge);

        //groupingBy + collectingAndThen
        Map<String, Integer> nameToOccurrence = people.stream()
                .collect(
                        groupingBy(
                                Person::name,
                                collectingAndThen(
                                        counting(),
                                        Long::intValue
                                )
                        )
                );
        System.out.println(nameToOccurrence);

        //summing age
        int sum = people.stream().mapToInt(Person::age).sum();

        // min() .max() .average()

        Optional<Person> oldestPerson = people.stream()
                .collect(
                        maxBy(
                                comparingInt(Person::age)
                                        .thenComparing(Person::name)
                        )
                );

        Optional<Person> oldestPerson2 = people.stream().max(comparingInt(Person::age));


        String oldestPersonName = people.stream()
                .collect(
                        collectingAndThen(
                                maxBy(comparingInt(Person::age)),
                                p -> p.map(Person::name).orElse("")
                        )
                );

        //filtering
        Map<Integer, List<String>> ageToNamesFiltered = people.stream()
                .collect(
                        groupingBy(
                                Person::age,
                                mapping(
                                        Person::name,
                                        filtering(
                                                "Dominik"::equals,
                                                toList()
                                        )
                                )
                        )
                );

        System.out.println(ageToNamesFiltered);

        //flat map
        List<Order> orders = TestData.createOrders();

        Stream<String> stringStream = orders.stream()
                .flatMap(Order::productStream)
                .map(Product::name);

        //flatMapping

        Map<Integer, List<String>> flatMapping = people.stream()
                .collect(groupingBy(
                                Person::age,
                                mapping(
                                        Person::name,
                                        flatMapping(
                                                p -> Stream.of(p.split("")),
                                                toList()
                                        )
                                )
                        )
                );

        System.out.println(flatMapping);

    }
}