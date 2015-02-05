/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixjava.IO;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author KKabakchiev
 */
public class ReadMatrix {

   // private DataInputStream input;
   // private String name;

    public double[][] readMatrFromFile(String name) throws Exception {
        try (DataInputStream input = new DataInputStream(new FileInputStream(name))) {
            int rows = 0, cols = 0;
            rows = (int) input.readInt();
            cols = (int) input.readInt();
            double [][] result = new double[rows][cols];
            while (true) {
                try {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            result[i][j] = input.readDouble();
                        }
                    }
                } catch (EOFException ex) {
                    break;
                } catch (IOException ex) {
                    System.err.println("Error. Data was already read and file is closed");
                    System.exit(1);
                }
            }
          return result;
        } catch (IOException ioException) {
            throw ioException;      
        } 
      //  return null;
    }

//    public void openFile(String name) {
//        try // open file
//        {
//            //if (input == null) {
//            input = new DataInputStream(new FileInputStream(name));
//            //}
//        } // end try
//        catch (IOException ioException) {
//            System.err.println("Error opening file.");
//        } // end catch
//    } // end method openFile
//
//    public Double[][] readFile() {
//        
//        if (input == null) {
//            System.out.println("No file is currently opened.");
//            return null;
//        }
//        
//        int rows = 0, cols = 0;
//         try {
//            rows = (int) input.readInt();
//            cols = (int) input.readInt();
//        } catch (IOException ex) {
//            System.err.println("Error during read from file.Data was already read and file is closed");
//            System.exit(1);
//        }
//         
//        Double [] [] result = new Double [rows][cols];
//        
//        //ArrayList<Double> oneRow = new ArrayList<>();
//        while (true) {
//
//            try {
//               // if (oneRow.size() == cols) {
//                 //   result.add(new ArrayList<Double>(oneRow));            
//                   // oneRow.clear();
//               // }
//                //oneRow.add(input.readDouble());
//                for(int i = 0; i < rows; i++){
//                    for(int j = 0; j < cols; j++){
//                        result[i][j] = input.readDouble();
//                    }
//                }
//            } catch (EOFException ex) {
//                break;
//            } catch (IOException ex) {
//                System.err.println("Error during read from file.Data was already read and file is closed");
//                System.exit(1);
//            }
//        }
//       // System.out.println(hh);
//        return result;
//    }
//
//    public void closeFile() {
//        try // close file and exit
//        {
//            if (input != null) {
//                input.close();
//            }
//        } // end try
//        catch (IOException ioException) {
//            System.err.println("Error closing file.");
//            System.exit(1);
//        }
//    }
    }
