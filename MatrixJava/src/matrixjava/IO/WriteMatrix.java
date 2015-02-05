/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixjava.IO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author KKabakchiev
 */
public class WriteMatrix {

    //private DataOutputStream output;

    public void writeMatrToFile(double[][] matrix, String name) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(name))) {
            output.writeInt(matrix.length);
            output.writeInt(matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    output.writeDouble(matrix[i][j]);                
                }
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("Invalid input. Please try again.");
            Scanner input = new Scanner(System.in);
            input.nextLine();

        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        }
    }

//    public void openFile(String name) {
//        try // open file
//        {
//            output = new DataOutputStream(
//                    new FileOutputStream(name));
//        } // end try
//        catch (IOException ioException) {
//            System.err.println("Error opening file.");
//        } // end catch
//    } // end method openFile
//
//    public void addToFile(Double[][] matrix,String name) {
//        try {
//            openFile(name);
//
//            output.writeInt(matrix.length);
//            output.writeInt(matrix[0].length);
//
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    output.writeDouble(matrix[i][j]);
//                    //output.writeChar(' ');                
//                }
//            }
//        } catch (IOException ex) {
//            System.err.println("Error opening file.");
//        } catch (NoSuchElementException elementException) {
//            System.err.println("Invalid input. Please try again.");
//            Scanner input = new Scanner(System.in);
//            input.nextLine();
//
//        } finally {
//            closeFile();
//        }
//    }
//
//    public void closeFile() {
//        try // close file
//        {
//            if (output != null) {
//                output.close();
//            }
//        } // end try
//        catch (IOException ioException) {
//            System.err.println("Error closing file.");
//            System.exit(1);
//        } // end catch
//    } // end method closeFile
}
