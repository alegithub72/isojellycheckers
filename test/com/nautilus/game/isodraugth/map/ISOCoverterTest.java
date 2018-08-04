/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nautilus.game.isodraugth.map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AlessioADM
 */
public class ISOCoverterTest {
    
    public ISOCoverterTest() {
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
     * Test of covertToISOX method, of class ISOCoverter.
     */
    @Test
    public void testCovertToISOX() {
        System.out.println("covertToISOX");
        double x = 100;
        double y =100;
        ISOCoverter instance = new ISOCoverter();
        double expResult = 0.0;
        double result = instance.covertToISOX(x, y);
        System.out.println("covertToISOX "+
                 result);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of covertToISOY method, of class ISOCoverter.
     */
    @Test
    public void testCovertToISOY() {
        System.out.println("covertToISOY");
        double x = 100;
        double y = 100;
        ISOCoverter instance = new ISOCoverter();
        double expResult = 100;
        double result = instance.covertToISOY(x, y);
          System.out.println("covertToISOY "+result);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isoConvertoScreenX method, of class ISOCoverter.
     */
    @Test
    public void testIsoConvertoScreenX() {
        System.out.println("isoConvertoScreenX");
        double x = 0.0;
        double y = 100;
        ISOCoverter instance = new ISOCoverter();
        double expResult = 100;
        double result = instance.isoConvertoScreenX(x, y);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of isoConverterScreenY method, of class ISOCoverter.
     */
    @Test
    public void testIsoConverterScreenY() {
        System.out.println("isoConverterScreenY");
        double x = 0;
        double y = 100;
        ISOCoverter instance = new ISOCoverter();
        double expResult = 100;
        double result = instance.isoConverterScreenY(x, y);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
