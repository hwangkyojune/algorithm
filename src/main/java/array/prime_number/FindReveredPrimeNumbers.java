package array.prime_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//여러 수를 입력받고, 뒤집으면 소수인 수들을 출력한다.
public class FindReveredPrimeNumbers implements FindPrimeNumbers{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.next());

        List<Integer> reversedNums = new ArrayList<>();
        for(int i=0;i<length;i++){
//            StringBuffer num = new StringBuffer(s.next());
            double min = 1000000;
            double max = 9000000;
            StringBuffer num = new StringBuffer(Integer.toString((int) ((Math.random() * (max - min)) + min)));
            System.out.println(num);
            int reversedNum = Integer.parseInt(num.reverse().toString());
//            System.out.println(reversedNum);
            reversedNums.add(reversedNum);
        }
        FindReveredPrimeNumbers frd = new FindReveredPrimeNumbers();
        long beforeTime = System.currentTimeMillis();
        frd.getPrimeNumbers(reversedNums);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    public List<Integer> getPrimeNumbers(List<Integer> reversedNums){
        List<Integer> primeNums = new ArrayList<>();
        for(int num:reversedNums){
            if(isDecimal(num)) primeNums.add(num);
        }
        return primeNums;
    }

    public boolean isDecimal(int num){
        if(num == 1) return false;
        for(int i=2;i<num;i++){
            if((num%i)==0) return false;
        }
        return true;
    }
}
