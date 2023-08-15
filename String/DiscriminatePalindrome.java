package String;

import java.util.Scanner;

//입력받은 문자열이 회문인지 판별하는 알고리즘
public class DiscriminatePalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        sc.close();

        string = string.toLowerCase();

        DiscriminatePalindrome dp = new DiscriminatePalindrome();

        if(dp.solution(string)) System.out.println("YES");
        else System.out.println("NO");

    }

    public boolean solution(String string){


        int left = 0;
        int right = string.length()-1;

        while(left<right){
            if(string.charAt(left)!=string.charAt(right)){
                return false;
            }
            left ++; right--;
        }
        return true;
    }

}
