package com.javaruntime;

import java.io.IOException;
import java.io.PrintStream;

public class RuntimeClass {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        Process process = runtime.exec("notepad"); //explorer, C:\Program Files\VideoLAN\VLC\vlc.exe
//        PrintStream ps=new PrintStream(process.getOutputStream());
//        ps.println();
//        Runtime.getRuntime().exec("shutdown -s -t 0");
//        Runtime.getRuntime().exec("c:\\Windows\\System32\\shutdown -s -t 0");
//        Runtime.getRuntime().exec("shutdown -r -t 0"); //restart
//        System.out.println("availableProcessors: "+Runtime.getRuntime().availableProcessors());
//        System.out.println("Total Memory: "+runtime.totalMemory());
//        System.out.println("Free Memory: "+runtime.freeMemory());
    }
}
