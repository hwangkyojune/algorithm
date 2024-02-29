package baekjoon.statics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2108
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] numLine = new int[n];

        while(n-->0){
            numLine[n] = Integer.parseInt(bf.readLine());
        }


        Arrays.sort(numLine);
        int min = numLine[0];
        int max = numLine[numLine.length-1];
        int[] range = new int[max-min+1];

        int sum = 0;

        for(int i=0;i<numLine.length;i++){
            sum+=numLine[i];
            range[numLine[i]-min]+=1;
        }

        int avg = (int)Math.round(sum/(double)numLine.length);
        int mid = numLine[(numLine.length/2)];

        int freVal = Arrays.stream(range).max().getAsInt();

        int st = 0;
        int fre = 0;

        for(int i=0;i<range.length;i++){
            if(range[i]==freVal){
                fre = i;
                st++;
            }
            if(st==2){
                break;
            }
        }

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(fre+min);
        System.out.println(max-min);
    }
}
