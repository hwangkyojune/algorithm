package array;

import java.util.*;

//n명의 점수를 입력받아서 입력 받은 순서대로 등수를 출력하는 알고리즘
public class CalRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums = sc.nextInt();

        int[] scores = new int[nums];

        for(int i=0;i<scores.length;i++){
            scores[i] = sc.nextInt();
        }
        CalRanking cr = new CalRanking();
        for(int rank : cr.solution(scores,nums)){
            System.out.print(rank);
        }
    }
    public List<Integer> solution(int[] scores,int nums){
        List<Integer> ranks = new ArrayList<>(Collections.nCopies(nums,0));
        int beforeMax = -1;
        int beforeRank= 0;
        for(int i=0;i<ranks.size();i++){
            int curMax =-1;
            int curMaxLoc=0;
            for(int j=0;j<scores.length;j++){
                if((ranks.get(j)==0)&&(scores[j]>curMax)) {
                    curMax = scores[j];
                    curMaxLoc = j;
                }
            }
            if(beforeMax==curMax){
                ranks.set(curMaxLoc,beforeRank);
            }else{
                ranks.set(curMaxLoc,i+1);
                beforeRank = i+1;
                beforeMax = curMax;
            }
        }
        return ranks;
    }

}
