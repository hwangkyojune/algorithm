package array;

import array.prime_number.FindPrimeNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CompareReversedPrimeNumber {

    @Test
    void compareTime() {
        System.out.println("hello test");

        List<Integer> nums = getRandomNumList();

        array.prime_number.FindPrimeNumbers frpn = new array.prime_number.FindReveredPrimeNumbers();
        array.prime_number.FindPrimeNumbers frpn2 = new array.prime_number.FindReveredPrimeNumbers_v2();

        System.out.println(getTime(frpn,nums)+" "+getTime(frpn2,nums));

    }

    private long getTime(FindPrimeNumbers fpn, List<Integer> nums){

        long beforeTime = System.currentTimeMillis();
        fpn.getPrimeNumbers(nums);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        return secDiffTime;

    }


    public List<Integer> getRandomNumList(){
//        Scanner s = new Scanner(System.in);
//        int length = Integer.parseInt(s.next());

        int length = 100;

        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<length;i++){

            double min = 1000000;
            double max = 9000000;

            int num = (int) ((Math.random() * (max - min)) + min);

            nums.add(num);
        }
        return nums;
    }
}