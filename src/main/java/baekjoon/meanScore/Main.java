package baekjoon.meanScore;
//https://www.acmicpc.net/problem/1546

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        List<Integer> scores = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double average = scores.stream().mapToInt(a->a).average().getAsDouble();
        int max = scores.stream().mapToInt(a->a).max().getAsInt();

        System.out.println(average*100/max);
    }
}
