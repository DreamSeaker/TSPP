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
import java.util.ArrayList;
import java.util.Iterator;

public class RunPattern {
   public static void main(String [] arguments) {
     System.out.println("Deser Project for Visitoy pattern");
     System.out.println();

     if( !(new File("data.ser").exists() ) ) {
      DataCreator.serialize("data.ser");
     }
     Project project = (Project) ( DataRetriever.deserializeData("data.ser") );

     System.out.println("Retrieve Owner and details for each item in Project");
     System.out.println();
     getItemInfo(project);
     System.out.println();
   }
   private static void getItemInfo(ProjectItem item) {
     System.out.println("ProjectItem: " + item);
     System.out.println("Owner: " + item.getOwner());
     System.out.println("Details: " + item.getDetails());
     System.out.println();

     if( item.getProjectItems() != null ) {
       Iterator subElements = item.getProjectItems().iterator();
       while ( subElements.hasNext() ) {
        getItemInfo((ProjectItem) subElements.next() );
        }
      }
   }
}
