package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = new ArrayList<>();
        try{
            int num = sc.nextInt();
            System.out.println(num);
            sc.nextLine();
            for(int i = 0 ; i < num; i++){
                strings.add(br.readLine());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        ReverseString rs = new ReverseString();
        for(int i = 0;i<strings.size();i++){
            System.out.println(rs.solution(strings.get(i)));
            System.out.println(i);
        }
    }
    public String solution(String string){
        String reverseString ="";
        for(int i = string.length()-1;i>=0;i--){
            reverseString = reverseString+string.charAt(i);
        }
        return reverseString;
    }
}
