package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//정답 유뮤를 입력받아서, 점수를 출력한다.
//연속으로 맞을 때 마다 1점의 가산점을 추가로 부여한다.
//ex) 0 0 1 1 1 0 1 0 같이 입력이 들어온 경우 0 0 1 2 3 0 1 0 점의 점수가 부여된다.
public class CalculateScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfProblems = sc.nextInt();

        List<Integer> scoring = new ArrayList<>();

        for(int i=0;i<numOfProblems;i++){
            scoring.add(sc.nextInt());
        }
        CalculateScore cs = new CalculateScore();
        int totalScore = cs.calculateScore(scoring);
        System.out.println(totalScore);


    }
    public int calculateScore(List<Integer> scoring){
        int beforeScore = 0;
        int totalScore = 0;

        for(int score : scoring){
            if(score==1){
                beforeScore++;
                totalScore += beforeScore;
            }else{
                beforeScore = 0;
            }
        }
        return totalScore;
    }
}
