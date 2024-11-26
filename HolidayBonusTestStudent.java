package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is a Junit test class that tests methods from HolidayBonus.
 * Due: 11/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class HolidayBonusTestStudent {

	/**
	 * Test the calculateHolidayBonus method.
	 */
    @Test
    public void testCalculateHolidayBonus() {
        // Sample sales data for 3 stores, each with sales in different categories
        double[][] data = {
            {1000, 2000, 3000},
            {2000, 1500, 2500},
            {3000, 3500, 4000}
        };

        // Expected bonus result
        double[] expectedBonuses = {5000.0, 4000.0, 15000.0};

        // Get the calculated holiday bonuses for each store
        double[] result = HolidayBonus.calculateHolidayBonus(data);

        // Compare expected vs actual results
        assertArrayEquals(expectedBonuses, result, 0.001);
    }

    
    /**
     * Test the calculateTotalHolidayBonus method.
     */
    @Test
    public void testCalculateTotalHolidayBonus() {
        // Sample sales data for 3 stores, each with sales in different categories
        double[][] data = {
            {1000, 2000, 3000},
            {2000, 1500, 2500},
            {3000, 3500, 4000}
        };

        // Expected total bonus
        double expectedTotalBonus = 24000.0;

        // Assert the total bonus is as expected
        assertEquals(expectedTotalBonus, HolidayBonus.calculateTotalHolidayBonus(data), 0.001);
    }
}