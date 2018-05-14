/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author Student
 */
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// import java.util.Calendar;
// import java.util.Date;
import java.util.ArrayList;

public class DataCreator {
  private static final String DEFAULT_FILE = "data.ser";
//  private static Calendar dateCreator = Calendar.getInstance();

 public static void main(String [] args) {
  String fileName;
   if(args.length == 1) {
     fileName = args[0];
   }
   else {
     fileName = DEFAULT_FILE;
   }
  serialize(fileName);
 }

 public static void serialize(String fileName) {
  try {
   serializeToFile(createData(), fileName);
  }
  catch (IOException exc) {
   exc.printStackTrace();
  }
 }

 private static Serializable createData() {
  ArrayList items  = new ArrayList();
  items.add(new AddressImpl("Home address","1418 Appian Way","PleasantVille","NH","27415"));
  items.add(new AddressImpl("Resort","711 Casino Ave.","Atlantic City","NJ","91720"));
  items.add(new AddressImpl("vacation Spot","90 Kaahanau Cir.","Haleiva","HI","41720"));
   return items;
 }

 private static void serializeToFile(Serializable data, String fileName)
 throws IOException {
  ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
   serOut.writeObject(data);
   serOut.close();
 }

}


