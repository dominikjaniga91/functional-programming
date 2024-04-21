package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

class People implements Iterable<Person> {

    private final List<Person> people;

    People() {
        this.people = new ArrayList<>();
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    @Override
    public void forEach(Consumer<? super Person> action) {
        people.forEach(action);
    }

    @Override
    public Spliterator<Person> spliterator() {
        return people.spliterator();
    }

    public void add(Person person) {
        people.add(person);
    }

    public People addAll(People p2) {
        people.addAll(p2.people);
        return this;
    }

    @Override
    public String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }
}
