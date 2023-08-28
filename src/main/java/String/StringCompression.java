package String;


import java.util.Scanner;

//문자열 압축, 연속되는 중복 문자열이 있으면 문자 오른쪽에 반복되는 숫자를 붙이는 방법으로 문자열을 압축
public class StringCompression {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        StringCompression sc = new StringCompression();
        String compressedString = sc.solution(string);

        System.out.println(compressedString);

    }
    public String solution(String string){

        StringBuilder compressedString = new StringBuilder("") ;
        char beforeChar ='*';
        int count =0;

        for(int i=0 ; i<string.length() ; i++){
            if(string.charAt(i)!=beforeChar){
                if(count>1) compressedString.append(count);
                count = 0;
                compressedString.append(string.charAt(i));
            }
            beforeChar = string.charAt(i);
            count ++;
        }

        if(count>1) compressedString.append(count);

        return compressedString.toString();
    }
}
