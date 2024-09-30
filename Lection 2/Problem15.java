import java.util.Scanner;
class Problem15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int max = Math.max(a, c);
        int min = Math.min(a, c);
        int max2 = Math.max(b, d);
        int min2 = Math.min(b, d);

        System.out.println(max - min);
        System.out.println(max2 - min2);
    }
}

