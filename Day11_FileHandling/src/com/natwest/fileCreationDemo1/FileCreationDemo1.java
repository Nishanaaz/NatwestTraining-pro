package com.natwest.fileCreationDemo1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreationDemo1 {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");

      /*  File file = new File("C:\\Users\\RBS\\Downloads\\Python Assessment\\abc.txt");
        if (file.exists()) System.out.println("File is present");
        else {
            file.createNewFile();
            System.out.println("file is not present");

            }
       */

        //File file = new File("Movies");
        //file.mkdir();
       // file.delete();

        FileWriter fileWriter = new FileWriter("xyz.txt");
        fileWriter.write("hello");
        fileWriter.write(67);  //it will take its ascii value
        fileWriter.flush();  //data jaega
        //
        // fileWriter.close();

    }
}
