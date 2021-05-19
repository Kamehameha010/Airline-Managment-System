package com.cr.start;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.cr.model.Employee;
import com.cr.services.repository.jdbc.RepositoryJDBC;
import com.jcabi.aspects.Async;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {

        
        /*
         * var model = new Employee();
         * 
         * 
         * 
         * 
         * var jdbc = new RepositoryJDBC<Employee>();
         * 
         * //System.out.println(model.getClass().getSuperclass().getSuperclass().
         * getMethods());
         * 
         * for (var string : model.getClass().getDeclaredMethods()){
         * System.out.println(string.getName()); }
         */
    }

    @Async
    static CompletableFuture<String> abiri() throws InterruptedException {
        Thread.sleep(5000);
        return CompletableFuture.completedFuture("value");
    }

    private static Iterable<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields) {
            System.out.println(field.getType());
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }

}

class Response {

    public Status status;
    public List<Data> data;

    @Override
    public String toString() {
        return status.toString();
    }

}

class Status {

    public Date timestamp;
    public int error_code;
    public String error_message;
    public int elapsed;
    public int credit_count;
    public String notice;

    @Override
    public String toString() {
        return String.format("status:{ times:%s, err_code:%d, err_msg:%s, elap:%d, credit:%d, notice:%s}", timestamp,
                error_code, error_message, elapsed, credit_count, notice);
    }
}

class Data {

    public int id;
    public String name;
    public String symbol;
    public String slug;
    public int is_active;
    public int rank;
    public Object plataform;

    @Override
    public String toString() {
        return String.format("data:{id:%d, name:%s, symbol:%s, slug:%s, is_active:%d, rank:%d}", id, name, symbol, slug,
                is_active, rank);
    }

}
