package String;

import java.util.*;

//입력받은 문자와 문자열을 입력받고, 문자열의 문자들이 입력받은 문자와의 최소거리를 계산한다.
public class ShortestCharDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String request = sc.nextLine();

        sc.close();

        String string = request.substring(0,request.indexOf(" "));
        char c = request.charAt(request.length()-1);

        ShortestCharDistance scd = new ShortestCharDistance();

        List<Integer> charLocs = scd.findCharLocs(string,c);

        List<Integer> refLocs = scd.findRefLocs(charLocs);


        Integer charLoc = 0;
        Integer refLoc =0;

        List<Integer> distances = new ArrayList<>();


        for(int i=0;i<string.length();i++){
            if(refLoc < refLocs.size()){
                if(i>refLocs.get(refLoc)){

                    refLoc++; charLoc++;

                }
            }
            distances.add(Math.abs(i-charLocs.get(charLoc)));
        }
        for(Integer distance:distances){
            System.out.print(distance+" ");
        }
    }

    List<Integer> findCharLocs(String string,char c){
        List<Integer> charLocs = new ArrayList<>();
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) == c){
                charLocs.add(i);
            }
        }
        return charLocs;
    }

    //찾은 요소들의 중간 값들 반환
    List<Integer> findRefLocs(List<Integer> charLocs){
        List<Integer> refLocs = new ArrayList<>();

        for(int i=0;i<charLocs.size()-1;i++){
            refLocs.add((charLocs.get(i)+charLocs.get(i+1))/2);
        }

        return refLocs;

    }
}
