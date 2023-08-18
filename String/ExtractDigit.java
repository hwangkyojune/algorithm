package String;

import java.util.Scanner;

//문자열에서 숫자만 추출해서 자연수로 변환하는 알고리즘
public class ExtractDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        String numString  = string.replaceAll("[^0-9]","");

        int result = Integer.parseInt(numString);

        System.out.println(result);
    }
}
