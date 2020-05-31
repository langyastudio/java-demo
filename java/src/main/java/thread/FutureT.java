package thread;

import java.util.concurrent.CompletableFuture;

/**
 * 异步回调结果
 */
public class FutureT {
    public static void main(String[] args) throws InterruptedException {
        //定义两个`CompletableFuture`
        // `thenAccept()`处理正常结果；
        // `exceptional()`处理异常结果；
        //
        // `thenApplyAsync()`用于串行化另一个`CompletableFuture`；
        // `anyOf()`和`allOf()`用于并行化多个`CompletableFuture`。
        CompletableFuture<String> cfQuery =  CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        CompletableFuture<Double> cfPrice = cfQuery.thenApplyAsync(FutureT::fetchPrice);

        cfPrice.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        Thread.sleep(2000);
    }

    static String queryCode(String name){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
        }

        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        return 5 + Math.random() * 20;
    }
}
