import java.util.Scanner;
class Problem09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
            //System.out.println(i);
        }
        System.out.print(factorial);
    }
}

