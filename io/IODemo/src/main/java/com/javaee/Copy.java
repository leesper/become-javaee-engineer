package com.javaee;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Copy {
    public static void main(String[] args) {
        try {
            Files.copy(
                    Paths.get("pandas-de.jpg"),
                    new BufferedOutputStream(new FileOutputStream("pandas-new.jpg")));
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
