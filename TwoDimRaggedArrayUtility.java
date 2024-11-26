package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class is a utility class that provides methods for the HolidayBonus GUI.
 * Due: 11/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public final class TwoDimRaggedArrayUtility {

    /**
     * Reads a ragged array from a file.
     * 
     * @param file the input file
     * @return a two-dimensional ragged array of doubles
     * @throws FileNotFoundException if the file is not found
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        ArrayList<double[]> rows = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(" ");
            double[] row = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                row[i] = Double.parseDouble(values[i]);
            }
            rows.add(row);
        }
        scanner.close();
        return rows.toArray(new double[rows.size()][]);
    }

    /**
     * Writes a ragged array to a file.
     * 
     * @param data the ragged array to write
     * @param file the output file
     * @throws FileNotFoundException if the file cannot be written to
     */
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                writer.print(data[i][j] + " ");
            }
            writer.println();
        }
        writer.close();
    }

    /**
     * Calculates the total of all elements in the array.
     * 
     * @param data the ragged array
     * @return the total of all elements
     */
    public static double getTotal(double[][] data) {
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    /**
     * Calculates the average of all elements in the array.
     * 
     * @param data the ragged array
     * @return the average of all elements
     */
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            count += data[i].length;
        }
        return total / count;
    }

    /**
     * Calculates the total of all elements in a specific row.
     * 
     * @param data the ragged array
     * @param row  the row index
     * @return the total of the specified row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (int i = 0; i < data[row].length; i++) {
            total += data[row][i];
        }
        return total;
    }

    /**
     * Calculates the total of all elements in a specific column.
     * 
     * @param data the ragged array
     * @param col  the column index
     * @return the total of the specified column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                total += data[i][col];
            }
        }
        return total;
    }

    /**
     * Finds the highest value in a specific row.
     * 
     * @param data the ragged array
     * @param row  the row index
     * @return the highest value in the row
     */
    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
            }
        }
        return highest;
    }

    /**
     * Finds the index of the highest value in a specific row.
     * 
     * @param data the ragged array
     * @param row  the row index
     * @return the index of the highest value in the row
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = 0;
        double highest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the lowest value in a specific row.
     * 
     * @param data the ragged array
     * @param row  the row index
     * @return the lowest value in the row
     */
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
            }
        }
        return lowest;
    }

    /**
     * Finds the index of the lowest value in a specific row.
     * 
     * @param data the ragged array
     * @param row  the row index
     * @return the index of the lowest value in the row
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = 0;
        double lowest = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the highest value in a specific column.
     * 
     * @param data the ragged array
     * @param col  the column index
     * @return the highest value in the column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (data[i][col] > highest) {
                    highest = data[i][col];
                }
            }
        }
        return highest;
    }

    /**
     * Finds the index of the highest value in a specific column.
     * 
     * @param data the ragged array
     * @param col  the column index
     * @return the index of the highest value in the column
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (data[i][col] > highest) {
                    highest = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * Finds the lowest value in a specific column.
     * 
     * @param data the ragged array
     * @param col  the column index
     * @return the lowest value in the column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (data[i][col] < lowest) {
                    lowest = data[i][col];
                }
            }
        }
        return lowest;
    }

    /**
     * Finds the index of the lowest value in a specific column.
     * 
     * @param data the ragged array
     * @param col  the column index
     * @return the index of the lowest value in the column
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (data[i][col] < lowest) {
                    lowest = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * Finds the highest value in the entire array.
     * 
     * @param data the ragged array
     * @return the highest value in the array
     */
    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > highest) {
                    highest = data[i][j];
                }
            }
        }
        return highest;
    }

    /**
     * Finds the lowest value in the entire array.
     * 
     * @param data the ragged array
     * @return the lowest value in the array
     */
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }
        return lowest;
    }
}
