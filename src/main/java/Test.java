import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author t0k02w6 on 14/07/21
 * @project ds-algo-udemy
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list);
        int batchSize = 10;
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        int noOfBatches = list.size() / batchSize;

        for(int i = 0; i < noOfBatches; i++) {
            final int a = i;
            CompletableFuture<Integer> future = CompletableFuture
                    .supplyAsync(() -> {
                        int b = 0;
                        int result = (a % 2 == 0 ? b: (a * 2));
                        if(result != 0) {
                            System.out.println("a = " + a);
                        }
                        return (a / result);
                    }).handleAsync((data, ex) -> {
                        if(ex != null) {
                            System.out.println("Error occurred");
                            throw new RuntimeException("Error");
                        }
                        return data;
                    });
            futures.add(future);
        }

        CompletableFuture<Void> results = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[futures.size()]));

        CompletableFuture failure = allOfTerminateOnFailure(results);

        CompletableFuture<List<Integer>> allCompletableFuture = results.
                thenApply(future -> futures.stream()
                                .map(completableFuture -> completableFuture.join())
                                .collect(Collectors.toList()));

        CompletableFuture<List<Integer>> completableFuture = allCompletableFuture.toCompletableFuture();

        List<Integer> finalResults = completableFuture.get();
        System.out.println(finalResults);
        //results.get();
    }

    private static CompletableFuture allOfTerminateOnFailure(CompletableFuture<?>... futures) {
        CompletableFuture<?> failure = new CompletableFuture();
        for (CompletableFuture<?> f: futures) {
            f.exceptionally(ex -> {
                failure.completeExceptionally(ex);
                return null;
            });
        }

        failure.exceptionally(ex -> {
            Arrays.stream(futures).forEach(f -> f.cancel(true));
            return null;
        });
        return CompletableFuture.anyOf(failure, CompletableFuture.allOf(futures));
    }
}
