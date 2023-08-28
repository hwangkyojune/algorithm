package array;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        int[] fibo = new int[num];

        fibo[0] = 1;
        fibo[1] = 1;

        for(int i=2;i<fibo.length;i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        for(int fiboElement : fibo){
            System.out.print(fiboElement+" ");
        }
    }
}
