package com.cr.start;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jcabi.aspects.Async;

public class App {
    @Async
    static CompletableFuture<String> abiri() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("value");
    }

    static CompletionStage<String> TestNet(){
        return CompletableFuture.completedStage("value");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Comenzando supplyAsync...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println("Terminado supplyAsync!");
            return "Terminado";
        }, executor);

        futureSupplyAsync.whenCompleteAsync((s, e) -> System.out.println("Resultado supplyAsync: " + s), executor);
        
        System.out.println("Terminado main thread");
        System.out.println("test");
    }

}
