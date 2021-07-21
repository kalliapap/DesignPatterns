package gr.codehub.designpatterns.api;

import java.io.IOException;
import java.util.List;

public interface DataReader {

    List<String> getResult();

    String getFilename();

    void setFilename(String filename);

    //execute has to be void -> private list to access with getter
    void execute() throws IOException;
}
