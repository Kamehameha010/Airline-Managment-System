package com.cr.start;

import java.util.concurrent.CompletableFuture;

import com.jcabi.aspects.Async;

public class App {
    @Async
    static CompletableFuture<String> abiri() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("value");
    }

}
