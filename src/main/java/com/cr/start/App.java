package com.cr.start;



import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cr.view.external.Reservation.ReservationView;
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

                e.printStackTrace();
            }
            return "value";
        });
    }

    public static void main(String[] args) {
       
        try {
            var r = new ReservationView();
            r.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
