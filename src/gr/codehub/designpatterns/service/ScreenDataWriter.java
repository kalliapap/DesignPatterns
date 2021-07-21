package gr.codehub.designpatterns.service;

import gr.codehub.designpatterns.api.DataWriter;

import java.io.IOException;
import java.util.List;

public class ScreenDataWriter implements DataWriter {

    private List<String> lines;


    @Override
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void setFilename(String filename) {
        throw new RuntimeException("Invalid method call"); //kanonika prepei na spasei se neo interface
        //wste na mhn klironomei lathos methodous
    }

    @Override
    public List<String> getLines() {
        return lines;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public void execute() throws IOException {
        showLinesOnConsole();
    }


    private void showLinesOnConsole() {
        for (String s : lines) {
            System.out.println(s);
        }
    }
}
