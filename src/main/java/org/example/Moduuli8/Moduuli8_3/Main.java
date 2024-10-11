package org.example.Moduuli8.Moduuli8_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Nimo", 30, "New York"));
        people.add(new Person("Hanna", 25, "Helsinki"));
        people.add(new Person("Mohamed", 35, "New York"));
        people.add(new Person("Aden", 28, "London"));
        people.add(new Person("Farah", 22, "New York"));

        System.out.println("Unsorted list:");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("\nSorted by age:");
        people.sort(Comparator.comparingInt(Person::getAge));
        for (Person person : people) {
            System.out.println(person);
        }

        List<Person> filtered = people.stream()
                .filter(person -> person.getCity().equals("New York"))
                .collect(Collectors.toList());

        System.out.println("\nFiltered by city (New York):");
        for (Person person : filtered) {
            System.out.println(person);
        }
    }
}
