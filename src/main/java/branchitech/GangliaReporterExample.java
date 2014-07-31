package branchitech;

import com.branchitech.metrics.ganglia.GMetricBuilder;
import com.branchitech.metrics.ganglia.GangliaReporter;
import com.branchitech.metrics.ganglia.IGMetric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.TimeMeter;
import info.ganglia.gmetric4j.gmetric.GMetric;

import java.io.IOException;

public class GangliaReporterExample {

    private GangliaReporter reporter;

    public GangliaReporterExample(MetricRegistry registry) throws Exception {
        reporter = getReporter(registry);
    }

    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    reporter.report(); // report every 15 seconds
                    try {
                        Thread.sleep(15000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private IGMetric getIGMetric() throws IOException {
        final String host = "239.2.11.71";
        final int port = 8649;
        final int ttl = 1;
        GMetric gMetric = new GMetric(host, port, GMetric.UDPAddressingMode.MULTICAST, ttl);
        return GMetricBuilder.build(gMetric);
    }

    private GangliaReporter getReporter(MetricRegistry registry) throws IOException {
        GangliaReporter.Builder builder = new GangliaReporter.Builder();
        builder.to(getIGMetric());
        builder.withAppId("exampleAppId");
        builder.inRegistry(registry);
        return builder.build();
    }

    private final static TimeMeter timeMeter = new TimeMeter();

    private static MetricRegistry getRegistry() {
        MetricRegistry registry = new MetricRegistry();
        registry.register("testTimeMeter", timeMeter);
        return registry;
    }

    public static void main(String[] args) throws Exception {
        GangliaReporterExample example = new GangliaReporterExample(getRegistry());
        example.run();
        while (true) {
            timeMeter.mark(); // throws Exception every 3 minute
            Thread.sleep(180000);
        }

        /*
        GangliaReporter reporter = getReporter();
        int i = 0;
        while (true) {
            if (++i == 12) {
                timeMeter.mark(); // throws Exception every 3 minute
                i = 0;
            }
            reporter.report(); // report every 15 seconds
            Thread.sleep(15000);
        }
        */
    }
}
