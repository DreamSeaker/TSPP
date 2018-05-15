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
public class Contactlmpl implements Contact{
    private String firstName;
    private String lastName;
    private String title;
    private String organization;
    
public Contactlmpl(){}
 public Contactlmpl(String newFirstName, String newLastName, String newTitle, String newOrganization){
 firstName = newFirstName;
 lastName = newLastName;
 title = newTitle;
 organization = newOrganization;
 }

 public String getFirstName(){ return firstName; } 
 public String getLastName(){ return lastName; }
 public String getTitle(){ return title; }
 public String getOrganization(){ return organization; }

 public void setFirstName(String newFirstName){ firstName = newFirstName; }
 public void setLastName(String newLastName){ lastName = newLastName; }
 public void setTitle(String newTitle){ title = newTitle; }
 public void setOrganization(String newOrganization){ organization = newOrganization;}

 public String toString(){
 return firstName + SPACE + lastName;
 }
}

    

