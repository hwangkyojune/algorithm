package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//입력받은 문자열 중에서 알파벳만 뒤집는 알고리즘
public class ReverseCertainString {
    public boolean isAlphabet(char c){
        if((65<=c)&&(c<=122)){
            if((90<c)&&(c<97)){
                return false;
            }
            return true;
        }
        return false;
    }

    public String input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp = null;
        try{
            inp = br.readLine();
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return inp;
    }

    public static void main(String[] args) {
        ReverseCertainString rs = new ReverseCertainString();
        String string = rs.input();
        char[] stringA = string.toCharArray();

        ArrayList<Integer> alphabetLocs = new ArrayList<>();

        ArrayList<Character> alphabets = new ArrayList<>();

        for(int i=0;i<stringA.length;i++){
            if(rs.isAlphabet(stringA[i])){
                alphabetLocs.add(i);
                alphabets.add(stringA[i]);
            }
        }

        int j=0;
        for(int i=alphabets.size()-1;i>=0;i--){
            char tmp = alphabets.get(i);
            stringA[alphabetLocs.get(j)] = tmp;
            j++;
        }

        String result = new String(stringA);

        System.out.println(result);


    }
}
