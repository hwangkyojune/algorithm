package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MentoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> table = new ArrayList<>();

        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<Integer>();
            table.add(row);
            for (int j=0;j<n;j++){
                row.add(sc.nextInt());
            }
        }


    }

    public List<List<Integer>> comparing(ArrayList<Integer> row){
        return null;
    }
}
