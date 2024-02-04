package baekjoon;

import java.util.*;

public class Fibonacci {
    //백준 1003번 문제
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        Fibonacci fibonacci = new Fibonacci();

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<number;i++){
            int fibonacciNum = scanner.nextInt();

            List<Integer> oneResult = fibonacci.iterationNumOfZeroAndOne(fibonacciNum);

            result.add(oneResult);
        }

        for (int i=0;i<result.size();i++){
            System.out.println(String.format("%d %d",result.get(i).get(0),result.get(i).get(1)));
        }

    }

    public List<Integer> iterationNumOfZeroAndOne(int number){
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(Arrays.asList(1,0)));
        dp.add(new ArrayList<>(Arrays.asList(0,1)));

        for(int i = 2; i <= number ; i++){
            dp.add(addEachElementOfLists(dp.subList(i-2,i)));
        }

        return dp.get(number);
    }

    public List<Integer> addEachElementOfLists(List<List<Integer>> lists){
        List<Integer> list = new ArrayList<>(lists.get(0));

        for(int i=1;i<lists.size();i++){
            for(int j=0;j<list.size();j++){
                list.set(j,list.get(j)+lists.get(i).get(j));
            }
        }

        return list;
    }


}
