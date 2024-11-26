package application;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class defines methods to calculate holiday bonus and total holiday bonus.
 * Due: 11/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kidus Yohanness
*/

public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    /**
     * Calculates holiday bonuses for each store in the district.
     * 
     * @param data the sales data in a two-dimensional ragged array
     * @return an array of doubles representing bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        // Iterate over each column (category)
        for (int col = 0; col < getMaxColumns(data); col++) {
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            // Assign bonuses for each store
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    // If it's the highest in the category, assign the highest bonus
                    if (row == highestIndex) {
                        bonuses[row] += HIGHEST_BONUS;
                    }
                    // If it's the lowest in the category, assign the lowest bonus
                    else if (row == lowestIndex) {
                        bonuses[row] += LOWEST_BONUS;
                    }
                    // For all other sales, assign the 'other' bonus
                    else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        
        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses for all stores in the district.
     * 
     * @param data the sales data in a two-dimensional ragged array
     * @return the total amount of holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0;
        double[] bonuses = calculateHolidayBonus(data);

        // Sum up all the individual store bonuses
        for (int i = 0; i < bonuses.length; i++) {
            total += bonuses[i];
        }

        return total;
    }

    /**
     * Determines the maximum number of columns in the ragged array. (this is for 
     * the calculateHolidayBonus method)
     * 
     * @param data the sales data in a two-dimensional ragged array
     * @return the maximum number of columns
     */
    private static int getMaxColumns(double[][] data) {
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > max) {
                max = data[i].length;
            }
        }
        return max;
    }
}

