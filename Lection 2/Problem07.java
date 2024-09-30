import java.util.Scanner;

class Problem07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество поездок: ");
        int n = in.nextInt();

        // Проверка на отрицательное число
        if (n < 0) {
            System.out.println("Ошибка: количество поездок не может быть отрицательным.");
            return; // Завершаем выполнение программы
        }

        int ticket_60, ticket_20, ticket_10, ticket_5, ticket_1;

        ticket_60 = n / 60;
        n -= ticket_60 * 60;
        if (n >= 36) {  // билет на 60 поездок
            ticket_60++;
            n = 0;
        }

        ticket_20 = n / 20;
        n -= ticket_20 * 20;
        if (n >= 18) {  // билет на 20 поездок
            ticket_20++;
            n = 0;
        }

        ticket_10 = n / 10;
        n -= ticket_10 * 10;
        if (n >= 9) {  // билет на 10 поездок
            ticket_10++;
            n = 0;
        }

        ticket_5 = n / 5;
        n -= ticket_5 * 5;
        ticket_1 = n % 5;

        // Выводим количество билетов
        System.out.printf("Ticket 1: %d \nTicket 5: %d \nTicket 10: %d \nTicket 20: %d \nTicket 60: %d\n",
                ticket_1, ticket_5, ticket_10, ticket_20, ticket_60);

        // Рассчитываем общую цену
        int price = ticket_1 * 15 + ticket_5 * 70 + ticket_10 * 125 + ticket_20 * 230 + ticket_60 * 440;
        System.out.printf("Total price: %d\n", price);
    }
}

