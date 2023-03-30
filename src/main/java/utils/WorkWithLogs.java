package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Date;
import java.util.List;

public class WorkWithLogs {
    public static LogEntries logEntries;

    public static void printLogs(WebDriver webDriver) {
        if (logEntries == null) {
            logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        }
        for (LogEntry entry : logEntries) {
            //  System.out.println(entry.toJson());
            System.out.println(new Date(
                    entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage()
            );
        }
    }

    public static LogEntries getLogEntries(WebDriver webDriver) {
        if (logEntries == null) {
            return webDriver.manage().logs().get(LogType.BROWSER);
        }
        return logEntries;
    }


}
