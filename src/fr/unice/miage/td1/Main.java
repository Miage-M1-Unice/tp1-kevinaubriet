package fr.unice.miage.td1;

import java.io.IOException;

public class Main {
    public static void main(String[] args){


        MyFile fileTest =  new MyFile();


        fileTest.listFile();

        System.out.println("\n--------------Question A----------------\n");
        fileTest.listFile2(fileTest.getFile());



        // Liste filtrée dans une classe indépendante
        //fileTest.listFile3(fileTest.getFile());

        // Liste filtrée dans une classe interne nommée,
        //fileTest.listFile3Interne(fileTest.getFile());

        //  Liste filtrée dans une classe anonyme
        //fileTest.listFile4anonyme(fileTest.getFile(),".java");


        System.out.println("\n--------------Question B----------------\n");
        MyFileB fileTestB =  new MyFileB();

        try {
            fileTestB.listFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n--------------Question B filtré----------------\n");

        try {
            fileTestB.listFileFilter(".java");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
