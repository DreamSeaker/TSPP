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
public interface Contact extends Serializable{
    public static final String SPACE = " ";
 public String getFirstName();
 public String getLastName();
 public String getTitle();
 public String getOrganization();

 public void setFirstName(String newFirstName);
 public void setLastName(String newLastName);
 public void setTitle(String newTitle);
 public void setOrganization(String newOrganization) ;
}
