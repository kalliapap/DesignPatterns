package gr.codehub.designpatterns.app;

import gr.codehub.designpatterns.api.DataReader;
import gr.codehub.designpatterns.api.DataWriter;
import gr.codehub.designpatterns.exception.GlobalExceptionHandler;
import gr.codehub.designpatterns.service.DataWriterChooser;
import gr.codehub.designpatterns.service.FileDataReader;
import gr.codehub.designpatterns.service.FileDataWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainNew {
    private static final String ROOT = "resources\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        processDataAndExceptions();
        System.out.println("Processing completed");
    }

    private static void processDataAndExceptions() {
        try {
            processAllData();
        } catch (IOException e) {
            GlobalExceptionHandler.handleException(e);
        }
    }

    private static void processAllData() throws IOException {
        List<String> lines = readData();
        if (!isEnglish(lines)) { // edw
            System.out.println("No english text, no processing done");
            System.exit(1);
        }
        List<String> newLines = convert(lines);

        writeData(newLines);

    }

    private static List<String> convert(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for(String s : lines) {
            newLines.add(s.toUpperCase());
        }
        return newLines;
    }

    private static boolean isEnglish(List<String> lines) {
        String line = lines.get(0).toLowerCase();
        return line.contains("e") ||
                line.contains("t") ||
                line.contains("a") ||
                line.contains("o");
    }

    private static List<String> readData() throws IOException {
        DataReader dr = new FileDataReader();
        dr.setFilename(ROOT + "input.txt");
        dr.execute();
        List<String> lines = dr.getResult();
        return lines;
    }

    private static void writeData(List<String> lines) throws IOException {
        DataWriter dw = DataWriterChooser.selectDataWriter(); // Factory pattern
        dw.setLines(lines);
        dw.setFilename(ROOT + "output.txt");
        dw.execute();
    }

}
