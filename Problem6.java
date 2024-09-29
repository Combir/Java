import java.util.Scanner;
class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        if (number % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

