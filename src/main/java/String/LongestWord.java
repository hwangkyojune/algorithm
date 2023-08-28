package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 문장의 단어 중 가장 긴 단어를 출력하는 클래스
public class LongestWord {
    public String solution(String sentence){
        String[] words = sentence.split(" ");
        String longestWords = "";
        for(String word : words){
            if(word.length()>longestWords.length()){
                longestWords = word;
            }
        }
        return longestWords;

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
