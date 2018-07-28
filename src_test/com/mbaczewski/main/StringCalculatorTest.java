package com.mbaczewski.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    opis zadania z podejściem TDD:
    http://osherove.com/tdd-kata-1/
*/

class StringCalculatorTest {

    private StringCalculator stringCalculator;
    private int result;

    @BeforeEach
    public void setUpAll() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturn0WhenStringIsEmpty() {
        // given

        // when
        result = stringCalculator.add("");
        // then
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnNumberWhenInputOneNumber() {
        // given

        // when
        result = stringCalculator.add("5");
        // then
        assertEquals(5, result);
    }

    @Test
    public void shouldReturn5WhenGet1And4() {
        // given

        // when
        int result = stringCalculator.add("1,4");
        // then
        assertEquals(5, result);
    }

    @Test
    public void shouldReturn10WhenGet2And5And3() {
        // given

        // when
        result = stringCalculator.add("2,5,3");
        // then
        assertEquals(10, result);
    }

    @Test
    public void shouldReturn8WhenGet2And6SplitNewLine() {
        // given

        // when
        result = stringCalculator.add("2\n6");
        // then
        assertEquals(8, result);
    }

    @Test
    public void shouldReturn3WhenGet2BackSlashesSemicolonAnd1And2() {
        // given

        // when
        result = stringCalculator.add("//;\n1;2");
        // then
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenNegativeNumber() {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("2,-3,-5,6"));
    }

}