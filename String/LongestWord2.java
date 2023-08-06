package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//LongestWord2에서는 split대신 substr과 indexOf사용
public class LongestWord2 {
    public String solution(String sentence){
        String word = "";
        int index = 0;
        while(sentence.length() != 0){
            if((index =sentence.indexOf(" "))!=-1){
                if(index>word.length()){
                    word = sentence.substring(0,index);
                    index++;
                }
            }
            else{
                if((index = sentence.length())> word.length()){
                    word = sentence;
                }
            }
            sentence = sentence.substring(index);
        }
        return null;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String sentence = null;
        try{
            sentence = br.readLine();
        }catch (Exception e){
            return ;
        }
        LongestWord lw = new LongestWord();
        String result = lw.solution(sentence);
        System.out.println(result);

    }
}
