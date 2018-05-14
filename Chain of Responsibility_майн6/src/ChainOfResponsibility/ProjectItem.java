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
import java.io.Serializable;
 import java.util.ArrayList;

public interface ProjectItem extends Serializable {
   public static final String EOL_STRING =
     System.getProperty("line.separator");
   public ProjectItem getParent();
   public Contact getOwner();
   public String getDetails();
   public ArrayList getProjectItems();
}

