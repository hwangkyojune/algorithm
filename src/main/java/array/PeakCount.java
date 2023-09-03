package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//NxN 격자판에서 봉우리 개수를 찾는 알고리즘
public class PeakCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[][] grid = new Integer[n+2][n+2];


        for(int i=0;i<grid.length;i++){
            grid[i] = Collections.nCopies(n+2, 0).toArray(new Integer[n+2]);
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        PeakCount pc = new PeakCount();
        pc.solution(grid);
    }
    public void solution(Integer[][] grid){
        int count =0;
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid.length-1;j++){
                if(isPeak(grid,i,j)) count++;
            }
        }
        System.out.println(count);
    }

    private boolean isPeak(Integer[][] grid, int i,int j){
        int biggest = Collections.max(
                Arrays.asList(grid[i+1][j],grid[i-1][j],grid[i][j+1],grid[i][j-1])
        );

        if(grid[i][j]>biggest) return true;
        else return false;
    }
}
