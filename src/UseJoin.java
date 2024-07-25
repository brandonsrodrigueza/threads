import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseJoin {

    public static void main(String[] args) throws InterruptedException {

        List<Long> inputNumbers = Arrays.asList(0L, 30L, 700000L);
        List<FactorialThread> factorialThreads = new ArrayList<>();

        for (Long number : inputNumbers) {
            factorialThreads.add(new FactorialThread(number));
        }

        /**
         * We can use setDaemon as true to say don't block the main thread,
         * however using join with 1000 milis we're saying to   wait 1s to get the result, if 1 seg passes and
         * the result isn't obtained, the main thread should continue executing without blocking.
         */

        for (Thread thread : factorialThreads) {
            thread.setDaemon(true);
            thread.start();
            thread.join(1000);
        }


        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread thread = factorialThreads.get(i);
            System.out.println("Factorial to " + inputNumbers.get(i) + " is " + thread.getResult());
        }

        /**
         * With this solution using isFinished we aren't blocking the main thread since
         * if isFinished es false he just print "Esperando a que termine" and the flow continue
         */
//        for(int i=0;i<inputNumbers.size();i++){
//            FactorialThread thread = factorialThreads.get(i);
//            if(thread.isFinished){
//                System.out.println("Thread has finished, the result " + thread.getResult());
//            }else{
//                System.out.println("Esperando a que termine");
//            }
//        }
    }


    public static class FactorialThread extends Thread {

        Boolean isFinished = false;
        BigInteger result = BigInteger.ONE;
        long input;

        public FactorialThread(long input) {
            this.input = input;
        }

        @Override
        public void run() {
            this.result = tempResult(input);
            this.isFinished = true;
        }

        public BigInteger tempResult(long n) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(BigInteger.valueOf(i));
            }
            return tempResult;
        }

        public Boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
