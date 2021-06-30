package pl.project.converter.csv;

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

public class CsvStreamWriterImplTest {

    @Test
    public void startDocument() {
        //given
        Path outputFile = Paths.get("src/main/resources/test_data/actual_CsvStreamWriter.startDocument").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_CsvStreamWriter.startDocument").toAbsolutePath();
        CsvStreamWriterImpl csvStreamWriter = null;
        try {
            csvStreamWriter = new CsvStreamWriterImpl(new FileOutputStream(outputFile.toFile()));
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
        csvStreamWriter.startDocument(5);
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
        Path outputFile = Paths.get("src/main/resources/test_data/actual_CsvStreamWriter.addSentence").toAbsolutePath();
        Path expectedFile = Paths.get("src/main/resources/test_data/expected_CsvStreamWriter.addSentence").toAbsolutePath();
        CsvStreamWriterImpl csvStreamWriter = null;
        try {
            csvStreamWriter = new CsvStreamWriterImpl(new FileOutputStream(outputFile.toFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> expected = null;
        try {
            expected = Files.readAllLines(expectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        //when
        csvStreamWriter.addSentence(sentenceA);
        csvStreamWriter.addSentence(sentenceB);
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