/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import entity.NumberField;
import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author COMPUTER
 */
public class autonumberTest {
    
    public autonumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAutoNumberInt method, of class autonumber.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testGetAutoNumberInt() throws RemoteException {
        System.out.println("getAutoNumberInt");
        NumberField field = null;
        autonumber instance = new autonumber();
        String expResult = "";
        String result = instance.getAutoNumberInt(field);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
