package com.cr.start;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.cr.model.Employee;
import com.cr.model.Person;
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

        Field[] fields = emp.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);
        var rep = new EmployeeRepository();
        //rep.create(emp);
        var r = rep.find(1);
        System.out.println(r);
/* 
        for (Employee employee : r) {
            System.out.println(employee);
        } */
        

    }

    @Async
    static CompletableFuture<String> abiri() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("value");
    }

    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields) {
            System.out.println(field.getType());
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
}
