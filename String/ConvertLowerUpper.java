package String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.spec.ECField;

//입력받은 문자열에서 대문자는 소문자로 소문자는 대문자로 변환하는 알고리즘
public class ConvertLowerUpper {
    public void Solution(String string){
        StringBuffer result = new StringBuffer();
        char mid = 0;
        for(int i=0;i < string.length();i++){
            if((mid = string.charAt(i))<=90){
                result.append((char)(mid+32));
            }else{
                result.append((char)(mid-32));
            }
        }
        Character.isLowerCase(mid);
        System.out.println(result);

    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try{
            string = br.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        ConvertLowerUpper clu = new ConvertLowerUpper();
        clu.Solution(string);

    }
}