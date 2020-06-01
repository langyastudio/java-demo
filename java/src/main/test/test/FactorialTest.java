package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class FactorialTest {

    @Test
    void Fact() {
        //Equal
        Assertions.assertEquals(1, Factorial.fact(1));
        //Assertions.assertEquals(3628801, Factorial.fact(10));

        //Throw
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
           Factorial.fact(-1);
        });

    }

    @ParameterizedTest
    //@MethodSource
    @CsvSource({"abc, AbC", "APPLE, Apple", "gooD, Good"})
    void capitalize(String input, String result) {
        assertEquals(result, Factorial.capitalize(input));
    }

    static List<Arguments> capitalize() {
        return List.of( // arguments:
                        Arguments.arguments("abc", "Abc"), //
                        Arguments.arguments("APPLE", "Apple"), //
                        Arguments.arguments("gooD", "Good"));
    }
}