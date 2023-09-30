package array;

import java.util.*;

/***
 * 학생 수와 시험 수를 입력받고, 모든 시험 동안 점수를 잘본 학생이 멘토가 되는 시스템이다.
 * 멘토 멘티가 되는 짝이 몇개 될 수 있는지 구하는 알고리즘
 */

public class MentoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //학생수
        int n = sc.nextInt();
        //시험 수
        int m = sc.nextInt();

        List<List<Integer>> table = new ArrayList<>();

        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<Integer>();
            table.add(row);
            for (int j=0;j<n;j++){
                row.add(sc.nextInt());
            }
        }

        int possibleMento = 0;

        //한 학생마다 몇번의 멘토링이 가능한지 구한다.
        for(int i=0;i<n;i++){
            //현재까지 누구를 앞서 나가 있는지 저장하는 배열을 생성한다.
            Integer[] currentWin =new Integer[n+1];
            Arrays.fill(currentWin,0);
            //첫번째 시험의 등수에 따라 학생을 뽑는다.
            int studentNumber = table.get(0).get(i);
            //각 학생이 특정 학생을 몇번 이겼는지 기록한다.
            for(int j=0;j<m;j++){
                int rate = table.get(j).indexOf(studentNumber);
                for(int student:table.get(j).subList(rate+1,n)){
                    currentWin[student]++;
                }
            }
            //모든 시험동안 이긴 경우를 더한다.
            possibleMento+= Collections.frequency(Arrays.asList(currentWin),m);

        }
        System.out.println(possibleMento);

    }

}
