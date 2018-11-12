package com.ururai.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> magicNumbersList = new ArrayList<>();
        int magicNumbers = 0;

        System.out.println("\nInforme os valores de entrada na formatação abaixo");
        System.out.println("[[A,B],[C,D], ...[Y,Z]]");
        System.out.println("**************************************************");

        String[] strArray = scanner.next()
                .replaceAll("],", ";")
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .split(";");

        scanner.close();

        magicNumbersList = magicList(generateListFromInputData(strArray));
        magicNumbers = magicNumbersList.size();

        System.out.printf("A Entrada informada possui %d números mágicos:\n", magicNumbers);
        System.out.println(magicNumbersList);
    }

    // Returns true if there is an exact square root
    public static boolean isSquareRoot(int number) {
        for (int i = 1; i < number; i++) {
            if (Math.sqrt(number) % i == 0)
                return true;
        }
        return false;
    }

    // Returns true if the number informed is prime
    public static boolean isPrime(int number) {
        boolean result = false;
        if (number > 1) {
            result = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0)
                    result = false;
            }
        }
        return result;
    }

    // Returns true if the number is Magic
    public static boolean isMagicNumber(int number) {
        return (isSquareRoot(number) && isPrime((int) Math.sqrt(number)));
    }

    // Create a list of integers
    public static List<Integer> createList(int min, int max) {
        List<Integer> newList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            newList.add(i);
        }
        return newList;
    }

    // Receives a nested list of integers as parameter and returns a list of integers filtered by isMagicNumber function
    public static List<Integer> magicList(List<List<Integer>> nestedList) {
        return nestedList.stream()
                .flatMap(Collection::stream)
                .filter(MagicNumbers::isMagicNumber)
                .collect(Collectors.toList());
    }

    // Receives the informed data by the user and returns a nested list of integers
    public static List<List<Integer>> generateListFromInputData(String[] strArray) {
        List<List<Integer>> dataList = new ArrayList<>();
        int min = 0;
        int max = 0;

        for (String aStrArray : strArray) {
            String[] strComma = aStrArray.split(",");

            for (int j = 0; j < strComma.length; j++) {
                String str2 = strComma[j];
                if (j == 0)
                    min = Integer.parseInt(str2.trim());
                else
                    max = Integer.parseInt(str2.trim());

            }
            dataList.add(createList(min, max));
        }
        return dataList;
    }

}
