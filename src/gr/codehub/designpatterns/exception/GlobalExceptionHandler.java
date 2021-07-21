package gr.codehub.designpatterns.exception;

import java.io.FileNotFoundException;

public class GlobalExceptionHandler {

    public static void handleException(Exception e) {
        System.out.println("There was an application error!");
        if( e instanceof FileNotFoundException) {
            System.out.println("You have not configured the files properly");
        }
        e.printStackTrace();
        System.out.println("The application will stop.");
        System.exit(1);
    }
}
