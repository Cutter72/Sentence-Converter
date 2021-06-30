package pl.project.converter.xml;

import org.junit.Test;
import pl.project.model.Sentence;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XmlStreamWriterImplTest {

    @Test
    public void startDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_XmlStreamWriter.startDocument").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_XmlStreamWriter.startDocument").toAbsolutePath();
        XmlStreamWriterImpl xmlStreamWriterImpl = null;
        try {
            xmlStreamWriterImpl = new XmlStreamWriterImpl(new FileOutputStream(outputFile.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        xmlStreamWriterImpl.startDocument();
        List<String> actual = null;
        try {
            actual = Files.readAllLines(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void addSentence() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_XmlStreamWriter.addSentence").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_XmlStreamWriter.addSentence").toAbsolutePath();
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(outputFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        XmlStreamWriterImpl xmlStreamWriterImpl;
        xmlStreamWriterImpl = new XmlStreamWriterImpl(outputStream);

        Sentence sentenceA = new Sentence();
        List<String> wordListA = new ArrayList<>();
        wordListA.add("Love");
        wordListA.add("is");
        wordListA.add("everything");
        wordListA.add("you");
        wordListA.add("need");
        sentenceA.setWordList(wordListA);

        Sentence sentenceB = new Sentence();
        List<String> wordListB = new ArrayList<>();
        wordListB.add("Be");
        wordListB.add("yourself");
        sentenceB.setWordList(wordListB);


        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when

        xmlStreamWriterImpl.addSentence(sentenceA);
        xmlStreamWriterImpl.addSentence(sentenceB);
        List<String> actual = null;
        try {
            actual = Files.readAllLines(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void closeDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_XmlStreamWriter.closeDocument").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_XmlStreamWriter.closeDocument").toAbsolutePath();
        XmlStreamWriterImpl xmlStreamWriterImpl = null;
        try {
            xmlStreamWriterImpl = new XmlStreamWriterImpl(new FileOutputStream(outputFile.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //when
        xmlStreamWriterImpl.closeDocument();
        List<String> actual = null;
        try {
            actual = Files.readAllLines(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(expected, actual);
    }
}