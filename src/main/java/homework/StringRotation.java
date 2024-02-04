package homework;

import java.util.Scanner;

public class StringRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        for(int i=0;i<=string.length();i++){
            System.out.println(string.substring(i,string.length())+string.substring(0,i));
        }
    }
}
