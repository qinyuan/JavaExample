package gmetric4j;
import info.ganglia.gmetric4j.gmetric.GMetric;
import info.ganglia.gmetric4j.gmetric.GMetricSlope;
import info.ganglia.gmetric4j.gmetric.GMetricType;
import info.ganglia.gmetric4j.gmetric.GangliaException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorUtil {

    private static final Logger logger = LoggerFactory.getLogger(MonitorUtil.class);
    /*
    private static final HedwigConfig HC = HedwigConfig.getInstance();

    private static class GMetricHOlder {
        static String GANGLIA_HOST = HC.getString("ganglia.host", "");
        final static int GANGLIA_PORT = HC.getInt("ganglia.port", 7649);
        final static int GANGLIA_TTL = HC.getInt("ganglia.ttl", 1);
        static {
            if(StringUtils.isEmpty(GANGLIA_HOST)){
                GANGLIA_HOST = NetworkUtils.getEth0Address();
            }
            System.out.println("[GANGLIA MONITOR] begin to init gmetric");
            System.out.println("[GANGLIA MONITOR] GANGLIA_HOST : " + GANGLIA_HOST);
            System.out.println("[GANGLIA MONITOR] GANGLIA_PORT : " + GANGLIA_PORT);
            System.out.println("[GANGLIA MONITOR] GANGLIA_TTL : " + GANGLIA_TTL);
        }
        final static GMetric G_METRIC = new GMetric(GANGLIA_HOST, GANGLIA_PORT,
                GMetric.UDPAddressingMode.UNICAST, GANGLIA_TTL, true);
    }
    */

    private static GMetric getGMetric() {
        return null;
        //return GMetricHOlder.G_METRIC;
    }

    /**
     * monitor a metric
     * @param name Name of the metric
     * @param value Value of the metric
     * @param type Type of the metric.  
     *        Either string|int8|uint8|int16|uint16|int32|uint32|float|double
     * @param units Unit of measure for the value
     * @param slope Either zero|positive|negative|both
     * @param group Group Name of the metric
     */
    public static void monitor(String name, String value, GMetricType type,
                               String units,  GMetricSlope slope, String group) {
        GMetric gm = getGMetric();
        try {
            gm.announce(name, value, type, units, slope, 60, 0,  group);
        } catch (GangliaException e) {
            logger.error("monitor fail. name : {}, value:{}, error:{}",
            name, value, e.getMessage(), e);
        }

    }

    /**
     * monitor a metric
     * @param name Name of the metric
     * @param value Value of the metric
     * @param group Group Name of the metric
     */
    public static void monitor(String name,  String value, String group){
        monitor(name, value, GMetricType.STRING, " ", GMetricSlope.BOTH, group);
    }

    /**
     * monitor a positive metric
     * @param name Name of the metric
     * @param value Value of the metric
     * @param group Group Name of the metric
     */
    public static void counter(String name,  String value, String group){
        monitor(name, value, GMetricType.STRING, " ", GMetricSlope.POSITIVE, group);
    }

    /**
     * monitor a metric
     * @param name Name of the metric
     * @param value Value of the metric
     * @param group Group Name of the metric
     */
    public static void monitor(String name,  float value, String group){
        monitor(name, Float.toString(value),GMetricType.DOUBLE, " ", GMetricSlope.BOTH, group);
    }

    /**
     * monitor a positive metric
     * @param name Name of the metric
     * @param value Value of the metric
     * @param group Group Name of the metric
     */
    public static void counter(String name, float value, String group){
        monitor(name, Float.toString(value),GMetricType.FLOAT, " ", GMetricSlope.POSITIVE, group);
    }

}
