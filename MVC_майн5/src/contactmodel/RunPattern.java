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
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunPattern {

  public static void main(String [] arguments) {
  System.out.println("MVC pattern");
  System.out.println();

  ContactModel model = new ContactModel();
  ContactEditView editorView = new ContactEditView(model);
  model.addContactView(editorView);
  createGui(editorView,"Contact Edit Window");

  ContactDisplayView displayView = new ContactDisplayView();
  model.addContactView(displayView);
  createGui(displayView,"Contact Display Window");
  }

  private static void createGui(JPanel contents, String title) {
    JFrame applicationFrame = new JFrame(title);
    applicationFrame.getContentPane().add(contents);
    applicationFrame.addWindowListener(new WindowCloseManager());
    applicationFrame.pack();
    applicationFrame.setVisible(true);
  }

  private static class WindowCloseManager extends WindowAdapter {
   public void WindowClosing(WindowEvent evt) {
    System.exit(0);
   }
  }

}

