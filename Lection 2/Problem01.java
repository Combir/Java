import java.util.Scanner;
class Problem01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        float n = in.nextFloat();

        int rounded = Math.round(n);

        System.out.println("Округленное число: " + rounded);
    }
}