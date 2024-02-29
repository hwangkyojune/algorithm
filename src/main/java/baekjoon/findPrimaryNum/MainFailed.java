package baekjoon.findPrimaryNum;
//https://www.acmicpc.net/problem/1929
//소수를 구해서 그것만 나누는 방식으로 진행했는데 시간이 같지 않나??

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFailed {

    public static List<Integer> primeNums;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] fromTo = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        primeNums = new ArrayList<>(Arrays.asList(2));

        for(int i=3;i<=fromTo[1];i++){
            addIfPrime(i);
        }

        StringBuffer result = new StringBuffer();
        for(int primNum : primeNums){
            if(primNum>=fromTo[0]){
                result.append(primNum+"\n");
            }
        }
        System.out.println(result);
    }

    public static void addIfPrime(int num){
        for(int primeNum : primeNums){
            if(num%primeNum == 0){
                return;
            }
        }
        primeNums.add(num);
    }
}
