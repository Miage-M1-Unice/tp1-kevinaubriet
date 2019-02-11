package fr.unice.miage;

public class Main {
    public static void main(String[] args){


        MyFile fileTest =  new MyFile();

        fileTest.listFile();
        System.out.println("\n------------------------------\n");

        fileTest.listFile2(fileTest.getFile());
        System.out.println("\n------------------------------\n");

        // Liste filtrée dans une classe indépendante
        //fileTest.listFile3(fileTest.getFile());

        // Liste filtrée dans une classe interne nommée,
        fileTest.listFile3Interne(fileTest.getFile());






    }
}
