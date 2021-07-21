package gr.codehub.designpatterns.service;

import gr.codehub.designpatterns.api.DataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {
    //microservice

    private String filename;
    private List<String> result;

    public List<String> getResult() {
        return result;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    //execute has to be void -> private list to access with getter
    public void execute() throws IOException {
        result = readData();
    }

    private List<String> readData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
