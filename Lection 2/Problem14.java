import java.util.Scanner;
class Problem14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number > 0) {
            System.out.println("sign(x) = 1");
        } else if (number < 0) {
            System.out.println("sign(x) = -1");
        } else {
            System.out.println("sign(x) = 0");

        }
    }
}

