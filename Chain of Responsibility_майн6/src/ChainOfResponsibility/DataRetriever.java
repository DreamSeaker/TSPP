/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainOfResponsibility;

/**
 *
 * @author Student
 */
import java.io.File;
 import java.io.ObjectInputStream;
 import java.io.FileInputStream;
 import java.io.IOException;

public class DataRetriever {
  public static Object deserializeData(String fileName) {
   Object returnValue = null;
    try {
     File inputFile = new File(fileName);
     if( inputFile.exists() && inputFile.isFile() ) {
        ObjectInputStream readln = new ObjectInputStream(
        new FileInputStream(fileName) );
        returnValue = readln.readObject();
        readln.close();
      }
      else {
       System.err.println("Unable locate file " + fileName);
      }
    }
    catch (ClassNotFoundException exc) {
     exc.printStackTrace();
    }
    catch (IOException exc) {
     exc.printStackTrace();
    }
   return returnValue;
  }

}

