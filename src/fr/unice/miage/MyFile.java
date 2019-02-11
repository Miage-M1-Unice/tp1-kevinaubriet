package fr.unice.miage;

import java.io.File;

public class MyFile {

    private File file;

    public MyFile() {
        this.file = new File(".");
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    private void listFile(){
        for (String elem:this.file.list()) {
            System.out.println(elem);
        }
    }

    private void listFile2(File chemin){
        for (File elem:chemin.listFiles()) {
            if(elem.isDirectory()){
                listFile2(elem);
                System.out.println(elem);
            }else{
                System.out.println(elem);
            }

        }
    }


    public static void main(String[] args){


        MyFile fileTest =  new MyFile();

        fileTest.listFile();
        System.out.println("\n------------------------------\n");
        fileTest.listFile2(fileTest.getFile());




    }
}
