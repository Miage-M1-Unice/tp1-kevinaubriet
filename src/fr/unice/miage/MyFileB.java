package fr.unice.miage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileB {

    private File file;

    public MyFileB() {
        this.file = new File(".");
    }

    public void setFileB(File file) {
        this.file = file;
    }

    public File getFileB() {
        return file;
    }

    public void listFile() throws IOException {

        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(
                    Path file,
                    BasicFileAttributes attrs) throws IOException {

                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(
                    Path dir,
                    IOException exc) throws IOException {

                //Files.delete(dir);
                System.out.println(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void listFileFilter(String filtre) throws IOException {
        Files.walkFileTree(file.toPath(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(
                    Path file,
                    BasicFileAttributes attrs) throws IOException {

                if(file.toString().endsWith(filtre)){
                    System.out.println(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(
                    Path dir,
                    IOException exc) throws IOException {

                if(dir.toString().endsWith(filtre)){
                    System.out.println(dir);
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }

}
