package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    //https://www.acmicpc.net/problem/1012

    public static void main(String[] args) {

        Main fieldRule = new Main();
        List<List<Integer>> field;
        try{
            field = fieldRule.createField();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public List<List<Integer>> createField() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> initContent = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int columnLength = initContent.get(0);
        int lowLength = initContent.get(1);
        int vegetableNum = initContent.get(2);

        List<List<Integer>> field = new ArrayList<>();

//        Stream.iterate(0,n->n+1).limit(columnLength)
//                .map((i)->new ArrayList(Collections.nCopies(0,lowLength))).collect(Collectors.toList());

        for(int i=0;i<vegetableNum;i++){
            List<Integer> loc = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int columnLoc = loc.get(0);
            int lowLoc = loc.get(1);

            field.get(columnLoc).set(lowLoc,1);
        }

        return field;
    }

    public int essentialBugNums(List<List<Integer>> field,int row,int column){
        for(int i=0;i<column;i++){
            for (int j=0;j<row;j++){
                if(field.get(i).get(j)==1){

                }
            }
        }
        return 0;
    }

    public void removeBugPossibleLoc(List<List<Integer>> field,int row,int column){
    }
}
