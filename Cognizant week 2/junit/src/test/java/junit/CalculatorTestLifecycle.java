package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTestLifecycle {

    Calculator calc;

    @Before
    public void setUp() {
        // Arrange
        System.out.println("Setting up Calculator object...");
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        // Act
        int result = calc.add(7, 3);

        // Assert
        assertEquals(10, result);
    }

    @After
    public void tearDown() {
        // Cleanup
        System.out.println("Cleaning up Calculator object...");
        calc = null;
    }
}
