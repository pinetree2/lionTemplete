package ex01;
import java.util.Scanner;
public class Factorial {

    public static void main(String[] args){
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int result = Factorial(N);
        System.out.println(result);
    }

    public static int Factorial(int n ){
        if (n == 0 || n == 1) {
            return 1;
        }
        else{
            return n*Factorial(n-1);
        }
    }
}
