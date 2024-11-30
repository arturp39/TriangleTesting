import org.example.TriangleChecker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> triangleTypeData() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(3, 4, 5, "Scalene"),
                org.junit.jupiter.params.provider.Arguments.of(5, 5, 5, "Equilateral"),
                org.junit.jupiter.params.provider.Arguments.of(6, 6, 10, "Isosceles")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5",
            "5, 5, 5",
            "6, 6, 10"
    })
    void testIsTriangleValid(int a, int b, int c) {
        assertTrue(TriangleChecker.isTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 2, 5"
    })
    void testIsTriangleInvalid(int a, int b, int c) {
        assertFalse(TriangleChecker.isTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 5, Equilateral",
            "10, 10, 10, Equilateral"
    })
    void testGetTriangleTypeEquilateral(int a, int b, int c, String expectedType) {
        assertEquals(expectedType, TriangleChecker.getTriangleType(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 8, Isosceles",
            "6, 10, 6, Isosceles"
    })
    void testGetTriangleTypeIsosceles(int a, int b, int c, String expectedType) {
        assertEquals(expectedType, TriangleChecker.getTriangleType(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, Scalene",
            "7, 8, 9, Scalene"
    })
    void testGetTriangleTypeScalene(int a, int b, int c, String expectedType) {
        assertEquals(expectedType, TriangleChecker.getTriangleType(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("triangleTypeData")
    void testGetTriangleTypeWithMethodSource(int a, int b, int c, String expectedType) {
        assertEquals(expectedType, TriangleChecker.getTriangleType(a, b, c));
    }
}
