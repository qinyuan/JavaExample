package multithread;

/**
 * Created by qinyuan on 14-6-24.
 */
public class HelloWorld {


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new HelloWorldThread(i)).start();
            try {
                Thread.sleep(i * 300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class HelloWorldThread implements Runnable {

    private int id;

    HelloWorldThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World " + id + " " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
