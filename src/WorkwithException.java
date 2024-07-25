public class WorkwithException {

    /**
     * NOTE : This way we can handle exceptions that occur in threads
     */

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Internal message ");
            }
        });

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread" + t.getName() + " cause " + e.getMessage());
            }
        });
        thread.start();
    }

}