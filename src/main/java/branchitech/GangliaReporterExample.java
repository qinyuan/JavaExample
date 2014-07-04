package branchitech;

import com.branchitech.metrics.ganglia.GMetricBuilder;
import com.branchitech.metrics.ganglia.GangliaReporter;
import com.branchitech.metrics.ganglia.IGMetric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.TimeMeter;
import info.ganglia.gmetric4j.gmetric.GMetric;

import java.io.IOException;

public class GangliaReporterExample {

    private static IGMetric getIGMetric() throws IOException {
        final String host = "239.2.11.72";
        final int port = 8649;
        final int ttl = 1;
        GMetric gMetric = new GMetric(host, port, GMetric.UDPAddressingMode.MULTICAST, ttl);
        return GMetricBuilder.build(gMetric);
    }

    private final static TimeMeter timeMeter = new TimeMeter();

    private static MetricRegistry getRegistry() {
        MetricRegistry registry = new MetricRegistry();
        registry.register("testTimeMeter", timeMeter);
        return registry;
    }

    private static GangliaReporter getReporter() throws IOException {
        GangliaReporter.Builder builder = new GangliaReporter.Builder();
        builder.to(getIGMetric());
        builder.withAppId("exampleAppId");
        builder.inRegistry(getRegistry());
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        GangliaReporter reporter = getReporter();
        int i = 0;
        while (true) {
            if (++i == 6) {
                timeMeter.mark();
                i = 0;
            }
            reporter.report();
            Thread.sleep(5000);
        }
    }
}
