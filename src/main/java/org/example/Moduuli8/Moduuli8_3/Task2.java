package org.example.Moduuli8.Moduuli8_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove(); // Remove even numbers
            }
        }

        System.out.println("After filtering even numbers: " + numbers);

        numbers.replaceAll(n -> n * 2);

        System.out.println("After doubling the odd numbers: " + numbers);

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        System.out.println("Sum of all numbers: " + sum);
    }
}
