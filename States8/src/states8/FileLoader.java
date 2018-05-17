/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states8;

/**
 *
 * @author Alpha
 */
import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import java.io.Serializable;

public class FileLoader {
    public static Object loadData(File inputFile){
        Object returnValue = null;
        try{
            if (inputFile.exists() ){
                if (inputFile.isFile() ){
            ObjectInputStream readln = new ObjectInputStream(new FileInputStream(inputFile)) ;
            returnValue = readln.readObject();
            readln.close(); 
                }
                else {
                    System.err.println(inputFile + " is a directory.");
                }
            }
        } ///
            catch (ClassNotFoundException exc){
                    exc.printStackTrace();
                    }
            catch (IOException exc){
                    exc.printStackTrace();
                    }
            return returnValue;
    }
    
public static void storeData(File outputFile, Serializable data){
 try{
 ObjectOutputStream writeOut = new ObjectOutputStream(new
FileOutputStream(outputFile));
 writeOut.writeObject(data);
 writeOut.close();
 }
 catch (IOException exc){
 exc.printStackTrace ();
 }
 }
 }




