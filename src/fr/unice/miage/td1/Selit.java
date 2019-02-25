package fr.unice.miage.td1;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Selit {

    void lecture(Scanner source) {

        while(source.hasNextLine()) {
            String s = source.nextLine();


            if(!s.trim().startsWith("//")) {
                System.out.println("LU: " + s);
            }

                    // A modifier
        }
    }

    static public void main(String[] args) {

        Selit selit = new Selit();
        File file =new File("./src/fr/unice/miage/td1/Selit.java");
        try {
            Scanner scanner = new Scanner(file);
            selit.lecture(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
