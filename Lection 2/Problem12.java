import java.util.Scanner;
class Problem12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numberA = scanner.nextDouble();
        double numberB = scanner.nextDouble();
        if (numberA > numberB) {
            System.out.println("the largest number:" + Math.round(numberA));
        } else {
            System.out.println("the largest number:" + Math.round(numberB));
        }
    }
}

