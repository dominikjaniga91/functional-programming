package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Custom collectors
        List<Person> people = TestData.create();

        PeopleStatistics peopleStatistics = people.stream().collect(new PeopleStatisticCollector());
        People peopleCollect = people.stream().collect(new PeopleCollector());
        List<Person> listOfPeople = people.stream().collect(new ListCollector());

        System.out.println(peopleStatistics);
        System.out.println(peopleCollect);
        System.out.println(listOfPeople);

        //Example of Collectors.teeing
        Long averageAge = people.stream()
                .collect(Collectors.teeing(
                                Collectors.counting(),
                                Collectors.summingInt(Person::age),
                                (n, a) -> a / n
                        )
                );
    }
}