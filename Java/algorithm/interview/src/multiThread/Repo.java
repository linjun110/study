package multiThread;

/**
 * Created by linjun on 16/9/27.
 */
public class Repo {
    private int[] q;
    final private int CAP = 50;
    private int current = 0;

    public Repo(){
        q = new int[CAP];
    }

    synchronized public void add(int v) throws InterruptedException {
        while(current == CAP){
            wait();
        }
        q[current++] = v;
        System.out.println("Thread " + Thread.currentThread().getId() + " add " + v);
        showQ();
        notify();
    }

    synchronized public int rm() throws InterruptedException {
        while(current == 0){
            wait();
        }
        current--;
        System.out.println("Thread " + Thread.currentThread().getId() + " rm " + q[current]);
        showQ();
        notify();
        return q[current];
    }
    private void showQ(){
        for(int i = 0; i < current; i++){
            System.out.print(q[i] + "-");
        }
        System.out.println();
    }
}
