package String;

import java.util.Scanner;

public class Decoding {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Integer requestNum  = Integer.parseInt(s.nextLine());
        String requestString  = s.nextLine();


        Decoding cd = new Decoding();
        cd.solution(requestString,requestNum);
    }

    public void solution(String string,int num){

        String binaryString = string.replaceAll("#","1").replaceAll("\\*","0");
        char[] decoded = new char[num];

        for(int i=0;i<num;i++){
            decoded[i] = (char)Integer.parseInt(binaryString.substring(i*7,(i+1)*7),2);
        }
        System.out.println(decoded);

    }
}
