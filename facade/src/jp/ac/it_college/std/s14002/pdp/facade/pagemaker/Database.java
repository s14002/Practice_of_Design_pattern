package jp.ac.it_college.std.s14002.pdp.facade.pagemaker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by s14002 on 15/06/16.
 */
public class Database {
    private Database() {
    }
    public static Properties getProperties(String dbname) {

        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
