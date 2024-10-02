import java.util.Scanner;
class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру в Цельсиях: ");
        float temperature = scanner.nextFloat();

        float fahrenheit = temperature * 9 / 5 + 32;
        System.out.println("Температура в Фаренгейтах: " + fahrenheit);
    }
}