package com.a4v;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class a4DBoperation {

    public static void main(String[] args) {
        try {
            // Specify the Python script and command
            String pythonScriptPath = "C:/test/python_script.py";
            String command = "C:/Agent/Python/Python.exe " + pythonScriptPath;

            // Start the Python process
            ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
            Process process = processBuilder.start();

            // Get input from Java program
            String inputFromJava = " jai sri ram";
            System.out.println("Java input: " + inputFromJava);
            processBuilder.directory(new File("C:\\test"));
            // Send input to Python process
            process.getOutputStream().write(inputFromJava.getBytes());
            System.out.println("Java inpu1t: " + inputFromJava);
            process.getOutputStream().flush();
            processBuilder.redirectErrorStream(true);
            System.out.println("Java input2: " + inputFromJava);
            process.getOutputStream().write(inputFromJava.getBytes());
            System.out.println("Java input3: " + inputFromJava);
            process.getOutputStream().flush();
            System.out.println("Java input4: " + inputFromJava);
            // Read output from Python process
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println("Java input5: " + inputFromJava);
            String abc=reader.toString();
            System.out.println("Java input8: " + inputFromJava);
            System.out.println("Java input29: " + abc);
            try {
            	 System.out.println("Java input67: " + inputFromJava);
                String pythonOutput = reader.readLine();
                System.out.println("Java input68: " + inputFromJava);
                System.out.println("Python output: " + pythonOutput);
                // Process pythonOutput as needed
            } catch (IOException e) {
                e.printStackTrace();
            }
           // String pythonOutput = reader.readLine();
            System.out.println("Java input6: " + inputFromJava);
           // System.out.println("Python output: " + pythonOutput);

            // Wait for the Python process to finish
            int exitCode = process.waitFor();
        
            System.out.println("Python process exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("error is"+e);
        }
    }
}
