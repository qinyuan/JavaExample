package metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

public class TestTimer {
    private static final MetricRegistry metrics = new MetricRegistry();
    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(
            metrics).build();

    private static final Timer requests = metrics.timer(MetricRegistry.name(
            TestTimer.class, "request"));

    public static void handleRequest(int sleep) {
        Timer.Context context = requests.time();
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            context.stop();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
        reporter.start(3, TimeUnit.SECONDS);
        for (int i = 0; i < 20; i++) {
            handleRequest(200);
        }
        */
        Timer timer =new Timer();
        while (true) {
            Timer.Context context= timer.time();
            Thread.sleep(100);
            context.stop();
            System.out.println(timer.getOneMinuteRate());
        }
    }
}