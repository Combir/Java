import java.util.Scanner;
public class Problem015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите цену (рубли копейки): ");
        int rub = in.nextInt();
        int pennies = in.nextInt();
        int price = rub * 100 + pennies;

        System.out.print("Введите сумму (рубли копейки): ");
        rub = in.nextInt();
        pennies = in.nextInt();
        int income = rub * 100 + pennies;

        if (income < price) {
            System.out.println("Ooooops! This item is worth more.");
        } else {
            int change = income - price; // Расчет сдачи
            System.out.println("Сдача: " + (change / 100) + " рублей и " + (change % 100) + " копеек.");
        }
    }
}



