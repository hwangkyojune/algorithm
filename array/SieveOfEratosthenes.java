package array;

import java.util.Arrays;
import java.util.Scanner;

//에라토스테네스의 체를 사용해서 소수를 구하는 알고리즘
public class SieveOfEratosthenes {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int[] numArray = new int[num+1];

        SieveOfEratosthenes soe = new SieveOfEratosthenes();
        soe.solution(numArray);
    }

    public void solution(int[] numArray){
        int totalDecimal =0;
        int drainage = 0;
        for(int i=2;i<numArray.length;i++){
            int multiple = 1;
            //1이면 이미 누군가의 배수, 아니면 소수
            if(numArray[i]==0){
                totalDecimal++;
                for(int j=1; j*i<numArray.length; j++){
                    numArray[j*i] = 1;
                }
            }
        }
        System.out.println(totalDecimal);
    }

}
