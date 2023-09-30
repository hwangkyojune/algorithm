package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//두 순열을 입력받아서 공통원소를 추출하는 알고리즘
public class FindCommonElement{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 =sc.nextInt();
        sc.nextLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1=br.readLine();
        System.out.println("l1"+l1);
//        try{
//            l1 = br.readLine();
//            System.out.println(l1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        List<Integer> list1 = new ArrayList<>();
        for(String i:l1.split(" ")){
            list1.add(Integer.parseInt(i));
        }

        int n2 = sc.nextInt();
        sc.nextLine();
        String l2 = sc.nextLine();
        List<Integer> list2 = new ArrayList<>();
        for(String i:l2.split(" ")){
            list2.add(Integer.parseInt(i));
        }

        Collections.sort(list1);
        Collections.sort(list2);


        FindCommonElement fce = new FindCommonElement();
        List<Integer> commonElement = fce.common(list1,list2);


        for(int i=0;i<commonElement.size();i++){
            System.out.print(commonElement.get(i)+" ");
        }
    }
    public List<Integer> common(List<Integer> list1,List<Integer> list2){
        int p1=0;
        int p2=0;

        List<Integer> commonElement = new ArrayList<>();

        while((p1<list1.size())&&(p2<list2.size())){
            if(list1.get(p1).equals(list2.get(p2))){
                commonElement.add(list1.get(p1));
                p1++;
                p2++;
            }else if(list1.get(p1)>list2.get(p2)){
                p2++;
            }else{
                p1++;
            }
        }

        return commonElement;
    }
}
