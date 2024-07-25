import java.util.Random;

public class MetricVolatileKeywordUse {


    public static void main(String [] args){
        Metrics metrics = new Metrics();
        BussinessLogic bussinessLogic = new BussinessLogic(metrics);
        BussinessLogic bussinessLogic1 = new BussinessLogic(metrics);
        PrinterMetrics printerMetrics = new PrinterMetrics(metrics);

        bussinessLogic.start();
        bussinessLogic1.start();
        printerMetrics.start();

    }
    public static class PrinterMetrics extends Thread {
        private Metrics metrics;

        public PrinterMetrics(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                double average = metrics.getAverage();
                System.out.println("Current average is " + average);
            }
        }
    }

    public static class BussinessLogic extends Thread {

        private Metrics metrics;
        private Random random = new Random();

        public BussinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {

            while (true) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }
        }
    }

    public static class Metrics {

        private long count = 0;
        private volatile double average = 0.0;

        public void addSample(long sample) {
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return this.average;
        }
    }
}

