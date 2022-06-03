package com.luv2code.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
    // if number is divisible 3 -> Fizz
    // if number is divisible 5 -> Buzz
    // if number is divisible 3, 5 -> FizzBuzz
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setup(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Divisible by three")
    @EnabledOnJre(value= JRE.JAVA_17)
    public void testDivideByThree() {
        assertEquals(fizzBuzz.FIZZ, fizzBuzz.compute(9), "should return "+fizzBuzz.FIZZ);
    }

    @Test
    @DisplayName("Divisible by Five")
    @EnabledOnJre(value= JRE.JAVA_17)
    public void testDivideByFive() {
        assertEquals(fizzBuzz.BUZZ, fizzBuzz.compute(10), "should return "+fizzBuzz.BUZZ);
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @DisplayName("Testing with small data file")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    public void testSmallDataTestFile(int value, String expected) {
        assertEquals(expected, fizzBuzz.compute(value), "should return "+fizzBuzz.BUZZ);
    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @DisplayName("Testing with medium/large data file")
    @CsvFileSource(resources = {"/medium-test-data.csv", "/large-test-data.csv"})
    @Order(6)
    public void testMediumLargeDataTestFile(int value, String expected) {
        assertEquals(expected, fizzBuzz.compute(value), "should return "+fizzBuzz.BUZZ);
    }
}
