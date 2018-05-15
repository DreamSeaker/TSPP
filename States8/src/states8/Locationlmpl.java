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
public class Locationlmpl implements Location{
    private String location;
    
    public Locationlmpl() {}
 public Locationlmpl(String newLocation){
 location = newLocation;
 }
 
 public String getLocation(){ return location; }
 public void setLocation(String newLocation){ location = newLocation; }
 public String toString(){ return location; }

}
