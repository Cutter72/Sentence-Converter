package pl.project.converter.xml;

import pl.project.converter.ConverterInterface;
import pl.project.converter.FileSentenceIterator;
import pl.project.model.Sentence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlConverterImpl implements ConverterInterface {

    @Override
    public void convert(File inputFile, File outputFile) {
        FileSentenceIterator fileSentenceIterator = new FileSentenceIterator(inputFile);
        XmlStreamWriterImpl xmlStreamWriterImpl = null;
        System.out.println("Rozpoczynanie konwersji do formatu XML.");
        try {
            xmlStreamWriterImpl = new XmlStreamWriterImpl(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        xmlStreamWriterImpl.startDocument();
        System.out.print("Konwertowanie do XML...");
        int i = 0;
        int sentenceQuantity = 0;
        int wordsQuantity = 0;
        while (fileSentenceIterator.hasNext()) {
            Sentence sentence = new Sentence();
            String originalText = fileSentenceIterator.next();
            if (Sentence.isValid(originalText)) {
                sentence.generate(originalText);
                if (sentence.getWordsList().size() > 0) {
                    xmlStreamWriterImpl.addSentence(sentence);
                    sentenceQuantity++;
                    wordsQuantity += sentence.getWordsList().size();
                    if (i % 100 == 0) {
                        System.out.print('.');
                        if (i % 5000 == 0) {
                            System.out.println();
                        }
                    }
                    i++;
                }
            }
        }
        xmlStreamWriterImpl.closeDocument();
        System.out.println("Konwertowanie do XML zakończone powodzeniem!");
        System.out.printf("Naliczono %d zdań i %d słów!%n", sentenceQuantity, wordsQuantity);
    }
}
