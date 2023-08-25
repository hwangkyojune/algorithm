package array;

import java.util.Arrays;
import java.util.Scanner;

//정수를 입력받고, 앞의 정수가 뒤의 정수보다 큰 경우에만 출력하는 알고리즘
public class BiggerThanBefore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        String[] stringArray = s.nextLine().split(" ");
        int[] intArray = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();

        System.out.print(intArray[0]+" ");
        for(int i=1;i<intArray.length;i++){
            if(intArray[i]>intArray[i-1]) System.out.print(intArray[i]+" ");
        }


    }

}
