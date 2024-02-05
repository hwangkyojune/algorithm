package baekjoon.wordSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /***
     * 단어의 길이에 따라 단어 정렬
     * https://www.acmicpc.net/problem/1181
     */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bf.readLine());

        Set<String> words = new HashSet<>();


        for(int i=0;i<length;i++){
            words.add(bf.readLine());
        }

        int[] a = new int[10];
        List<List<String>> sorted = new ArrayList<>();

        for(int i=0;i<50;i++){
            sorted.add(new ArrayList<>());
        }

        for(String word: words){
            sorted.get(word.length()-1).add(word);
        }

        for(List<String> component : sorted){
            Collections.sort(component);
            for(String word : component){
                System.out.println(word);
            }
        }
    }
}
