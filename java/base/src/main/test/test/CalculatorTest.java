package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void add() {
        Assertions.assertEquals(100, calculator.add(100));
        Assertions.assertEquals(140, calculator.add(150));
    }

    @Test
    @DisabledOnOs(OS.MAC)
    @DisabledOnJre(JRE.JAVA_8)
    void sub() {
    }
}