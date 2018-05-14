/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmodel;

/**
 *
 * @author Student
 */
import java.awt.event.*;

public class ContactEditController implements ActionListener {
  private ContactModel model;
  private ContactEditView view;

  public ContactEditController(ContactModel m, ContactEditView v) {
   model = m;
   view = v;
  }

  public void actionPerformed(ActionEvent evt) {
   Object source = evt.getSource();
   if( source == view.getUpdateRef() ) {
     updateModel();
    }
  }

  private void updateModel() {
    String firstName = null;
    String lastName = null;
    if( isAlphabetic(view.getFirstName())) {firstName = view.getFirstName();}
    if( isAlphabetic(view.getLastName())) {lastName = view.getLastName();}
    model.updateModel(view.getFirstName(),view.getLastName(),      view.getTitle(),view.getOrganization());
  }

  private boolean isAlphabetic(String input) {
    char [] testChars = {'0','1','2','3','4','5','6','7','8','9'};
    for(int i=0; i < testChars.length;i++) {
     if(input.indexOf(testChars[i]) != -1 ) { return false; }
    }
     return true;
  }
}
