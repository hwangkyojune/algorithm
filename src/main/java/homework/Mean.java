package homework;

import java.util.Scanner;

//정수들을 입력받고 평균들을 출력
public class Mean {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.print("랜덤한 정수들 : ");
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*10+1);
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        int sum=0;
        for(int num:arr)sum+=num;
        System.out.println("평균 : "+sum/10.0);
    }
}
