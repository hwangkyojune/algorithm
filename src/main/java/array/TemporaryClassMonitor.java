package array;

import java.util.*;
import java.util.stream.Collectors;

//6학년의 임시반장을 정하고자 한다. 한번이라도 같은 반 경험이 있는 동급생 수를 기준으로 임시반장을 정하고자 한다.
public class TemporaryClassMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> studentsAccord = new ArrayList<>();

        for(int i=0;i<n;i++){
            List<Integer> studentAccord = new ArrayList<>();
            for(int j=0;j<5;j++){
                studentAccord.add(sc.nextInt());
            }
            studentsAccord.add(studentAccord);
        }

        List<List<Integer>> isStudentsSameClass = new ArrayList<>();
        for(int i=0;i<n;i++){
            isStudentsSameClass.add(new ArrayList<>(Collections.nCopies(n,0)));
        }

        TemporaryClassMonitor tcm = new TemporaryClassMonitor();
        tcm.solution(studentsAccord,isStudentsSameClass);
    }
    public void solution(List<List<Integer>> studentsAccord,List<List<Integer>> isStudentsSameClass){
        for(int i=0;i<5;i++){
            for(int j=0;j<studentsAccord.size();j++){
                for(int k=j;k<studentsAccord.size();k++){
                    if(studentsAccord.get(j).get(i)==studentsAccord.get(k).get(i)){
                        isStudentsSameClass.get(j).set(k,1);
                        isStudentsSameClass.get(k).set(j,1);
                    }
                }
            }
        }
        List<Integer> an = isStudentsSameClass.stream().mapToInt(a->Collections.frequency(a,1)).mapToObj(a->a)
                .collect(Collectors.toList());


        System.out.println(an.indexOf(Collections.max(an))+1);

    }
}
