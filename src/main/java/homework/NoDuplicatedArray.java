package homework;

import java.util.Scanner;

//정수를 입력받아, 랜덤한 수를 정수 만큼 중복없이 가지고 있는 배열을 만든다.
public class NoDuplicatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int l = 0;
        int[] arr = new int[num];

        while(l<arr.length){
            int n = (int)(Math.random()*100+1);
            if(isNotDuple(arr,l,n)){
                arr[l]=n;
                l++;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(String.format("%5d",arr[i]));
            if((i+1)%10==0){
                System.out.println();
            }
        }
    }
    public static boolean isNotDuple(int[] arr,int l,int num){
        for(int i=0; i<l; i++){
            if(arr[i]==num) return false;
        }
        return true;
    }
}
