package baekjoon.palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * 팰린드롬인지 판단하기
 * https://www.acmicpc.net/problem/1259
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> nums = new ArrayList<>();

        while(true){
            String num = bf.readLine();
            if(num.equals("0")){
                break;
            }
            nums.add(num);
        }

        for(String element:nums){
            verifyingPalindrome(element);
        }

    }

    public static void verifyingPalindrome(String element){
        int halfPoint = element.length()/2+element.length()%2;
        for(int i=0;i<halfPoint;i++){
//            if(element.charAt(i)!=element.charAt(element.length()-1-i)){
//                System.out.println("no");
//                return;
//            }
            if(element.charAt(i)!=element.charAt(element.length()-1-i)){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
