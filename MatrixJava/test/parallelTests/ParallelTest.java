package parallelTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import matrixjava.parallel.MultiplicationTask;
import matrixjava.parallel.ParallelMultiplication;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KKabakchiev
 */
public class ParallelTest {

    public ParallelTest() {
    }


    /**
     * Test of multiplyRowByColumn method, of class MultiplicationTask.
     */
    @Test
    public void testMultiplyRowByColumn() {
        System.out.println("multiplyRowByColumn");
        double[][] c1 = initMatrix(), c2 = initMatrix(), c3 = initMatrix(), c4 = initMatrix();
        new MultiplicationTask(c1, c2, c3, 0).multiplyRowByColumn();
        new MultiplicationTask(initMatrix2(), initMatrix(), c2, 0).multiplyRowByColumn();
        new MultiplicationTask(initMatrix2(), initMatrix2(), c3, 0).multiplyRowByColumn();
        new MultiplicationTask(initMatrix2(), initMatrix2(), c3, 1).multiplyRowByColumn();
        new MultiplicationTask(initMatrix2(), initMatrix2(), c3, 2).multiplyRowByColumn();
        
        assertTrue(Arrays.equals(new double[]{0.0, 0.0, 0.0}, c1[0]));
        assertTrue(Arrays.equals(new double[]{0.0, 0.0, 0.0}, c2[0]));
        assertTrue(Arrays.equals(new double[]{30.0, 36.0, 42.0}, c3[0]));
        assertTrue(Arrays.equals(new double[]{66.0, 81.0, 96.0}, c3[1]));
        assertTrue(Arrays.equals(new double[]{102.0, 126.0, 150.0}, c3[2]));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructingException() {
        System.out.println("Testmultiply:Exception");
        double[][] array1 = {{1.0, 2.0}, {4.0, 5.0}, {7.0, 8.0}};
        double[][] array2 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        new ParallelMultiplication().multiply(array1, array2);
    }


    @Test
    public void constructing() {
        assertEquals(-1, new MultiplicationTask(initMatrix2(), initMatrix2(), initMatrix()).getRow());

    }

    @Test
    public void multiplying() {
        assertArrayEquals(new double[][]{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}},
                new ParallelMultiplication().multiply(initMatrix2(), initMatrix2()));
    }

    private double[][] initMatrix() {
        double[][] array = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
        return array;
    }

    private double[][] initMatrix2() {
        double[][] array = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        return array;
    }

    /**
     * Test of compute method, of class MultiplicationTask.
     */
//    @Test
//    public void testCompute() {
//        System.out.println("compute");
//        MultiplicationTask instance = null;
//        instance.compute();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
