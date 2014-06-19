package branchitech;

import java.util.concurrent.TimeUnit;

import com.branchitech.metrics.ganglia.GangliaReporter;
import com.branchitech.metrics.ganglia.GangliaReporterConfig;
import com.branchitech.metrics.ganglia.IGMetric;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;

import static org.mockito.Mockito.*;

public class GangliaReporterExample {

    public static void main(String[] args) {
        GangliaReporterConfig config = mock(GangliaReporterConfig.class);
        MetricRegistry registry = new MetricRegistry();
        config.setRegistry(registry);
        String APPID = "testapp";
        IGMetric gmetric = mock(IGMetric.class);
        config.setAppId(APPID);
        config.setGmetric(gmetric);
        config.setRateUnit(TimeUnit.SECONDS);
        config.setDurationUnit(TimeUnit.MICROSECONDS);
        GangliaReporter rp = new GangliaReporter(config);
        //rp.report();
        System.out.println(rp.toString());
        
        registry = config.getRegistry();
        MetricFilter filter = config.getFilter();
        System.out.println(registry.getGauges(filter));
        System.out.println(registry.getCounters(filter));
        System.out.println(registry.getHistograms(filter));
        System.out.println(registry.getMeters(filter));
        System.out.println(registry.getTimers(filter));
        
        System.out.println(config.getGmetric());
        /*
        report(registry.getGauges(filter),
                registry.getCounters(filter),
                registry.getHistograms(filter),
                registry.getMeters(filter),
                registry.getTimers(filter));
                */
    }

}
