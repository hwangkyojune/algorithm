import org.junit.jupiter.api.Test;

import java.util.*;

public class TestAny {
    @Test
    public void testArrayList(){

        Runnable r = ()->{
            System.out.println("hi");
        };
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("hi");
            }
        };

        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(()->{
            System.out.println("bye");
        });
        thread1.start();

        List<Integer> list = new ArrayList<>(Arrays.asList(5,6,2,5,8,2));
        Collections.sort(list,(a,b)->{return b-a;});
        System.out.println(list);



    }
    public class Dog implements Comparable<Dog>{
        int age;
        public Dog(int age){
            this.age = age;
        }

        @Override
        public int compareTo(Dog o) {
            return this.age-o.age;
        }
    }
}
