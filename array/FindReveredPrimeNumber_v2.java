package array;

import java.util.*;

//FindReveredPrimeNumber의 문제를 에라토스테네스의 체를 이용해서 구현해보자
//입력받은 양수 중 가장 큰 숫자보다 작거나 같은 소수들을 구한다. 소수들을 리스트에 저장
//소수들이 들어있는 리스트에 요소들이 속하는지 검사

public class FindReveredPrimeNumber_v2 {
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
        FindReveredPrimeNumber_v2 frd = new FindReveredPrimeNumber_v2();
        long beforeTime = System.currentTimeMillis();
        frd.solution(reversedNums);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    public void solution(List<Integer> reversedNums){

        int max = Collections.max(reversedNums);

        int[] numbers = new int[max+1];
        List<Integer> primeNumbers = new ArrayList<>();

        for(int i=2;i<numbers.length;i++){
            //1이면 이미 누군가의 배수, 아니면 소수
            if(numbers[i]==0){
                primeNumbers.add(i);
                for(int j=1; j*i<numbers.length; j++){
                    numbers[j*i] = 1;
                }
            }
        }


        for(int num:reversedNums){
            if(isDecimal(num,primeNumbers)) System.out.print(num+" ");
            System.out.println("");
        }
    }

    public boolean isDecimal(int num,List<Integer> primeNumbers){
        if(Collections.binarySearch(primeNumbers,num)>=0) {
            return true;
        }else{
            return false;
        }
    }

}
