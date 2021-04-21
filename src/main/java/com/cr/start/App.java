package com.cr.start;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import com.cr.model.Employee;
import com.cr.services.repository.EmployeeRepository;
import com.cr.tools.FileProperties;
import com.jcabi.aspects.Async;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {

        var emp = new Employee();
        emp.setCode("code").setUsername("username").setPassword("password").setName("name").setLastName("lastname")
                .setIdentification(25568987).setPhoneNumber("phoneNumber");

        System.out.println(emp);

        var rep = new EmployeeRepository();
        rep.create(emp);
        var map = new HashMap<String, String>();


    }

    @Async
    static CompletableFuture<String> abiri() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("value");
    }

}
