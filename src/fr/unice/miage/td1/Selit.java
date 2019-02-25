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

    void ecriture(String nomfichier) throws IOException {
        PrintStream ps = System.out;

        File file = new File("./"+nomfichier);
        file.createNewFile();

        Scanner sc = new Scanner(System.in);
        System.setOut(new PrintStream(file));
        System.out.println(sc.nextLine());

        System.setOut(ps);




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


        try {
            selit.ecriture("outpout.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
