package codigo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolDeThreads {
    public static void main(String[] args) throws InterruptedException {
       // ExecutorService pool = Executors.newFixedThreadPool(4);
        
       ExecutorService pool = Executors.newCachedThreadPool();
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            int idCliente = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        long fim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }
}
