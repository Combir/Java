import java.util.Scanner;
class Problem08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a == 0 && b == 0)
            System.out.println("INF");

        else if (a == 0 && b != 0)
            System.out.println("NO");
        else if (((-(double) b / a) % 1 == 0))
            System.out.println(((-(double) b / a)));
        else
            System.out.println("NO");
    }
}
