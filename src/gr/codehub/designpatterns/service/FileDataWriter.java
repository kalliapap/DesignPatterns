package gr.codehub.designpatterns.service;

import gr.codehub.designpatterns.api.DataWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter implements DataWriter {

    private List<String> lines;
    private String filename;

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<String> getLines() {
        return lines;
    }

    public String getFilename() {
        return filename;
    }

    public void execute() throws IOException {
        writeData();
    }

    private void writeData() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(filename)));
        for (String s : lines)
            writer.write(s + "\n");
        writer.close();
    }


}
