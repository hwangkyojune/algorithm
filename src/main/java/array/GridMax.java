package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//격자판이 주어지면 모든 열,행,대각선의 합 중 가장 큰 값을 출력
public class GridMax {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        List<List<Integer>> grid = new ArrayList<>();

        int nums = sc.nextInt();

        for(int i=0;i<nums;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<nums;j++){
                row.add(sc.nextInt());
            }
            grid.add(row);
        }
        GridMax gm = new GridMax();
        gm.solution(grid);
    }
    public void solution(List<List<Integer>> grid){
        int currentMax = 0;
        for(AtomicInteger i = new AtomicInteger(0); i.get()<grid.size(); i.incrementAndGet()){
            List<Integer> oneRow = grid.get(i.get());
            int rowSum = oneRow.stream().mapToInt(a->a).sum();
            int colSum = grid.stream().mapToInt(a->a.get(i.get())).sum();
            int bigger = rowSum>colSum?rowSum:colSum;

            if(bigger>currentMax) currentMax = bigger;
        }
        int sum1 =0;
        int sum2 =0;
        for(int i=0;i<grid.size();i++){
            sum1+=grid.get(i).get(i);
            sum2+=grid.get(grid.size()-i-1).get(i);
        }
        if(sum1>currentMax) currentMax = sum1;
        if(sum2>currentMax) currentMax = sum2;
        System.out.println(currentMax);
    }

}
