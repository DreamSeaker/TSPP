/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.ArrayList;
import java.io.IOException;

public interface AddressBook {
 public void add(Address address);
 public ArrayList getAllAddresses();
 public Address getAddress(String description);

 public void open();
 public void save();

}
