package com.cr;

import static org.junit.Assert.assertTrue;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.cr.db.jdbc.mysql.MysqlConnection;
import com.cr.model.Plane;
import com.cr.services.repository.jdbc.PlaneRepository;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args)
            throws InterruptedException, IOException, SQLException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IntrospectionException {
    
        var mysql = new MysqlConnection(null);
        var plane = new Plane();
        plane.setName("kakarotto");
        plane.setCode("kkk");
        plane.setCapacity(1024);
        plane.setIdPlane(9);
    
        
    
        var repository = new PlaneRepository();
        var f = repository.getAll();
    
        for (var method : f) {
    
            System.out.println(method);
        }
    }
}
