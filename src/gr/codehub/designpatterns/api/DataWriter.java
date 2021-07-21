package gr.codehub.designpatterns.api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public interface DataWriter {

     void setLines(List<String> lines);

     void setFilename(String filename);

     List<String> getLines();

     String getFilename();

     void execute() throws IOException;


}
