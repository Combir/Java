import java.util.Scanner;

class Problem10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int last = 0;
        int count = 0;
        while (number > 0) {
            last = number % 10;
            count += last;
            number /= 10;
        }
        System.out.println(count);
    }
}

