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
import java.io.Serializable;
public interface Location extends Serializable{
    public String getLocation ();
 public void setLocation(String newLocation);
}
