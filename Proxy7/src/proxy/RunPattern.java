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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RunPattern {

  public static void main(String [] arguments) {
  System.out.println("Proxy pattern");
  System.out.println();
   if( !( new File("data.ser").exists())) {
    DataCreator.serialize("data.ser");
   }
  System.out.println("Creating AddressBookProxy");
  System.out.println();
  AddressBookProxy proxy = new AddressBookProxy("data.ser");

  System.out.println("Adding entries to AddressBookProxy");
  proxy.add(new AddressImpl("Sun Education [CO]","502 El Dorado Blvd.","Broomfield","CO","80020"));
  proxy.add(new AddressImpl("Apple Inc.","1 Infinite Loop","Redwood City","CA","93741"));

  AddressImpl foundAddr = (AddressImpl)proxy.getAddress("Sun Education [CO]");
  if( foundAddr != null ) {
  System.out.println(foundAddr.getAddress() );
   } else
  {
  System.out.println("Such Address not found.");
  }

/*
  try {
  System.out.println(foundAddr.getAddress() );
  }
   catch(NullPointerException exc) {
//    exc.printStackTrace();
  System.out.println("Such Address not found.");
   }
*/
  ArrayList addresses = proxy.getAllAddresses();
  System.out.println(addresses);

  proxy.save();

  System.out.println();
  }

}

