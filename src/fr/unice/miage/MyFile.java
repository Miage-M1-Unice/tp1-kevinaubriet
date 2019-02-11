package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.logging.Filter;

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

    public void listFile(){
        for (String elem:this.file.list()) {
            System.out.println(elem);
        }
    }

    public void listFile2(File chemin){
        for (File elem:chemin.listFiles()) {
            if(elem.isDirectory()){
                listFile2(elem);
                System.out.println(elem);
            }else{
                System.out.println(elem);
            }

        }
    }

    public void listFile3(File chemin){
       MyFilenameFilter filter =  new MyFilenameFilter(".java");
        for (File elem:chemin.listFiles(filter)) {
            if(elem.isDirectory()){
                listFile3(elem);
            }else{
                System.out.println(elem);
            }

        }
    }

    public void listFile3Interne(File chemin){
        MyInterneFilenameFilter filter =  new MyInterneFilenameFilter(".java");
        for (File elem:chemin.listFiles(filter)) {
            if(elem.isDirectory()){
                listFile3(elem);
            }else{
                System.out.println(elem);
            }

        }
    }

    // classe interne
    private class MyInterneFilenameFilter implements FilenameFilter{
        private String filtre;

        public MyInterneFilenameFilter(String filtre) {
            this.filtre = filtre;
        }

        @Override
        public boolean accept(File dir, String name) {
            File file =  new File(dir.getPath() + "/" + name);
            return name.toLowerCase().endsWith(filtre) || file.isDirectory();
        }
    }



}
