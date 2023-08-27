package array.prime_number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CompareReversedPrimeNumber {

    @Test
    void compareTime() {

        List<Integer> nums = getRandomNumList();

        FindReveredPrimeNumbers frpn = new FindReveredPrimeNumbers();
        FindReveredPrimeNumbers_v2 frpn2 = new FindReveredPrimeNumbers_v2();

        getTime(frpn,nums);
        getTime(frpn2,nums);

    }

    private void getTime(FindPrimeNumbers fpn, List<Integer> nums){

        long beforeTime = System.currentTimeMillis();
        fpn.findPrimeNumbers(nums);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

    }


    private List<Integer> getRandomNumList(){
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.next());

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