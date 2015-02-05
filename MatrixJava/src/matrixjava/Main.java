/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixjava;

import matrixjava.IO.ReadMatrix;
import matrixjava.IO.WriteMatrix;
import matrixjava.parallel.ParallelMultiplication;
import matrixjava.serial.SerialMultiplication;

/**
 *
 * @author KKabakchiev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] leftMatrix = null, rightMatrix = null, expected = null;

        ReadMatrix reader = new ReadMatrix();
        try {
            leftMatrix = reader.readMatrFromFile("C:\\Users\\Kircho\\Desktop\\threads\\MatrixJava\\Ex1\\left");
            rightMatrix = reader.readMatrFromFile("C:\\Users\\Kircho\\Desktop\\threads\\MatrixJava\\Ex1\\right");
            expected = reader.readMatrFromFile("C:\\Users\\Kircho\\Desktop\\threads\\MatrixJava\\Ex1\\result");

        } catch (Exception ex) {
            System.out.println("error reading file");
        }

        MatrixMultiplier serialMultiplication = new SerialMultiplication();
        long t0 = System.currentTimeMillis();
        double[][] matrixSerial = serialMultiplication.multiply(leftMatrix, rightMatrix);
        long t1 = System.currentTimeMillis();
        long serialTime = t1 - t0;
        System.out.println("Serial matrix multiplier: " + serialTime + " ms");

        MatrixMultiplier parallelMult = new ParallelMultiplication();
        t0 = System.currentTimeMillis();
        double[][] matrixParallel = parallelMult.multiply(leftMatrix, rightMatrix);
        t1 = System.currentTimeMillis();
        long parallelTime = t1 - t0;
        System.out.println("Parallel matrix multiplier: " + parallelTime + " ms");

        for (int i = 0; i < matrixParallel.length; i++) {
            for (int j = 0; j < matrixParallel[0].length; j++) {
                if (matrixParallel[i][j] != matrixSerial[i][j]
                        || matrixParallel[i][j] != expected[i][j]) {
                    throw new RuntimeException("result matrices are different!");
                }
            }
        }

        //Zapisvane na matricata v file
        new WriteMatrix().writeMatrToFile(matrixParallel, "myResult");
    }
}
