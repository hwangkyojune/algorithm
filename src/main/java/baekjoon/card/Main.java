package baekjoon.card;
//https://www.acmicpc.net/problem/2164

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        LinkedList<Integer> numLine = new LinkedList<>(Stream.iterate(1,a->a+1).limit(n).collect(Collectors.toList()));

        if(numLine.size()==1){
            System.out.println(numLine.poll());
            return;
        }

        while(true){
            numLine.poll();
            if(numLine.size()==1){
                break;
            }
            numLine.addLast(numLine.poll());
        }
        System.out.println(numLine.poll());
    }

    public static LinkedList<Integer> createNumLine(int n){
        LinkedList<Integer> numLine = new LinkedList<>();
        for(int i=1;i<n+1;i++){
            numLine.addLast(i);
        }
        return numLine;
    }
}
