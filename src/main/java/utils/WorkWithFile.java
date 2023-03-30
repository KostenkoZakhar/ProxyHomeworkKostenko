package utils;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class WorkWithFile {
    public static void createFile(String fielName, LogEntries logEntries) {
        String name= new SimpleDateFormat("MMdd_HHmm").format(Calendar.getInstance().getTime()) +"_"+fielName;
        System.out.println(logEntries.getAll());
        File file = new File(name+".txt");
        FileWriter out=null;
        try {
            out=new FileWriter(file);
            for(LogEntry logEntry:logEntries){
                out.write(logEntry.getTimestamp() + " " + logEntry.getLevel().toString() + " " + logEntry.getMessage().toString()+"\n");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createFile(String fileName, List<String> stringList){
        String name= new SimpleDateFormat("MMdd_HHmm").format(Calendar.getInstance().getTime()) +"_"+fileName+".txt";

        File file = new File(name);
        FileWriter out=null;
        try {
            out=new FileWriter(file);
            for (String l:stringList){
                out.write(l+"\n");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String fileName, Map<String,String> map){
        String name= new SimpleDateFormat("MMdd_HHmm").format(Calendar.getInstance().getTime()) +"_"+fileName+".txt";

        File file = new File(name);
        FileWriter out=null;
        try {
            out=new FileWriter(file);
            for (Map.Entry<String, String> l: map.entrySet()){
                out.write("key = "+l.getKey()+" value = "+l.getValue()+"\n");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    File file = new File(name+".txt");
//    FileWriter out=null;
//        try {
//        out=new FileWriter(file);
//        for (String l:stringList){
//            out.write(l+"\n");
//        }
//        out.flush();
//        out.close();
}
