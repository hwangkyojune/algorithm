package baekjoon.findPrimaryNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/1929
//에라토스테네스의 체
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] fromTo = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean[] checkTable = new boolean[fromTo[1]+1];

        Arrays.fill(checkTable,true);
        checkTable[0] = false;
        checkTable[1] = false;

        for(int i=2;i<checkTable.length;i++){
            if(!checkTable[i]){
                continue;
            }
            for(int j=2*i;j<checkTable.length;j+=i){
                checkTable[j] = false;
            }
        }

        StringBuffer result = new StringBuffer();
        for(int i = fromTo[0];i<checkTable.length;i++){
            if(checkTable[i]){
                result.append(i+"\n");
            }
        }
        System.out.println(result);
    }
}
