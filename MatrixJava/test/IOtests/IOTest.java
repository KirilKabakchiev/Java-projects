package IOtests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import matrixjava.IO.ReadMatrix;
import matrixjava.IO.WriteMatrix;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KKabakchiev
 */
public class IOTest {

    public IOTest() {
    }

    @Test
    public void testAddToFile() {
        try {
            System.out.println("IOtest");
            new WriteMatrix().writeMatrToFile(initMatrix(), "testResult");
            double[][] readMatrFromFile = new ReadMatrix().readMatrFromFile("testResult");
            assertArrayEquals(initMatrix(), readMatrFromFile);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = IOException.class)
    public void IOexTest() throws Exception {
        System.out.println("IOExceptionTest");
        new ReadMatrix().readMatrFromFile("asdasd");
    }

    @Test
    public void IOexTest2()  {
        System.out.println("IOExceptionTest");
        new WriteMatrix().writeMatrToFile(initMatrix(),"Ex1");
    }

    @Test
    public void writeNoSuchElementExTest() throws Exception {
        System.out.println("IOExceptionTest2");
        new WriteMatrix().writeMatrToFile(initMatrix(), "testResult2");
    }

    private double[][] initMatrix() {
        double[][] array = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        return array;
    }

}
