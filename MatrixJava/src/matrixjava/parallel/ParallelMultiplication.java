/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixjava.parallel;

import java.util.concurrent.ForkJoinPool;
import matrixjava.MatrixMultiplier;

/**
 *
 * @author Kircho
 */
public class ParallelMultiplication implements MatrixMultiplier{

    @Override
    public double[][] multiply(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];

        ForkJoinPool pool = new ForkJoinPool();
        try {
            pool.invoke(new MultiplicationTask(a, b, c));
        } finally {
            pool.shutdown();
        }
        return c;
    }
}
