package com.luv2code.junitdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils = null;
    private static Logger log = Logger.getLogger(DemoUtilsTest.class.getName());

    @BeforeEach
    void setup(){
        demoUtils = new DemoUtils();
        System.out.println(" starting ---");
    }
    @AfterEach
    void afterEach(){
        System.out.println(" after each --");
    }

    @BeforeAll
    static void beforeEachClass(){
        System.out.println(" before each class executed ---");
    }

    @AfterAll
    static void afterEachClass() {
        log.info(" afterEachClass | AfterAll ");
    }
    @Test
    @Order(2)
    void testEqualsAndNotEquals() {
        log.info(" executing --testEqualsAndNotEquals ");
        int result = demoUtils.add(2, 4);
        assertEquals(6, result, "2+4 must equals 6");
        assertNotEquals(7, result, "2+4 must equals 6");
    }
    @Test
    @Order(1)
    void testNotAndNotNull(){
        log.info(" executing --testNotAndNotNull ");
        assertNull(demoUtils.checkNull(null));
        assertNotNull(demoUtils.checkNull("123"));
    }

    @Test
    @DisplayName("Refer to same or not same object")
    void testSameOrNotSameObject() {
        String luvtocode = "luvtocode";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "should be same");
        assertNotSame(luvtocode, demoUtils.getAcademyDuplicate(), "should not be same");
    }

    @Test
    @DisplayName("Greater or not")
    void testGreaterOrNot() {
        assertFalse(demoUtils.isGreater(1,2));
        assertTrue(demoUtils.isGreater(2,1));
    }

    @Test
    @DisplayName("Iterator equals ")
    void testIterativelyEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "String in iterable list should equal");
    }

    @Test
    @DisplayName("multiply")
    void testMultiply(){
        assertEquals(20, demoUtils.multiply(4,5), "should return 20");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] arrays = new String[]{"A","B","C"};
        assertArrayEquals(arrays, demoUtils.getFirstThreeLettersOfAlphabet(), "String in array should be equal");
    }

    @Test
    @DisplayName(" throws or not throw exception")
    void testThrowOrNotThrowException() {
        assertThrows(Exception.class, () -> {
            demoUtils.throwException(-1);
        }, "should throw");
        assertDoesNotThrow(() -> demoUtils.throwException(5), "should not throw");
    }

    @Test
    @DisplayName("Timeout")
    void testThrowTimeout() {
        assertTimeoutPreemptively(Duration.of(5, ChronoUnit.SECONDS), () -> demoUtils.checkTimeout(), "should run within 3 seconds");
    }


}