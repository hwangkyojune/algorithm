package String;

import java.util.Scanner;

public class ReverseCertainString2 {
    public boolean isAlphabet(char c){
        if((65<=c)&&(c<=122)){
            if((90<c)&&(c<97)){
                return false;
            }
            return true;
        }
        return false;
    }
    public String solution(String string){
        int lt = 0;
        int rt = string.length()-1;

        char[] chars = string.toCharArray();

        while(rt>lt){

            while(!this.isAlphabet(chars[lt]))lt++;
            while(!this.isAlphabet(chars[rt]))rt--;

            char tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;
            lt++;
            rt--;

        }
        return new String(chars);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        ReverseCertainString2 rs2 = new ReverseCertainString2();
        System.out.println(rs2.solution(string));

    }
}
