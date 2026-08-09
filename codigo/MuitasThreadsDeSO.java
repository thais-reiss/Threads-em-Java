package codigo;

public class MuitasThreadsDeSO {
    public static void main(String[] args) throws InterruptedException {
        int total = 10_000;
        Thread[] threads = new Thread[total];

        for (int i = 0; i < total; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (var t : threads)
            t.join();

        // acima de ~50_000:
        // OutOfMemoryError:
        // unable to create new
        // native thread
    }
}
