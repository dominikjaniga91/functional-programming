package org.example;

import java.util.function.Consumer;

class PeopleStatistics implements Consumer<Person> {

    private Double averageAge;
    private Double averageSalary;
    private int numberOfPeople;
    private int ageSum;
    private int salarySum;
    private Person oldestPerson;
    private Person youngestPerson;
    private Person personWithBiggestSalary;
    private Person personWithLowestSalary;

    @Override
    public void accept(Person person) {
        numberOfPeople++;
        ageSum += person.age();
        salarySum += person.salary();
        oldestPerson = findOldestPerson(person);
        youngestPerson = findYoungestPerson(person);
        personWithBiggestSalary = findPersonWithBiggestSalary(person);
        personWithLowestSalary = findPersonWithLowestSalary(person);
    }


    private Person findYoungestPerson(Person person) {
        return youngestPerson != null && youngestPerson.age() < person.age()
                ? youngestPerson
                : person;
    }

    private Person findOldestPerson(Person person) {
        return oldestPerson != null && oldestPerson.age() > person.age()
                ? oldestPerson
                : person;
    }

    private Person findPersonWithBiggestSalary(Person person) {
        return personWithBiggestSalary != null && personWithBiggestSalary.salary() > person.salary()
                ? personWithBiggestSalary
                : person;
    }

    private Person findPersonWithLowestSalary(Person person) {
        return personWithBiggestSalary != null && personWithBiggestSalary.salary() < person.salary()
                ? personWithBiggestSalary
                : person;
    }

    public Double calculateAverageAge() {
        return (double) ageSum / numberOfPeople;
    }

    public Double calculateAverageSalary() {
        return (double) salarySum / numberOfPeople;
    }

    @Override
    public String toString() {
        return "PeopleStatistics{" +
                "averageAge=" + calculateAverageAge() +
                ", averageSalary=" + calculateAverageSalary() +
                ", numberOfPeople=" + numberOfPeople +
                ", ageSum=" + ageSum +
                ", salarySum=" + salarySum +
                ", oldestPerson=" + oldestPerson +
                ", youngestPerson=" + youngestPerson +
                ", personWithBiggestSalary=" + personWithBiggestSalary +
                ", personWithLowestSalary=" + personWithLowestSalary +
                '}';
    }
}
