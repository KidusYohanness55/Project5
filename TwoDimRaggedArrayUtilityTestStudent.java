package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;


/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is a Junit test class that tests methods from TwoDimRaggedArrayUtility.
 * Due: 11/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] testArray;
    private File testFile;

    /**
     * Set up a test array and test file before each test case.
     */
    @BeforeEach
    public void setUp() throws Exception {
        testArray = new double[][] {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0, 7.0, 8.0, 9.0 }
        };

        // Prepare test file
        testFile = new File("testFile.txt");
        try (PrintWriter writer = new PrintWriter(testFile)) {
            writer.println("1.0 2.0 3.0");
            writer.println("4.0 5.0");
            writer.println("6.0 7.0 8.0 9.0");
        }
    }

    /**
     * Test the readFile method.
     */
    @Test
    public void testReadFile() throws FileNotFoundException {
        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);
        assertArrayEquals(testArray, result);
    }

    /**
     * Test the writeToFile method.
     */
    @Test
    public void testWriteToFile() throws FileNotFoundException {
        File outputFile = new File("outputFile.txt");
        TwoDimRaggedArrayUtility.writeToFile(testArray, outputFile);

        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(testArray, result);
    }

    /**
     * Test the getTotal method.
     */
    @Test
    public void testGetTotal() {
        double total = TwoDimRaggedArrayUtility.getTotal(testArray);
        assertEquals(45.0, total, 0.001);
    }

    /**
     * Test the getAverage method.
     */
    @Test
    public void testGetAverage() {
        double average = TwoDimRaggedArrayUtility.getAverage(testArray);
        assertEquals(5.0, average, 0.001);
    }

    /**
     * Test the getRowTotal method.
     */
    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(testArray, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(testArray, 1), 0.001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(testArray, 2), 0.001);
    }

    /**
     * Test the getColumnTotal method.
     */
    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(testArray, 0), 0.001);
        assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(testArray, 1), 0.001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(testArray, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getColumnTotal(testArray, 3), 0.001);
    }

    /**
     * Test the getHighestInRow method.
     */
    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(testArray, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(testArray, 1), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(testArray, 2), 0.001);
    }
    
    /**
     * Test the getHighestInRowIndex method.
     */
    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(testArray, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(testArray, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(testArray, 2));
    }
    /**
     * Test the getLowestInRow method.
     */
    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(testArray, 0), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(testArray, 1), 0.001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(testArray, 2), 0.001);
    }

    
    /**
     * Test the getLowestInRowIndex method.
     */
    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(testArray, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(testArray, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(testArray, 2));
    }
    
    /**
     * Test the getHighestInColumn method.
     */
    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(testArray, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(testArray, 1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(testArray, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(testArray, 3), 0.001);
    }

    /**
     * Test the getHighestInColumnIndex method.
     */
    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testArray, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testArray, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testArray, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testArray, 3));
    }

    /**
     * Test the getLowestInColumn method.
     */
    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(testArray, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(testArray, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(testArray, 2), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getLowestInColumn(testArray, 3), 0.001);
    }

    /**
     * Test the getLowestInColumnIndex method.
     */
    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testArray, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testArray, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testArray, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testArray, 3));
    }
    
    /**
     * Test the getHighestInArray method.
     */
    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(testArray), 0.001);
    }

    /**
     * Test the getLowestInArray method.
     */
    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(testArray), 0.001);
    }
}
