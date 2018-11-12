package com.ururai.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class MagicNumbersTest {

    @Test
    public void squareRoot() {
        int limit = 100;
        for (int i = 2; i <= limit; i++) {
            int root = i * i;
            assertTrue(MagicNumbers.isSquareRoot(root));
        }
        assertFalse(MagicNumbers.isSquareRoot(0));
        assertFalse(MagicNumbers.isSquareRoot(1));
    }

    @Test
    public void isPrime() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        for (int i : expectedPrimes) {
            assertTrue(MagicNumbers.isPrime(i));
        }
        assertFalse(MagicNumbers.isPrime(0));
        assertFalse(MagicNumbers.isPrime(1));
    }

    @Test
    public void isMagicNumber() {
        List<Integer> expectedMagicNumber = Arrays.asList(4, 9, 25, 49, 121, 169, 289, 361, 529, 841,
                961, 1369, 1681, 1849, 2209, 2809, 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409);
        for (int i : expectedMagicNumber) {
            assertTrue(MagicNumbers.isMagicNumber(i));
        }
    }

    @Test
    public void createList() {
        List<Integer> expectedlist = new ArrayList<>();
        int min = 0;
        int max = 100;
        for (int i = min; i <= max; i++) {
            expectedlist.add(i);
        }
        assertEquals(expectedlist, MagicNumbers.createList(min, max));
    }

    @Test
    public void magicList() {
        List<Integer> expectedList = Arrays.asList(4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961,
                1369, 1681, 1849, 2209, 2809, 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409);
        List<List<Integer>> inputData = Arrays.asList(expectedList);
        assertEquals(expectedList, MagicNumbers.magicList(inputData));

    }

    @Test
    public void generateListFromInputData() {
        String inputData = "[[49,49]]";

        String[] testData = inputData.replaceAll("],", ";")
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .split(";");
        List<Integer> expected = Collections.singletonList(49);
        List<List<Integer>> nestedExpected = Collections.singletonList(expected);

        assertFalse(MagicNumbers.generateListFromInputData(testData).isEmpty());
        assertEquals(nestedExpected, MagicNumbers.generateListFromInputData(testData));

    }
}