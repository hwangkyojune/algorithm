package baekjoon.movie_title;

//영화 감독 숌
//https://www.acmicpc.net/problem/1436

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());

        int inc = 1000;
        int currentVal = 666;
        int rank = 1;
        int result = currentVal;
        if(input==1){
            System.out.println(currentVal);
            return;
        }

        while(true){

            currentVal += inc;
            String valString = Integer.toString(currentVal);

            //666이 하나만 존재한다면 그냥 천 더해주기
            if(valString.indexOf("666") == valString.lastIndexOf("666")){
                rank++;
                if(rank == input){
                    result = currentVal;
                    break;
                }
            }
            else{
                int width = valString.length()-1-(valString.indexOf("666")+2);
                int valueToAdd = (int)Math.pow(10,width);
                rank +=valueToAdd;

                if(rank >= input){
                    int maxThis = currentVal/valueToAdd*valueToAdd+valueToAdd-1;
                    result = maxThis-(rank-input);
                    break;
                }
            }

        }

        System.out.println(result);
    }
}
