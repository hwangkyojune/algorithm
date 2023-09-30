package homework;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;

public class ArrayPractice {
    public static void arrSum(Integer[][] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr[i].length-1;j++){
                arr[i][arr[i].length-1] += arr[i][j];
                arr[arr.length-1][j] += arr[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Integer[][] table = new Integer[4][5];

        for(int i=0;i<3;i++){
            Arrays.fill(table[i],0);

            for(int j=0;j<4;j++){
                table[i][j] = (i+1)*10 +j;
            }
        }
        Arrays.fill(table[3],0);

        arrSum(table);

        for(int i =0;i<4;i++){
            for(int j=0;j<5;j++){
                System.out.print(table[i][j] +" ");
            }
            System.out.println();

        }
    }
}
