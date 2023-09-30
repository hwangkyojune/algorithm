package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//정렬된 수를 가지고 있는 두 배열을 합치는 알고리즘
public class ConcatArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n1 = sc.nextInt();

        List<Integer> arr1 = new ArrayList<>();
        for(int i=0;i<n1;i++){
            arr1.add(sc.nextInt());
        }
        Integer n2 = sc.nextInt();

        List<Integer> arr2 = new ArrayList<>();
        for(int i=0;i<n2;i++){
            arr2.add(sc.nextInt());
        }
        ConcatArray ca = new ConcatArray();
        List<Integer> result = ca.solution(arr1,arr2);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        }
    public List<Integer> solution(List<Integer> arr1,List<Integer> arr2) {
        Integer p1 = 0;
        Integer p2 = 0;
        List<Integer> finalResult = new ArrayList<>();

        while((p1<arr1.size())&&(p2<arr2.size())){
            if(arr1.get(p1)<=arr2.get(p2)){
                finalResult.add(arr1.get(p1));
                p1++;
            }else{
                finalResult.add(arr2.get(p2));
                p2++;
            }
        }
        finalResult.addAll(arr1.subList(p1,arr1.size()));
        finalResult.addAll(arr2.subList(p2,arr2.size()));
//        if(p1<arr1.size()){
//            finalResult.addAll(arr1.subList(p1,arr1.size()));
//        }
//        if(p2<arr2.size()){
//            finalResult.addAll(arr2.subList(p2,arr2.size()));
//        }


        return finalResult;
    }
}
