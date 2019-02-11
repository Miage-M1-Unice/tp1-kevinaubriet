package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {

    private String filtre;

    public MyFilenameFilter(String filtre) {
        this.filtre = filtre;
    }

    @Override
    public boolean accept(File dir, String name) {
        File file =  new File(dir.getPath() + "/" + name);
        return name.toLowerCase().endsWith(filtre) || file.isDirectory();
    }
}
