package String;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;

//입력한 문자열에서 특정 문자의 개수를 찾는 알고리즘
public class FindChar {
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
//        InputStreamReader is = new InputStreamReader(System.in);
        String string = null;
        char c =0;

//        try{
//           string = br.readLine().toLowerCase();
//           c = (char)is.read();
//            string = in.nextLine();
//            c = (char)in.nextInt();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        string = in.next().toLowerCase();

        c = in.next().charAt(0);
        c = Character.toLowerCase(c);


        int num = 0;
        for(int i =0;i<string.length();i++){
            if(string.charAt(i)==c)num++;
        }
        System.out.println(num);

    }
}
