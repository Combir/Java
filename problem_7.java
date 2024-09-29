// №7

//import java.util.Scanner;
//
//class HelloWorld {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        int[] tickets = getTickets(n);
//
//        for (int i = 0; i < tickets.length; i++) {
//            System.out.print(tickets[i] + " ");
//        }
//    }
//
//    static int[] getTickets(int n) {
//        int[] tickets = {0, 0, 0, 0, 0}; // [1, 5, 10, 20, 60]
//        int[] prices = {15, 70, 125, 230, 440};
//
//        // Buy as many 60-trip tickets as possible
//        tickets[4] = n / 60;
//        n %= 60;
//
//        // Buy as many 20-trip tickets as possible
//        tickets[3] = n / 20;
//        n %= 20;
//
//        // Buy as many 10-trip tickets as possible
//        tickets[2] = n / 10;
//        n %= 10;
//
//        // Buy as many 5-trip tickets as possible
//        tickets[1] = n / 5;
//        n %= 5;
//
//        // Any remaining trips, buy single tickets
//        tickets[0] = n;
//
//        return tickets;
//    }
//}

