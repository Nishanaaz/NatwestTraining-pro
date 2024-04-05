package com.natwest.fileCreationDemo1;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWritePrint {
    public static void main(String[] args) throws IOException {
        PrintWriter printWrite = new PrintWriter("demo.txt");
        printWrite.write("hi");
        printWrite.write(98);
        printWrite.write(98);

        printWrite.flush();
        printWrite.close();


    }
}

