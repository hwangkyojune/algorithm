package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//학생들을 일렬로 세워놓고, 선생님이 볼 수 있는 학생의 수를 구하는 알고리즘
//뒤에 있는 학생이 키가 작거나 같으면 볼 수 없음
public class LookingStudent {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int studentNum = s.nextInt();
        int[] students = new int[studentNum];

        for(int i=0;i<students.length;i++){
            students[i] = s.nextInt();
        }

        int highest = 0;
        List<Integer> sawStudents = new ArrayList<>();

        for(int height : students){
            if(height > highest){
                highest = height;
                sawStudents.add(highest);
            }
        }

        System.out.println(sawStudents.size());

    }
}

