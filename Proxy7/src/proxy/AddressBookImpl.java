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
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

public class AddressBookImpl implements AddressBook {
 private File file;
 private ArrayList addresses = new ArrayList();

 public AddressBookImpl(File newFile){
 file = newFile;
 open();
 }

 public Address getAddress(String description) {
  Iterator addressIterator = addresses.iterator();
   while( addressIterator.hasNext() ) {
   AddressImpl address =  (AddressImpl)addressIterator.next();
    if( address.getDescription().equalsIgnoreCase(description) ) {
      return address;
    }
   }
  return null;
  }

 public ArrayList getAllAddresses() { return addresses; }

 public void add(Address address) {
  if( ! addresses.contains(address)) {
   addresses.add(address);
  }
 }

 public void open() {
  addresses = (ArrayList)FileLoader.loadData(file);
 }

 public void save() {
  FileLoader.storeData(file, addresses);
 }

}
