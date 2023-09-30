package homework;

public class ThreadTest3 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Thread2());
        Thread thread1 = new Thread(new Thread2());
        try {
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }


        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
