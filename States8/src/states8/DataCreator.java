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
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
public class DataCreator {
    private static final String DEFAULT_FILE = "data.ser";
    private static Calendar dateCreator = Calendar.getInstance();

 public static void main(String [] args){
     String fileName;
     if (args.length == 1) {
         fileName = args[0];
     }
     else{
         fileName = DEFAULT_FILE;
     }
     serialize(fileName);
     }
     
public static void serialize(String fileName){
 try{
 serializeToFile(createData() , fileName);
 }
 catch (IOException exc) {
 exc.printStackTrace();
 }
 }

private static Serializable createData(){
    ArrayList appointments = new ArrayList ();
ArrayList contacts = new ArrayList();
contacts.add(new Contactlmpl("Test", "Subject", "Volunteer", "United Patterns Consortium"));
contacts.add(new Contactlmpl("AAA", "BBBB", "CCCC", "DDD"));
Location locationl = new Locationlmpl("Punxsutawney, PA");
 appointments.add(new Appointment("Slowpokes anonymous", contacts, locationl, createDate(2001, 1, 1, 12, 01), createDate(2001, 1, 1, 12, 02)));
 appointments.add(new Appointment("Java focus group", contacts, locationl, createDate(2001, 1, 1, 12, 30), createDate(2001, 1, 1, 14, 30)));
 appointments.add(new Appointment("Something else", contacts, locationl, createDate (2001, 1, 1, 12, 01), createDate(2001, 1, 1, 12, 02)));
 appointments.add(new Appointment("Yet another thingie", contacts, locationl, createDate(2001, 1, 1, 12, 01), createDate(2001, 1, 1, 12, 02)));
 return appointments;
 }

private static void serializeToFile(Serializable content, String fileName)
throws IOException{
 ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(fileName));
 serOut.writeObject(content);
 serOut.close();
 }
public static Date createDate(int year, int month, int day, int hour, int minute){
 dateCreator.set(year, month, day, hour, minute);
 return dateCreator.getTime();
 }
 }
