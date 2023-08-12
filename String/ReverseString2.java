package String;

import java.util.ArrayList;
import java.util.Scanner;

//문자열을 거꾸로 바꾸는 알고리즘 ReverseString과는 다른 방식으로 코딩
public class ReverseString2 {
    public String solution(String string){
        char[] chars = string.toCharArray();
        int lt =0;
        int rt =chars.length-1;
        while(lt<rt){
            char tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;
            lt++;
            rt--;
        }
        string = new String(chars);
        return string;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<String> revStrings = new ArrayList<>();
        ReverseString2 rs2 = new ReverseString2();
        sc.nextLine();
        for(int i=0;i<num;i++){
            String string = sc.nextLine();
            String revString = rs2.solution(string);
            revStrings.add(revString);
        }
        for(String str : revStrings){
            System.out.println(str);
        }


    }
}
