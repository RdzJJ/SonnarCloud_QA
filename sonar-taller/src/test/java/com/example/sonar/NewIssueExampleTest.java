package com.example.sonar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

class NewIssueExampleTest {
    private NewIssueExample example;

    @BeforeEach
    void setUp() {
        example = new NewIssueExample();
    }

    @Test
    @DisplayName("Test compute con diferentes valores")
    void testCompute() {
        assertEquals(4, example.compute(2));
        assertEquals(0, example.compute(0));
        assertEquals(-4, example.compute(-2));
        assertEquals(10, example.compute(5));
        assertEquals(2000, example.compute(1000));
    }

    @Test
    @DisplayName("Test compute con valores límite")
    void testComputeEdgeCases() {
        assertEquals(Integer.MAX_VALUE * 2L, (long)example.compute(Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE * 2L, (long)example.compute(Integer.MIN_VALUE));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 10, 100, -1, -10, -100})
    @DisplayName("Test compute con múltiples valores usando parametrización")
    void testComputeParameterized(int input) {
        long expected = (long) input * 2;
        assertEquals(expected, example.compute(input));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 2",
        "-1, -2",
        "10, 20",
        "-10, -20",
        "1000, 2000"
    })
    @DisplayName("Test compute con valores específicos usando CSV")
    void testComputeWithCsvSource(int input, int expected) {
        assertEquals(expected, example.compute(input));
    }

    @Test
    @DisplayName("Test compute con valores que podrían causar overflow")
    void testComputeOverflow() {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        
        // Verificar comportamiento con valores cerca del límite
        assertEquals(maxValue * 2L, (long)example.compute(maxValue));
        assertEquals(minValue * 2L, (long)example.compute(minValue));
        assertEquals((maxValue - 1) * 2L, (long)example.compute(maxValue - 1));
        assertEquals((minValue + 1) * 2L, (long)example.compute(minValue + 1));
    }
}
