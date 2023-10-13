import java.util.Arrays;
import java.util.Scanner;

class Challenge {

    /**
     * 1. Asks the user to enter a list of whole numbers
     * 2. Asks the user to enter the target sum
     * 3. Calls the functions and prints out the number of combinations to make the
     * sum
     * 
     * @param args
     */
    public static void main(String args[]) {
        // Create a scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a sorted array of whole numbers
        System.out.print("Enter sorted array of whole numbers (space-separated, asending order): ");

        // Keep reading until enter pressed
        String inputArray = scanner.nextLine();

        // Store the strain array splittin on a space
        String[] arrayElements = inputArray.split(" ");

        // Create an int array big enough to hold the numbers
        int[] sortedArray = new int[arrayElements.length];

        // Convert each string value into an int and put it in the int array
        for (int i = 0; i < arrayElements.length; i++) {
            sortedArray[i] = Integer.parseInt(arrayElements[i]);
        }

        // Ask the user to enter the target sum
        System.out.print("Enter the target sum: ");

        // Read the value
        int X = scanner.nextInt();

        // Calls the method to find matching pairs that equal the target sum and store
        // the returned value
        int pairCount = findPairsToMakeSum(sortedArray, X);

        // Print out the number of pairs that make the target sum
        System.out.println("From the array of numbers: " + Arrays.toString(sortedArray) + "\nTo make a total of " + X
                + " using pairs\nWe have " + pairCount + " combination(s).");

        // Close scanner
        scanner.close();
    }

    /**
     * Takes an array of whole numbers and an integer, loops through the array in
     * pairs
     * and returns the number of combinations that can make the interger
     * 
     * @param arrayOfNumbers
     * @param sumToMake
     * @return
     */
    public static int findPairsToMakeSum(int[] arrayOfNumbers, int sumToMake) {
        // Index of the first element in the array
        int left = 0;

        // Index of the last element in the array
        int right = arrayOfNumbers.length - 1;

        // Number of combinations found to make the sum
        int count = 0;

        // Loop through the array taking the first and last element and moving either
        // one up or one down until all combinations have been tested
        while (left < right) {
            // Get the current sum of a pair
            int sum = arrayOfNumbers[left] + arrayOfNumbers[right];

            // If the current sum and the sum we want to make are equal then increase the
            // count value (meaning we have a pair)
            // and move to the next position on the left side of the array and move down a
            // position on the right side of the array
            if (sum == sumToMake) {
                count++;
                left++;
                right--;

                // If the current sum is less than the sum we want to make then move the left
                // position up one space to the right and try the loop again
            } else if (sum < sumToMake) {
                left++;
                // If the current sum is greater than the sum we want to make then move the
                // right position down one space to the left and try the loop again
            } else {
                right--;
            }
        }

        return count;
    }
}