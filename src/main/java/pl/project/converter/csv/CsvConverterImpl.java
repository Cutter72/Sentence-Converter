package pl.project.converter.csv;

import pl.project.converter.ConverterInterface;
import pl.project.converter.FileSentenceIterator;
import pl.project.converter.WordCounter;
import pl.project.model.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CsvConverterImpl implements ConverterInterface {

    @Override
    public void convert(File inputFile, File outputFile) {
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(inputFile);
        CsvStreamWriterImpl csvStreamWriterImpl = null;

        try {
            csvStreamWriterImpl = new CsvStreamWriterImpl(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        csvStreamWriterImpl.startDocument(new WordCounter().findMaxNumberOfWordsInSentence(inputFile));
        while (fileSentenceIterator.hasNext()) {
            Sentence sentence = new Sentence();
            String originalText = fileSentenceIterator.next();
            if (Sentence.isValid(originalText)) {
                sentence.prepareSentence(originalText);
                csvStreamWriterImpl.addSentence(sentence);
            }
        }
    }
}
