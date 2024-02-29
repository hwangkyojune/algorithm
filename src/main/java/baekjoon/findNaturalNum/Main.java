package baekjoon.findNaturalNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/1920
// n 길이의 자연수 수열이 있을 때 m이 존재하는지 확인하는 프로그램
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<Integer> numLine = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int m = Integer.parseInt(bf.readLine());
        List<Integer> numsToFind = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        numLine.sort(Comparator.comparingInt(e -> e));

        StringBuffer resultLine = new StringBuffer();

        for(int numToFind : numsToFind){
            int thereNum = Collections.binarySearch(numLine,numToFind);
            if(thereNum<0){
                resultLine.append("0\n");
            }
            else{
                resultLine.append("1\n");
            }
        }

        System.out.println(resultLine);
    }
    public static void binarySearch(List<Integer> list){

    }
}
