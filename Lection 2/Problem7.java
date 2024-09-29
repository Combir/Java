import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of trips planned
        int n = scanner.nextInt();

        // Ticket costs and number of trips per ticket
        int[] costs = {15, 70, 125, 230, 440};
        int[] trips = {1, 5, 10, 20, 60};

        // Array to store the number of tickets for each type
        int[] result = new int[5];

        // Start with the largest ticket (60-trip), and work our way down
        for (int i = 4; i >= 0; i--) {
            // Determine how many tickets of this type we can use
            result[i] = n / trips[i];
            n %= trips[i];

            // If there are remaining trips, we might need one more ticket of this type
            if (n > 0 && i == 0) {
                result[i]++;
            }
        }

        // Print the results (number of tickets for each type)
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}