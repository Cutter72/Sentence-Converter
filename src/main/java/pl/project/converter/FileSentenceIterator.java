package pl.project.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class FileSentenceIterator implements Iterator<String> {
    private final Scanner scanner;

    public FileSentenceIterator(File inputFile) {
        try {
            scanner = new Scanner(inputFile);
            scanner.useDelimiter("(?<!Mr|Ms|Dr)[.?!]");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        return scanner.next();
    }

}