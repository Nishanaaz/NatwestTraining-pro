package com.natwest.fileCreationDemo1;

import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("xyz.txt");
//        System.out.println(fileReader.read());
//        System.out.println(fileReader.read());
//        System.out.println(fileReader.read());
//        System.out.println((char) fileReader.read());
//        int ch = fileReader.read();
//        while (ch!=-1){
//            System.out.println((char)ch);
//            ch = fileReader.read();  //we not to update the value of ch else it will give the same value.
//        }

        FileWriter fileWriter = new FileWriter("xyz.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Write a");
        bufferedWriter.newLine();
        bufferedWriter.write(" Poem Nisha");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();


        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());

        String ch1 =  bufferedReader.readLine();
        while (ch1!=null){
            System.out.println(ch1);
            ch1 = bufferedReader.readLine();  //we not to update the value of ch else it will give the same value.
        }

    }
}
