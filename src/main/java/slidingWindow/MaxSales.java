package slidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//m일의 각 매출이 주어지고, 연속된 k일의 최대 매출을 구하는 알고리즘
//ex) m = 10 k=3으로 주어지면 12 15 (11 20 25) 10 20 19 13 15
public class MaxSales {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstL = null ;
        String secondL = null;
        try{
            firstL = br.readLine();
            secondL = br.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }

        Scanner sc = new Scanner(firstL);
        Integer totalDate = sc.nextInt();
        Integer date = sc.nextInt();

        List<Integer> sales = Arrays.stream(secondL.split(" ")).mapToInt(Integer::valueOf)
                .boxed().collect(Collectors.toList());

        MaxSales maxSales = new MaxSales();
        Integer result = maxSales.solution(date,sales);
        System.out.println(result);
    }
    public Integer solution(Integer date, List<Integer> sales){
        Integer currentSum =0;

        for(int i=0;i<date;i++){
            currentSum += sales.get(i);
        }


        Integer maxSum = currentSum;

        for(int i = date;i<sales.size();i++){
            currentSum += sales.get(i);
            currentSum -= sales.get(i-date);
            if(currentSum>maxSum) maxSum = currentSum;
        }
        return maxSum;
    }
}
