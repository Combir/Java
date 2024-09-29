import java.util.Scanner;
class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of dollars: ");
        double dollars = scanner.nextDouble();

        double pounds = dollars / 1.487;
        double franks = dollars / 0.172;
        double marks = dollars / 0.584;
        double yen = dollars / 0.00955;

        System.out.println("you'll get:");
        System.out.println("pounds, " + pounds);
        System.out.println("German brand, " + marks);
        System.out.println("yen." + yen);
    }
}

