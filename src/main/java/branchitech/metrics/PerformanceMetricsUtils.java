package branchitech.metrics;

import com.branchitech.metrics.PerformanceMetrics;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.TimeMeter;
import com.codahale.metrics.Timer;

import java.util.Map;
import java.util.Map.Entry;

public class PerformanceMetricsUtils {
    private PerformanceMetricsUtils() {
    }

    private static void print(Object obj) {
        System.out.print(obj.toString());
    }

    private static void println(Object obj) {
        System.out.println(obj.toString());
    }

    private static void printMetric(Metric value) {
        if (value instanceof Counter) {
            Counter counter = (Counter) value;
            println(" getCount():" + counter.getCount());
        } else if (value instanceof TimeMeter) {
            TimeMeter timeMeter = (TimeMeter) value;
            print(" getLastMarkTimestamp():" + timeMeter.getLastTimestamp() + ";");
            print(" getMeanRate():" + timeMeter.getMeanRate() + ";");
            print(" getOneMinuteRate():" + timeMeter.getOneMinuteRate());
            println(" getCount():" + timeMeter.getCount());
        } else if (value instanceof Timer) {
            Timer timer = (Timer) value;
            print(" getMeanRate():" + timer.getMeanRate() + ";");
            print(" getOneMinuteRate():" + timer.getOneMinuteRate());
            print(" getMin():" + timer.getSnapshot().getMin());
            print(" getMax():" + timer.getSnapshot().getMax());
            print(" getMean():" + timer.getSnapshot().getMean());
            print(" getMedian():" + timer.getSnapshot().getMedian());
            println(" getCount():" + timer.getCount());
        } else {
            println(value);
        }
    }

    public static void printPerformanceMetrics() {
        Map<String, PerformanceMetrics> metrics = PerformanceMetrics.metrics();
        System.out.println("metrics size: " + metrics.size() + "\n");

        for (Entry<String, PerformanceMetrics> entry : metrics.entrySet()) {
            PerformanceMetrics pm = entry.getValue();
            println("name: " + pm.getName());
            println("count: " + pm.getCount());
            println("allCount: " + pm.getAllCount());
            println("metric detail: ");

            for (Entry<String, Metric> metryEntry : pm.getMetrics().entrySet()) {
                print(metryEntry.getKey() + " ");
                printMetric(metryEntry.getValue());
            }

            println("");
        }
    }
}
