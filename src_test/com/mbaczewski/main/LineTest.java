package com.mbaczewski.main;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Disabled
    @Test
    public void shouldReturnSlope0p518WhenX0Is1p2Y0Is0p9X1Is9p3Y1Is5p1() {
        // given
        Line line = new Line(1.2, 0.9, 9.3, 5.1);
        // when

        // then
        assertEquals(0.518, line.getSlope(), 0.001);
    }

    @Test
    public void shouldThrowArithmeticExceptionWhenX0AndX1Is1p2() {
        // given
        Line line = new Line(1.2, 0.9, 1.2, 5.1);
        // when

        // then
        assertThrows(ArithmeticException.class, () -> line.getSlope());
    }

    @ParameterizedTest
    @CsvSource({
            "1.1, 2.2, 3.3, 4.4 , 1.0",
            "0.9, 8.5, 12.1, -16.3 , -2.214",
            "-5.6, -10.1, -7.2, -9.3 , -0.5"
    })
    public void testSlopeWithCSVFile(double x0, double y0, double x1, double y1, double slope) {
        Line line = new Line(x0, y0, x1, y1);
        // when

        // then
        assertEquals(slope, line.getSlope(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "1.1, 2.2, 3.3, 4.4 , 3.111",
            "0.9, 8.5, 12.1, -16.3 , 27.212",
            "-5.6, -10.1, -7.2, -9.3 , 1.789"
    })
    public void testDistanceWithCSVFile(double x0, double y0, double x1, double y1, double distance) {
        Line line = new Line(x0, y0, x1, y1);
        // when

        // then
        assertEquals(distance, line.getDistance(), 0.001);
    }

    @Test
    public void shouldReturnTrueIfLineIsParallelToLine() {
        // given
        Line line1 = new Line(1.1, 2.2, 3.3, 4.4);
        Line line2 = new Line(1.1, 2.2, 3.3, 4.4);
        // when
        
        // then
        assertTrue(line1.parallelTo(line2));
    }

    @Test
    public void shouldReturnFalseIfLineIsNotParallelToLine() {
        // given
        Line line1 = new Line(1.9, 2.2, 3.3, 4.4);
        Line line2 = new Line(1.1, 2.9, 10.2, 4.4);
        // when

        // then
        assertFalse(line1.parallelTo(line2));
    }

}