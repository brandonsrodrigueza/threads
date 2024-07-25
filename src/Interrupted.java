import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLOutput;

public class Interrupted {

    /**
     * We can interrupt a thread in two scenarios
     * 1. Is the thread is executing a method that throws an Interrupted Exception
     * 2. Thread code is handling the interrupt signal explicitly
     */

    /**
     * ------Scenario 1----------------
     */

//    public static void main(String[] args) {
//        Thread thread = new Thread(new BlockTasking());
//        thread.start();
//        thread.interrupt();
//
//    }
//
//    public static  class BlockTasking implements Runnable {
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                System.out.println("Thread interrupted");
//            }
//        }
//    }

    /**
     * ---------------Scenario 2 -----------------------------------
     */

//    public static void main(String[] args) {
//        Thread thread = new Thread(new BlockTasking(BigInteger.valueOf(1L), BigInteger.valueOf(1L)));
//        thread.start();
//        thread.interrupt();
//    }
//
//    public static class BlockTasking implements Runnable {
//
//        BigInteger power;
//        BigInteger base;
//
//        public BlockTasking(BigInteger power, BigInteger base) {
//            this.power = power;
//            this.base = base;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("The result of " + base + "^^" + power + " is " + calculatePower(power, base));
//        }
//
//        public BigInteger calculatePower(BigInteger power, BigInteger base) {
//            BigInteger result = BigInteger.ONE;
//            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Thread was interrupted");
//                    return BigInteger.ZERO;
//                }
//                result = result.multiply(base);
//            }
//            return result;
//        }
//    }
}
