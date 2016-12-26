package multiThread;

/**
 * Created by linjun on 16/9/27.
 */
public class BarrierSolution {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i<100; i++){
            new Thread(new Barrier(i)).start();
        }
        while (true){
            Thread.sleep(1000);
        }
    }
}

class Barrier implements Runnable{
    public static int count = 0;
    private int id;
    Barrier(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("START! " + id);
        synchronized (Barrier.class){
            count ++;
            System.out.println("count! " + count);
        }
        // perform some expensive operation
        expensiveOp();

        synchronized (Barrier.class){
            count --;
            System.out.println("count! " + count);
            while(count != 0){
                try {
                    Barrier.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Barrier.class.notifyAll();
        }
        System.out.println("FREEDOM! " + id);
    }
    private void expensiveOp(){
        System.out.println("op start! " + id);
        for(long i = 0l; i<Integer.MAX_VALUE; i++ ){
            for(long j = 0l; j< 2; j++ ){

            }
        }
        System.out.println("op end! " + id);
    }
}
