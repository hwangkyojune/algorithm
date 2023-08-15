package String;

import java.util.Scanner;

//문제는 ValidDiscriminatePalindrome와 같으나 2에서는 정규표현식 사용
public class ValidDiscriminatePalindrome2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().toLowerCase().replaceAll("[^a-z]","");

        sc.close();

        System.out.println(string);

        String invstring = new StringBuilder(string).reverse().toString();

        System.out.println(invstring);

        if(string.equals(invstring)) System.out.println("YES");
        else System.out.println("NO");
    }
}
