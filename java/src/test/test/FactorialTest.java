package test.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Factorial;

class FactorialTest {

    @Test
    void testFact() {
        Assertions.assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628801, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }
}