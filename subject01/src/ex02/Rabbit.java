package ex02;
import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = rabbitCount(n);
        System.out.println(result);
        scanner.close();
    }

    public static int rabbitCount(int month) {
        if (month == 1) {
            return 2;
        } else if (month == 2) {
            return 4;
        } else {
            return rabbitCount(month - 1) + 2*rabbitCount(month - 2);
        }
    }
}