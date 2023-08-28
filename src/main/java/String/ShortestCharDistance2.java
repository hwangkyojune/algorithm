package String;

import java.util.Scanner;

//ShortestCharDistance과 문제는 같으나 다른 알고리즘 사용.
public class ShortestCharDistance2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String request = sc.nextLine();

        sc.close();

        String string = request.substring(0,request.indexOf(" "));
        char c = request.charAt(request.length()-1);

        ShortestCharDistance2 scd2 = new ShortestCharDistance2();

        int[] result = scd2.Solution(string,c);
        for(int e:result){
            System.out.print(e + " ");
        }

    }
    public int[] Solution(String string,char c){

        int[] locations = new int[string.length()];
        int loc =-1001;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)==c){
                loc = i;
            }
            locations[i] = i - loc;

        }

        loc = 1000;
        for(int i=string.length()-1;i>-1;i--){
            if(string.charAt(i)==c){
                loc = i;
            }
            if(locations[i]>loc-i){
                locations[i] = loc-i;
            }
        }

        return locations;
    }
}
