package array;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int gameNum = s.nextInt();
        int[] playerATurn = new int[gameNum];
        int[] playerBTurn = new int[gameNum];

        for(int i=0;i<playerATurn.length;i++){
            playerATurn[i] = s.nextInt();
        }

        for(int i=0;i<playerBTurn.length;i++){
            playerBTurn[i] = s.nextInt();
        }

        RockPaperScissors rps = new RockPaperScissors();

        for(int i=0;i<gameNum;i++){
            System.out.println(rps.whoWin(playerATurn[i],playerBTurn[i]));
        }

    }
    public String whoWin(int a,int b){
        if(a == b) return "D";
        else if((a == 1 && b == 3)||(a == 2 && b == 1)||(a == 3 && b == 2)){
            return "A";
        }else{
            return "B";
        }
    }
}
