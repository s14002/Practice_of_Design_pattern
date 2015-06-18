package jp.ac.it_college.std.s14002.pdp.interpreter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by s14002 on 15/06/18.
 */
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " +node);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
