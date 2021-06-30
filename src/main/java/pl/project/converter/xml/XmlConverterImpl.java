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

        try {
            xmlStreamWriterImpl = new XmlStreamWriterImpl(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        xmlStreamWriterImpl.startDocument();
        while (fileSentenceIterator.hasNext()) {
            Sentence sentence = new Sentence();
            String originalText = fileSentenceIterator.next();
            if (Sentence.isValid(originalText)) {
                sentence.prepareSentence(originalText);
                xmlStreamWriterImpl.addSentence(sentence);
            }
        }
        xmlStreamWriterImpl.closeDocument();
    }
}
