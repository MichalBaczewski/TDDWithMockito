package com.mbaczewski.main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUpEach() {
        System.out.println("BeforeEach");
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDownEach() {
        System.out.println("AfterEach");
    }

    @Test
    public void shouldReturn50WhenAdd30To20() {
        // given

        // when
        int result = calculator.add(30, 20);
        // then
        assertEquals(50,result);
    }

    @Disabled
    @Test
    public void shouldReturn40WhenAdd20To20() {
        // given

        // when
        int result = calculator.add(20, 10);
        // then
        assertEquals(40,result);
    }

    private int lifecycleMe = 0;

    @RepeatedTest(5)
    public void should() {
        // given

        // when

        // then
        assertEquals(0,lifecycleMe++);
    }

    @ParameterizedTest
    @ValueSource(strings = {"RED", "GREEN", "BLACK"})
    public void shouldTestIfColorIsABaseColor(String color) {
        // given
        Map<String, Boolean>  baseColor = new HashMap<>();
        baseColor.put("RED", true);
        baseColor.put("GREEN", true);
        baseColor.put("BLUE", true);
        // when

        // then
        assertTrue(baseColor.getOrDefault(color, false));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }

    //Stream, Iterable, Iterator
    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    @ParameterizedTest
    @CsvSource({"foo, 1", "bar, 2", "baz, 3"})
    void testWithCSVSource(String first, int second) {
        assertNotNull(first);
        assertNotEquals(0, second);
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void shouldReturnOnLinuxOrMac() {
        assertEquals("Hello from Linux", "Wait, what?");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_9})
    void onlyOnJava8() {
        assertEquals("Is it JAVA 9?", "No it is 8.");
    }

    @Test
    public void shouldParseValidNumber() {
        // given

        // when
        int result = calculator.parse("100");
        // then
        assertEquals(100, result);
    }

    @Test
    public void shouldThrowNumberFormatExceptionForInvalidString() {
        // given

        // when

        // then
        assertThrows(NullPointerException.class, ()
        -> calculator.parse("abc"));
    }

    @Test
    public void shouldThrowWeightExceptionMessageForInvalidString() {
        // given

        // when

        // then
        NumberFormatException result = assertThrows(NumberFormatException.class, ()
        -> calculator.parse("result"));
        assertEquals("Niepoprawny numer", result.getMessage());
    }

}