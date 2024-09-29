import java.util.Scanner;

class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Initial contribution: ");
        double initialContribution = scanner.nextDouble();

        System.out.print("Number of years: ");
        int numberOfYears = scanner.nextInt(); // use int for years

        System.out.print("The interest rate: ");
        double theInterestRate = scanner.nextDouble();

        double answer = initialContribution;

        // Loop through each year and apply the interest rate
        for(int i = 0; i < numberOfYears; i++) {
            answer += answer * (theInterestRate / 100);
        }

        // Output the final amount
        System.out.println("Final amount: " + answer);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}