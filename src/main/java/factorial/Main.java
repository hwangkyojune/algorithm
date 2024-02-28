package factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int numOfFive = 0;

        for(int i=1;i<=n;i++){
            numOfFive += numOfFiveAsMeasure(i);
        }

    }

    public static int numOfFiveAsMeasure(int num){
        int numOfFive = 0;
        while(true){
            System.out.println(num);
            if((num % 5) ==0){
                numOfFive++;
                num = num/5;
            }
            else{
                return numOfFive;
            }
        }
    }
}
