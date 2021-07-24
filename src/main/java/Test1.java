import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author t0k02w6 on 15/07/21
 * @project ds-algo-udemy
 */
public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add(i);
        }

        int batchSize = 10;
        int noOfBatches = list.size() / batchSize;

        AtomicBoolean isFailure = new AtomicBoolean(false);

        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        int startIndx = 0;
        for(int i = 0; i < noOfBatches; i++) {
            int endIndx = startIndx + batchSize;
            if(endIndx > list.size())
                endIndx = list.size();
            List<Integer> idList = list.subList(startIndx, endIndx);
            final int b = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                int res = 0;
                for(Integer el: idList) {
                    res += el/b;
                }
                System.out.println("Res = " + res);
                return res;
            }).exceptionally(ex -> {
                System.out.println("Error ");
                isFailure.set(true);
                return null;
            });
            futures.add(future);
        }


        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println("Is failure : " + isFailure.get());

        if(isFailure.get()) {
            System.out.println("Failure");
        }
    }
}
