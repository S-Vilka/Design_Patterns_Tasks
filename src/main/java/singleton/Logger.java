package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String fileName = "log.txt";

    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Logger error: " + e.getMessage());
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        try {
            if (writer != null) writer.close();
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("File naming error: " + e.getMessage());
        }
    }

    public void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
