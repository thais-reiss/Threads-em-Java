package codigo;

import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        int total = 100_000;

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < total; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } // aguarda terminar

        // 100.000 atendimentos,
        // sem OutOfMemoryError
    }
}
