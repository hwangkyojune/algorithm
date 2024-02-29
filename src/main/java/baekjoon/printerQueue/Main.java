package baekjoon.printerQueue;
//https://www.acmicpc.net/problem/1966
//우선 순위 프린트부터 제거

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        StringBuffer answer = new StringBuffer();

        for(int i=0;i<testCase;i++){
            int[] numAndLoc = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Integer[] numLine = new Integer[numAndLoc[0]];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Queue<Integer> priorities = new LinkedList<>();

            int k = 0;
            while(st.hasMoreTokens()){
                int priority = Integer.parseInt(st.nextToken());

                priorities.add(priority);
                numLine[k] = priority;
                k++;
            }

            Arrays.sort(numLine,(e1,e2)->Integer.compare(e2,e1));

            int locToSee = numAndLoc[1];

            int result=1;

            for(int num : numLine){
                while (priorities.peek()!=num){
                    int numNext = priorities.poll();
                    priorities.add(numNext);
                    if(locToSee==0){
                        locToSee+=priorities.size();
                    }
                    locToSee--;
                }
                priorities.poll();
                if(locToSee==0){
                    break;
                }
                locToSee--;
                result++;
            }

            answer.append(result+"\n");
        }
        System.out.println(answer);
    }
}
