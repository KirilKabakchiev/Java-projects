package serialTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import matrixjava.serial.SerialMultiplication;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KKabakchiev
 */
public class SerialMultiplicationTest {

    public SerialMultiplicationTest() {
    }

    /**
     * Test of multiply method, of class SerialMultiplication.
     */
    @Test
    public void testMultiply() {
        System.out.println("Testmultiply");
        double[][] matrixA = initMatrix();
        double[][] matrixB = initMatrix();
        double[][] expResult = {{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}};
        SerialMultiplication instance = new SerialMultiplication();
        assertArrayEquals(expResult, instance.multiply(matrixA, matrixB));

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyException()
    {
         System.out.println("Testmultiply:Exception");
         double[][] array1 = {{1.0, 2.0}, {4.0, 5.0}, {7.0, 8.0}};
         double[][] array2 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
         new SerialMultiplication().multiply(array1, array2);
    }

    private double[][] initMatrix() {
        double[][] array = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        return array;
    }

}
