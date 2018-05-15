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
import java.io.File;
import java.util.ArrayList;
public class CalendarEditor {
    private State currentState;
    private File appointmentFile;
    private ArrayList appointments = new ArrayList();
    private static final String DEFAULT_APPOINTMENT_FILE = "appointments.ser";
    
    public CalendarEditor(){
    this(DEFAULT_APPOINTMENT_FILE);
    }
    
    public CalendarEditor(String appointmentFileName){
 appointmentFile = new File (appointmentFileName);
 try{
 appointments = (ArrayList)FileLoader.loadData(appointmentFile);
 }
 catch (ClassCastException exc){
 System.err.println("Unable to load information. The file does not contain a list of appointments.");
 }
 currentState = new CleanState();
    }
    
    public void save(){
        currentState.save();
    }

    public void edit(){
        currentState.edit();
    }
    
    private class DirtyState implements State{
 private State nextState;

 public DirtyState(State nextState){
 this.nextState = nextState;
 }

 public void save (){
 FileLoader.storeData(appointmentFile, appointments);
 currentState = nextState;
}
 public void edit(){ }
    }
 
    private  class CleanState implements State{
 private State nextState = new DirtyState(this);

 public void saved() { }
 public void edit(){ currentState = nextState; }
 }

 public ArrayList getAppointments(){
 return appointments;
 } 

 public void addAppointment(Appointment appointment){
 if (!appointments.contains(appointment)){
         appointments.add(appointment) ;
 }
}
 public void removeAppointment(Appointment appointment){
 appointments.remove(appointment);
 }
     
    
}
