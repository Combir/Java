import java.util.Scanner;
class Problem04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Initial contribution: ");
        double initialContribution = scanner.nextDouble();

        System.out.print("Number of years: ");
        int numberOfYears = scanner.nextInt(); // use int for years

        System.out.print("The interest rate: ");
        double theInterestRate = scanner.nextDouble();

        double answer = initialContribution;

        for(int i = 0; i < numberOfYears; i++) {
            answer += answer * (theInterestRate / 100);
        }

        System.out.println("Final amount: " + answer);

        scanner.close();
    }
}
