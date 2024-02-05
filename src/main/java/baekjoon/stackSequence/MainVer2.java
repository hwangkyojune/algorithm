package baekjoon.stackSequence;

/**
 * 시간이 오래 걸려서 다시해보겠음
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class MainVer2 {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine());

        int[] sequence = new int[length];
        for(int i=0;i<length;i++){
            sequence[i] = Integer.parseInt(bf.readLine());
        }

        int[] orderedSequence = Stream.iterate(0,a->a+1).limit(length+1).mapToInt(n->n).toArray();

        Logger logger = new Logger();
        int loc = 0;
        for(int numToFind:sequence){
            if(numToFind>loc){
                logger.pushTimesOf(numToFind-loc);
                appendAllElementToStack(orderedSequence,loc+1,numToFind+1);
                loc = numToFind;
                // pop!
                stack.pop();
                logger.popTimeOf(1);
            }
            else{
                int lastElement = stack.pop();
                logger.popTimeOf(1);

                if(lastElement<numToFind){
                    System.out.println("NO");
                    return;
                }
            }

        }

        logger.printLog();

    }

    public static void appendAllElementToStack(int[] array,int first,int last){
        for(int i=first;i<last;i++){
            stack.push(array[i]);
        }
    }

    public static class Logger{
        private StringBuffer log = new StringBuffer();
        String push = "+"+"\n";
        String pop ="-"+"\n";

        public void pushTimesOf(int time){
            for (int i=0;i<time;i++){
                log.append(push);
            }
        }

        public void popTimeOf(int time){
            for (int i=0;i<time;i++){
                log.append(pop);
            }
        }

        public void printLog(){
            System.out.println(log);
        }
    }

}
