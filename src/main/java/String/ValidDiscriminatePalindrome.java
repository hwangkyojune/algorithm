package String;

import java.util.Scanner;

//입력받은 문자열에서 다른 문자들은 무시하고 오직 알파벳이 회문인지 검사한다.
public class ValidDiscriminatePalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        sc.close();

        string = string.toLowerCase();

        ValidDiscriminatePalindrome vdp = new ValidDiscriminatePalindrome();

        if(vdp.solution(string)) System.out.println("YES");
        else System.out.println("NO");

    }

    public boolean solution(String string){
        int left = 0;
        int right = string.length()-1;

        while(left<right){
            if(!Character.isLetter(string.charAt(left)))left++;
            else if(!Character.isLetter(string.charAt(right)))right--;
            else{
                if(string.charAt(left)!=string.charAt(right)) return false;
                left++;right--;
            }
        }
        return true;
    }

}
