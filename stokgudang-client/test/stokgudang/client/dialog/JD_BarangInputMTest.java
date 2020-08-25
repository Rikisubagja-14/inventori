/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.dialog;

import entity.BarangMasukDetail;
import entity.LokasiPenyimpanan;
import entity.MasterBarang;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Riki subagja
 */
public class JD_BarangInputMTest {
    
    public JD_BarangInputMTest() {
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
     * Test of getLokpem method, of class JD_BarangInputM.
     */
    @Test
    public void testGetLokpem() {
        System.out.println("getLokpem");
        JD_BarangInputM instance = null;
        LokasiPenyimpanan expResult = null;
        LokasiPenyimpanan result = instance.getLokpem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMasterBarang method, of class JD_BarangInputM.
     */
    @Test
    public void testGetMasterBarang() {
        System.out.println("getMasterBarang");
        JD_BarangInputM instance = null;
        MasterBarang expResult = null;
        MasterBarang result = instance.getMasterBarang();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsiBarang method, of class JD_BarangInputM.
     */
    @Test
    public void testGetIsiBarang() {
        System.out.println("getIsiBarang");
        JD_BarangInputM instance = null;
        double expResult = 0.0;
        double result = instance.getIsiBarang();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalQty method, of class JD_BarangInputM.
     */
    @Test
    public void testGetTotalQty() {
        System.out.println("getTotalQty");
        JD_BarangInputM instance = null;
        double expResult = 0.0;
        double result = instance.getTotalQty();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJumlah method, of class JD_BarangInputM.
     */
    @Test
    public void testGetJumlah() {
        System.out.println("getJumlah");
        JD_BarangInputM instance = null;
        double expResult = 0.0;
        double result = instance.getJumlah();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBatch method, of class JD_BarangInputM.
     */
    @Test
    public void testGetBatch() {
        System.out.println("getBatch");
        JD_BarangInputM instance = null;
        String expResult = "";
        String result = instance.getBatch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNf method, of class JD_BarangInputM.
     */
    @Test
    public void testGetNf() {
        System.out.println("getNf");
        JD_BarangInputM instance = null;
        String expResult = "";
        String result = instance.getNf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLokasi method, of class JD_BarangInputM.
     */
    @Test
    public void testGetLokasi() {
        System.out.println("getLokasi");
        JD_BarangInputM instance = null;
        String expResult = "";
        String result = instance.getLokasi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKemasan method, of class JD_BarangInputM.
     */
    @Test
    public void testGetKemasan() {
        System.out.println("getKemasan");
        JD_BarangInputM instance = null;
        String expResult = "";
        String result = instance.getKemasan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKodeBarang method, of class JD_BarangInputM.
     */
    @Test
    public void testGetKodeBarang() {
        System.out.println("getKodeBarang");
        JD_BarangInputM instance = null;
        String expResult = "";
        String result = instance.getKodeBarang();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSatuanBarang method, of class JD_BarangInputM.
     */
    @Test
    public void testGetSatuanBarang() {
        System.out.println("getSatuanBarang");
        JD_BarangInputM instance = null;
        String expResult = "";
        String result = instance.getSatuanBarang();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class JD_BarangInputM.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        JD_BarangInputM instance = null;
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class JD_BarangInputM.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BarangMasukDetail pd = null;
        JD_BarangInputM instance = null;
        instance.update(pd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
