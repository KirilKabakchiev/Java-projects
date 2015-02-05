/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Fork/Join consists of a special executor service and thread pool.
// The Fork/Join breaks a task down into smaller tasks that are forked (executed by different threads) from the pool.
// A task waits until joined (its subtasks finish). 
package matrixjava;

/**
 *
 * @author KKabakchiev
 */
public interface MatrixMultiplier {

    double[][] multiply(double[][] a, double[][] b);
}
