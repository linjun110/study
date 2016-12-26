package multiThread;

/**
 * Created by linjun on 16/9/27.
 */
public class ProducerConsumerSolution {
    public static void main(String[] args) throws InterruptedException {
        Repo r = new Repo();
        new Thread(new Producer(r)).start();
        new Thread(new Producer(r)).start();
        new Thread(new Producer(r)).start();
        new Thread(new Producer(r)).start();
        new Thread(new Consumer(r)).start();
        new Thread(new Consumer(r)).start();
        new Thread(new Consumer(r)).start();
        new Thread(new Consumer(r)).start();
        while (true){
            Thread.sleep(1000);
        }
    }
}

class Producer implements Runnable{
    private Repo repo;
    public Producer(Repo repo){
        this.repo = repo;
    }
    @Override
    public void run() {
        while(true) {
            try {
                int v = (int) (Math.random()*100);
                repo.add(v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private Repo repo;
    public Consumer(Repo repo){
        this.repo = repo;
    }
    @Override
    public void run() {
        while(true) {
            try {
                int v = repo.rm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
