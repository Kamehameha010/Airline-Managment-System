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

    static CompletionStage<String> TestNet() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "value";
        });
    }

    public static void main(String[] args) {
       
 
       

    }

 
}
