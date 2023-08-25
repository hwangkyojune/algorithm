package array;

import java.util.Scanner;

public class FindPrimeNumber {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        Integer[] decimals = new Integer[num];

        decimals[0] = 2;
        FindPrimeNumber fd = new FindPrimeNumber();
        fd.solution(decimals,num);
    }


    public void solution(Integer[] decimals,int num){
        int decimalLoc = 1;
        findDecimal:
        for(int i=3; i<=num;i++){
            for(int j =0;j<decimalLoc;j++){
                if((i%decimals[j])==0) {
                    continue findDecimal;
                }
            }
            decimals[decimalLoc] = i;
            decimalLoc++;
        }

        System.out.println(decimalLoc);
    }

}
