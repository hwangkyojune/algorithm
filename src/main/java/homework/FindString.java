package homework;

import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 입력 :");
        StringBuffer content = new StringBuffer(scanner.nextLine());
        while (true){
            System.out.print("명령 (종료:그만):");
            String command = scanner.nextLine();
            if(command.equals("그만"))break;

            String findString = command.split("!")[0];
            String replaceString = command.split("!")[1];

            int location = content.indexOf(findString);

            if(location==-1){
                System.out.println("찾을 수 없습니다.");
                continue;
            }

            content.replace(location,location+findString.length(),replaceString);
            System.out.println(content);
        }

    }
}
