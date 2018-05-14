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
 import java.io.ObjectOutputStream;
 import java.io.FileOutputStream;
 import java.io.IOException;

public class DataCreator {
  private static final String DEFAULT_FILE = "data.ser";

  public static void main(String [] arguments) {
  String fileName;
  if(arguments.length == 1 ) {
   fileName = arguments[1];  // May be 0 ?
   }
  else {
   fileName = DEFAULT_FILE;
   }
   serialize(fileName);
  }

  public static void serialize(String fileName) {
   try {
    serializeToFile(createData(), fileName);
   }
   catch (IOException exc) {
   exc.printStackTrace();;
   }
  }


  private static Serializable createData() {
    Contact contact1 = new ContactImpl("Dennis","Moore","Managing Director","Highway Man, LTD");
    Contact contact2 = new ContactImpl("Josef","Mongolfier","High Flyer","Liters Production");
    Contact contact3 = new ContactImpl("Erik","Njoll","Nomad without portfolio","Nordik Trec, Inc");
    Contact contact4 = new ContactImpl("Lemming","","Principal Investigator","BDA");

    Project project = new Project("Island Paradise",
     "Aquire a personal island paradise", contact1);

    Task task1 = new Task(project,"Fortune","Acqire a small fortune",contact4, true);
    Task task2 = new Task(project,"Isle","Locate an island for sale",null, true);
    Task task3 = new Task(project,"Name","Decide a name for island",contact3, false);

    project.addProjectItem(task1);
    project.addProjectItem(task2);
    project.addProjectItem(task3);

    Task task4 = new Task(task1,"Fortune 1","predict hotline",null, false);
    Task task5 = new Task(task1,"Fortune 2","Invest",contact1, true);
    Task task6 = new Task(task2,"Isle 1","Research climat",contact1, true);
    Task task7 = new Task(task2,"Isle 2","Locate island",null, false);
    Task task8 = new Task(task2,"Isle 2a","Nrgotiate sale",null, false);
    Task task9 = new Task(task3,"Name 1","Search all possiblr names", null, true);
    Task task10 = new Task(task3,"Name 2","Eliminate coffe-related",contact4, false);

    task1.addProjectItem(task4);
    task1.addProjectItem(task5);
    task2.addProjectItem(task6);
    task2.addProjectItem(task7);
    task2.addProjectItem(task8);
    task3.addProjectItem(task9);
    task3.addProjectItem(task10);

      return project;
  }

  private static void serializeToFile(Serializable content, String fileName) throws IOException {
    ObjectOutputStream serOut = new ObjectOutputStream( new FileOutputStream(fileName) );
    serOut.writeObject(content);
    serOut.close();
  }
}

