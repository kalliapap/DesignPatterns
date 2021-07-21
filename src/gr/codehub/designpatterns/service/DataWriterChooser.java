package gr.codehub.designpatterns.service;

import gr.codehub.designpatterns.api.DataWriter;

import java.util.List;

public class DataWriterChooser { //factory

    public static DataWriter selectDataWriter() {
        //if(Math.random() >= 1.0) {
            return new FileDataWriter();
//        }else {
//            return new ScreenDataWriter();
//        }
    }
}
