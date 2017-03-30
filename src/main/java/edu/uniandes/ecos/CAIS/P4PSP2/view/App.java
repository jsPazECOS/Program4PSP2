package edu.uniandes.ecos.CAIS.P4PSP2.view;

import edu.uniandes.ecos.CAIS.P4PSP2.controller.Program;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Program programa4 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        programa4.readFiles(path);
        programa4.showResults();
        
        
    }
}
